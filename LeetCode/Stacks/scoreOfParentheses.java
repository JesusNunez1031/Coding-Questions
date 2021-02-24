import java.util.Stack;

public class scoreOfParentheses {
    /*
    Given a balanced parentheses string S, compute the score of the string based on the following rule:
        - () has score 1
        - AB has score A + B, where A and B are balanced parentheses strings.
        - (A) has score 2 * A, where A is a balanced parentheses string.

    Example 1:
    Input: "()"
    Output: 1

    Example 2:
    Input: "(())"
    Output: 2

    Example 3:
    Input: "()()"
    Output: 2

    Example 4:
    Input: "(()(()))"
    Output: 6

    Note:
        S is a balanced parentheses string, containing only ( and ).
        2 <= S.length <= 50
     */
    public int scoreOfParentheses(String S) {
        int score = 0;
        Stack<Integer> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            int current_score = 0;
            //push a value at the start of a parenthesis
            if (c == '(') {
                stack.push(0);
            } else {
                //at a closing parenthesis add all the inner parentheses scores
                while (stack.peek() != 0) {
                    current_score += stack.pop();
                }
                /*
                    if we are calculating the score of nested parenthesis, the current score will be the max of 2 * current_score
                    or just 1 if the pair is not nested since current_score by default is 0

                    Pop the 0 in the stack that represents the start of a pair and then push the current_score that is
                    calculated at the end of a pair
                */
                current_score = Math.max(2 * current_score, 1);
                stack.pop();
                stack.push(current_score);
            }
        }
        //the resulting values in the stack will hold all scores
        while (!stack.isEmpty()) {
            score += stack.pop();
        }
        return score;
    }
}
