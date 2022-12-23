package leetCode.stacks;

public class longestValidParentheses {
    /*
    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
    parentheses substring.

    Example 1:
    Input: s = "(()"
    Output: 2
    Explanation: The longest valid parentheses substring is "()".

    Example 2:
    Input: s = ")()())"
    Output: 4
    Explanation: The longest valid parentheses substring is "()()".

    Example 3:
    Input: s = ""
    Output: 0

    Constraints:
        0 <= s.length <= 3 * 10^4
        s[i] is '(', or ')'.
     */
    //TC: O(n) and constant space
    public int longestValidParentheses(String s) {
        //variables to hold the number of closed and open parentheses
        int open = 0, close = 0;
        int maxLen = 0;

        //look for open parentheses from the start of s
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            //when both values are equal this indicates a valid parentheses has been found so we update maxLen
            if (open == close) {
                maxLen = Math.max(maxLen, open + close);
            }
            //when an imbalance occurs, i.e. theres more close than open, we reset the values to start new search
            else if (close > open) {
                close = open = 0;
            }
        }

        //reset the variables for reverse search
        close = open = 0;

        //look for close parentheses from the end of s
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                close++;
            } else {
                open++;
            }

            //update maxLen when a valid parentheses has been found
            if (open == close) {
                maxLen = Math.max(maxLen, open + close);
            }
            //reset values when an imbalance occurs
            else if (open > close) {
                close = open = 0;
            }
        }
        return maxLen;
    }
}
