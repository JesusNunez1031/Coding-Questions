import java.util.Stack;

public class EvaluateReversePolishNotation {
    /*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.

    Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

    Note that division between two integers should truncate toward zero.

    It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a
    result, and there will not be any division by zero operation.

    Example 1:
    Input: tokens = ["2","1","+","3","*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9

    Example 2:
    Input: tokens = ["4","13","5","/","+"]
    Output: 6
    Explanation: (4 + (13 / 5)) = 6

    Example 3:
    Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
    Output: 22
    Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
    = ((10 * (6 / (12 * -11))) + 17) + 5
    = ((10 * (6 / -132)) + 17) + 5
    = ((10 * 0) + 17) + 5
    = (0 + 17) + 5
    = 17 + 5
    = 22

    Constraints:
        1 <= tokens.length <= 104
        tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
     */
    //TC/S: O(n)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {
            //when a sign appears, the left will be the second popped value from the stack and the right is the first
            int right, left;
            switch (t) {
                case "+":
                    right = stack.pop();
                    left = stack.pop();
                    //add the new calculated value back to the stack
                    stack.push(left + right);
                    break;
                case "-":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left - right);
                    break;
                case "*":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left * right);
                    break;
                case "/":
                    right = stack.pop();
                    left = stack.pop();
                    stack.push(left / right);
                    break;
                default:
                    //if the current string t is not a sign it must be an integer hence we add it to the stack
                    stack.push(Integer.parseInt(t));
            }
        }
        //since we are guaranteed that the given RPN expression is always valid, the last value in the stack is the solution
        return stack.pop();
    }
}
