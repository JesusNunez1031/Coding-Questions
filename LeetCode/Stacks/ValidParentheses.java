import java.util.HashMap;
import java.util.Map;
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

    static Map<Character, Character> map = new HashMap<>();

    //TC: O(n) time and no use of stack
    public static boolean isValidEz(String s) {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        //variable used to simulate pointing to the "top" of the stack
        int top = -1;   //-1 to singal an empty stack

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //if c is an open parenthesis, move the top to i, this simulates adding to a stack by pointing top to most recent open parenthesis
            if (map.containsValue(c)) {
                top = i;
            } else {
                /*
                    if c is a closing parenthesis, return false if the "stack" is empty, top == -1, or if the current
                    parenthesis counter part it not at the top of the stack.
                    Ex: ()
                    top = 0 points to "("

                    when we get to ")", the stack is not empty since top = 0, and value of ")" -> "(" and that is equal to the
                    character s[top] so we look for the new top of the stack
                */
                if (top == -1 || map.get(c) != s.charAt(top)) {
                    return false;
                } else {
                    //simulate popping from a stack by searching from s[0] to s[top - 1]
                    top = getTop(s, top - 1);
                }
            }
        }
        //if top == -1, this means the stack is empty
        return top == -1;
    }

    private static int getTop(String s, int right) {
        int left = 0;
        while (right >= 0) {
            char c = s.charAt(right);
            //check if c is a closing parentheses
            if (map.containsKey(c)) {
                left++;
            } else {
                left--;
            }
            /*
                when left == -1, that means we have encountered more open parenthesis than closing which means we are
                at the top of the stack
             */
            if (left < 0) {
                return right;
            }
            //reduce window
            right--;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isValidEz("({[{}]})"));
    }
}
