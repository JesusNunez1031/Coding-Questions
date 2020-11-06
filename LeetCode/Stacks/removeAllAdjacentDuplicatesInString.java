import java.util.Stack;

public class removeAllAdjacentDuplicatesInString {
    /*
    Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
    We repeatedly make duplicate removals on S until we no longer can.

    Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

    Example 1:
    Input: "abbaca"
    Output: "ca"
    Explanation:
    For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
    The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
     */

    public String removeDuplicates(String s) {
        if (s.length() == 1) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {

            //add character to the stack and append it to StringBuilder
            if (stack.isEmpty()) {
                stack.push(c);
                sb.append(c);
            //If the top of stack is not equal to the current character, add it to stack and StringBuilder
            } else if (stack.peek() != c) {
                stack.push(c);
                sb.append(c);
            //If the top and current character are equal, remove them from stringBuilder and stack
            } else {
                stack.pop();
                //remove last character in sb by reducing its length by 1
                sb.setLength(sb.length() - 1);  //setLength(sb.length() - 1); is preferable as it just assign the last value to '\0' whereas deleting last character with .deleteCharAt(sb.length() - 1); does System.arraycopy
            }
        }
        return sb.toString();
    }
}
