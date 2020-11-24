import java.util.Stack;

public class ValidParentheses {
    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

    Example 1:
    Input: s = "()"
    Output: true

    Example 2:
    Input: s = "()[]{}"
    Output: true

    Example 3:
    Input: s = "(]"
    Output: false

    Example 4:
    Input: s = "([)]"
    Output: false

    Example 5:
    Input: s = "{[]}"
    Output: true

    Constraints:
        1 <= s.length <= 104
        s consists of parentheses only '()[]{}'
     */

    private static boolean isValid(String s) {
        //if the length is odd, there is no way it is valid
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            if (p == '(' || p == '{' || p == '[') {
                stack.push(p);
            } else if ((p == ')' || p == '}' || p == ']') && stack.isEmpty()) {
                return false;
            } else {
                if (!stack.isEmpty()) {

                    if (p == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (p == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (p == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(){][)"));
    }
}
