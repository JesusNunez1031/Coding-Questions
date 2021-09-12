import java.util.Stack;

public class BasicCalculator {
    /*
    Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result
    of the evaluation.

    Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as
    eval().

    Example 1:
    Input: s = "1 + 1"
    Output: 2

    Example 2:
    Input: s = " 2-1 + 2 "
    Output: 3

    Example 3:
    Input: s = "(1+(4+5+2)-3)+(6+8)"
    Output: 23

    Constraints:
        1 <= s.length <= 3 * 10^5
        s consists of digits, '+', '-', '(', ')', and ' '.
        s represents a valid expression.
        '+' is not used as a unary operation.
        '-' could be used as a unary operation, but it has to be inside parentheses.
        There will be no two consecutive operators in the input.
        Every number and running calculation will fit in a signed 32-bit integer.
     */
    //TC: O(n) where n is the length of s
    public int calculate(String s) {
        int sign = 1; // only + and - so we can represent signs as -1 or 1, 1 is default
        int currentNum = 0; // current number in the sequence
        int result = 0;
        int n = s.length();

        Stack<Integer> stack = new Stack<>(); // hold's values outside of parentheses

        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                currentNum = s.charAt(i) - '0';

                // continue forming the current num if the next characters are also number values
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    currentNum = currentNum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }

                // set the sign of the current number
                currentNum *= sign;
                sign = 1; // reset sign
                result += currentNum; // add to the final result

                // no need to reset the current number as next iteration it'll be reset to the new digit(s)
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                // store the result and the sign calculated so far in the stack to begin calculating parenthesis values
                stack.push(sign);
                stack.push(result);
                // reset values for parenthesis values
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') { // the parenthesis result has been calculated, so add it to the total result
                // add the parenthesis result to the total result
                int outerResult = stack.pop();
                int prevSign = stack.pop();

                result *= prevSign;
                result += outerResult;
            }
        }
        return result;
    }
}
