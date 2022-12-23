package leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class generateParentheses {
    /*
    Given n pairs of parentheses, write a function to generate all leetCode.backtracking.combinations of well-formed parentheses.

    Example 1:
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]

    Example 2:
    Input: n = 1
    Output: ["()"]

    Constraints:
        1 <= n <= 8
     */
    //TC: O(4^n / sqrt(n)) and space
    public List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<>();

        generateValidParenthesis(n, parentheses, new StringBuilder(), 0, 0);

        return parentheses;
    }

    private void generateValidParenthesis(int n, List<String> parentheses, StringBuilder sb, int open, int close) {
        /*
            A valid set of parenthesis has an equal counter part count for every opening brace, Ex: if we have "(("
            then we also need "))" to make it a valid set. So we check if the length of the current string is double that
            of n.
         */
        if (sb.length() == n * 2) {
            parentheses.add(sb.toString());
            return;
        }

        /*
            if open is greater than n, we need to add closing braces to make the current set of opening braces valid
         */
        if (open < n) {
            sb.append("(");
            open += 1;
            //System.out.println(sb.toString());  //see the current parenthesis being formed
            generateValidParenthesis(n, parentheses, sb, open, close);
            open -= 1;
            sb.setLength(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            close += 1;
            //System.out.println(sb.toString());  //see the current parenthesis being formed
            generateValidParenthesis(n, parentheses, sb, open, close);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        generateParentheses t = new generateParentheses();
        System.out.println(t.generateParenthesis(1).toString());
    }
}
