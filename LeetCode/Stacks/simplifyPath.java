import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class simplifyPath {
    /*
    Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style
    file system, convert it to the simplified canonical path.

    In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the
    directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this
     problem, any other format of periods such as '...' are treated as file/directory names.

    The canonical path should have the following format:
        - The path starts with a single slash '/'.
        - Any two directories are separated by a single slash '/'.
        - The path does not end with a trailing '/'.
        - The path only contains the directories on the path from the root directory to the target file or directory
          (i.e., no period '.' or double period '..')
    Return the simplified canonical path.

    Example 1:
    Input: path = "/home/"
    Output: "/home"
    Explanation: Note that there is no trailing slash after the last directory name.

    Example 2:
    Input: path = "/../"
    Output: "/"
    Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

    Example 3:
    Input: path = "/home//foo/"
    Output: "/home/foo"
    Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

    Example 4:
    Input: path = "/a/./b/../../c/"
    Output: "/c"

    Constraints:
        1 <= path.length <= 3000
        path consists of English letters, digits, period '.', slash '/' or '_'.
        path is a valid absolute Unix path.
     */
    //TC/S: O(n)
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return "/";
        }
        Stack<String> stack = new Stack<>();

        //turn the path into an array and split remove all the "/"
        String[] abPath = path.split("/");

        for (String dir : abPath) {
            if (dir.equals(".")) {   //a "." tells us to stay in the current directory so we don't do nothing
                continue;
            } else if (dir.equals("..") && !stack.isEmpty()) {   //a ".." tells us to move back one directory so we pop the most recent directory
                stack.pop();
            } else if (!dir.equals("") && !dir.equals("..")) { //only add the directory to stack if its not empty, and not ".." since the .split might leave empty spaces
                stack.push(dir);    //add the directory into the stack
            }
        }

        //return root directory if there are no directories left in the stack
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder canonical_path = new StringBuilder();

        //since the directories in the stack are in reverse, insert popped directories at the start of the canonical_path
        while (!stack.isEmpty()) {
            canonical_path.insert(0, stack.pop()).insert(0, "/");
        }
        return canonical_path.toString();
    }

    public String simplifyPathEz(String path) {
        //return root directory if path is empty
        if (path.length() == 0) {
            return "/";
        }

        //using a deque will allow the removal of items from the end
        Deque<String> deque = new LinkedList<>();

        //turn the path into an array and remove all the "/" in the path
        String[] abPath = path.split("/");

        for (String dir : abPath) {
            if (dir.equals(".")) {   //a "." tells us to stay in the current directory so we don't do nothing
                continue;
            } else if (dir.equals("..") && !deque.isEmpty()) {  //a ".." tells us to move up one directory so we remove the most recent directory
                deque.removeFirst();
            } else if (!dir.equals("") && !dir.equals("..")) { //only add the directory to deque if its not empty, and not ".." since the .split might leave empty spaces
                deque.push(dir);    //add the directory to the front of the deque
            }
        }

        //return root directory if there are no directories left in the deque
        if (deque.isEmpty()) {
            return "/";
        }

        StringBuilder canonical_path = new StringBuilder();

        //since we can remove from the end in a deque, we can append to the canonical_path from the end
        while (!deque.isEmpty()) {
            canonical_path.append("/").append(deque.removeLast());
        }
        return canonical_path.toString();
    }
}
