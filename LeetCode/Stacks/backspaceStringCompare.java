import java.util.Stack;

public class backspaceStringCompare {
    /*
    Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
    Note that after backspacing an empty text, the text will continue empty.

    Example 1:
    Input: S = "ab#c", T = "ad#c"
    Output: true
    Explanation: Both S and T become "ac".

    Example 2:
    Input: S = "ab##", T = "c#d#"
    Output: true
    Explanation: Both S and T become "".

    Example 3:
    Input: S = "a##c", T = "#a#c"
    Output: true
    Explanation: Both S and T become "c".

    Example 4:
    Input: S = "a#c", T = "b"
    Output: false
    Explanation: S becomes "c" while T becomes "b".

    Note:
        1 <= S.length <= 200
        1 <= T.length <= 200
        S and T only contain lowercase letters and '#' characters.

    Follow up:
        Can you solve it in O(N) time and O(1) space?
     */

    //Intuitive approach using O(n) space with a stack
    private static boolean backspaceCompare(String S, String T) {
        String s = getStr(S);
        String t = getStr(T);

        return s.equals(t);
    }

    private static String getStr(String str) {

        int i = 0;
        //get rid of initial backspaces in the given string
        while (str.charAt(i) == '#') {
            i++;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        while (i < str.length()) {
            /*
                Every time we encounter a letter, we add it to the stack, when a backspace '#' is encountered, to simulate
                deletion, the top character from the stack is popped
            */
            if (Character.isLetter(str.charAt(i))) {
                stack.add(str.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            i++;
        }

        //iterate through the stack of characters and append them to the SB to return the resulting string
        for (char c : stack) {
            sb.append(c);
        }

        //String.valueOf(stack); can also be used to convert all the characters in the stack to one string
        return sb.toString();
    }

    //Another method to get the modified string only using a string builder
    private String genString(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length();i++) {
            char c = str.charAt(i);
            if(c == '#') {
                int newLen = sb.length() - 1;
                sb.setLength(Math.max(newLen, 0));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //Two pointer approach using constant space
    private boolean backspaceCompareT(String s, String t) {
        //pointers for each of the given strings ends
        int s_ptr = s.length() - 1;
        int t_ptr = t.length() - 1;

        //variables for the skips we need to make if we see a backspace '#'. Rather than delete the character, we skip over it
        int s_skips = 0;
        int t_skips = 0;

        while (s_ptr >= 0 || t_ptr >= 0) {
            /*
                for both strings, if we encounter a backspace '#', we need to increment skips and if skips is greater than
                0, we also skip the next character down to simulate deletion
            */
            while (s_ptr >= 0) {
                //backspace so we increment the skips and move down one
                if (s.charAt(s_ptr) == '#') {
                    s_skips++;
                    s_ptr--;
                    //if skips is not 0, we need to skip the current character, reduce skips and skip the current character by decrementing pointer
                } else if (s_skips > 0) {
                    s_skips--;
                    s_ptr--;
                    //if the current character is not a backspace and we don't need to delete anything, break, we will reduce pointers at the end
                } else {
                    break;
                }
            }

            //this loop works the same as the previous
            while (t_ptr >= 0) {
                if (t.charAt(t_ptr) == '#') {
                    t_skips++;
                    t_ptr--;
                } else if (t_skips > 0) {
                    t_skips--;
                    t_ptr--;
                } else {
                    break;
                }
            }

            //check if the character at the current pointer s is equal to the one in t, if they arent, the strings don't match
            if (s_ptr >= 0 && t_ptr >= 0 && s.charAt(s_ptr) != t.charAt(t_ptr)) {
                return false;
            }

            //if one pointer hits the end before the other, the strings wont be the same
            if ((s_ptr >= 0) != (t_ptr >= 0)) {
                return false;
            }
            s_ptr--;
            t_ptr--;
        }
        //if the strings match, both pointers should be at the start of the string
        return s_ptr == t_ptr;
    }
}
