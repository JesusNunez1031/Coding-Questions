import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpressionAddOperators {
    /*
    Given a string num that contains only digits and an integer target, return all possibilities to add the binary
    operators '+', '-', or '*' between the digits of num so that the resultant expression evaluates to the target value.

    Example 1:
    Input: num = "123", target = 6
    Output: ["1*2*3","1+2+3"]

    Example 2:
    Input: num = "232", target = 8
    Output: ["2*3+2","2+3*2"]

    Example 3:
    Input: num = "105", target = 5
    Output: ["1*0+5","10-5"]

    Example 4:
    Input: num = "00", target = 0
    Output: ["0*0","0+0","0-0"]

    Example 5:
    Input: num = "3456237490", target = 9191
    Output: []

    Constraints:
    1 <= num.length <= 10
    num consists of only digits.
    -2^31 <= target <= 2^31 - 1
     */
    //TC: O(4^n)
    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {
            return Collections.emptyList();
        }
        List<String> operations = new ArrayList<>();

        genOp(operations, new StringBuilder(), num, target, 0, 0, 0);

        return operations;
    }

    private void genOp(List<String> op, StringBuilder expression, String num, int target, int pos, long eval, long prevNum) {
        // if all numbers have been exhausted, check if the evaluated expression equals the target
        if (pos == num.length()) {
            if (eval == target) {
                op.add(expression.toString());
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            // skip leading 0's
            if (i > pos && num.charAt(pos) == '0') {
                break;
            }
            // get the current number
            long curNum = Long.parseLong(num.substring(pos, i + 1));
            int len = expression.length(); // save the length of the expression at the start to update it when backtracking

            // start of expression so only the current number needs to get passed without an operator
            if (pos == 0) {
                genOp(op, expression.append(curNum), num, target, i + 1, curNum, curNum);
                expression.setLength(len);

            } else {
                // use addition with the current number
                genOp(op, expression.append("+").append(curNum), num, target, i + 1, eval + curNum, curNum);
                expression.setLength(len);

                // use subtraction with the current number
                genOp(op, expression.append("-").append(curNum), num, target, i + 1, eval - curNum, -curNum);
                expression.setLength(len);

                /*
                    Multiplication has the highest precedence so to properly evaluate an expression, we subtract the
                    prev value used to the current evaluated expression and then add to it the product of the current
                    number with the prev number, i.e. the current expression therefore keeping proper precedence of signs

                    Ex: if our expression is 7 + 3 * 2
                    when we get to 2, the evaluated value is 10 so far, if we just multiply 10 * 2 we get the wrong answer
                    of 20, so we need to subtract the prev value 3 from 10 to get 7, then multiply 3 * 2 and add 7 + 6
                    to get the right evaluation of 13
                 */
                genOp(op, expression.append("*").append(curNum), num, target, i + 1, eval - prevNum + prevNum * curNum, prevNum * curNum);
                expression.setLength(len);
            }
        }
    }
}
