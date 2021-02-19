public class minimumRemoveToMakeValidParentheses {
    /*
    Given a string s of '(' , ')' and lowercase English characters.
    Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting
    parentheses string is valid and return any valid string.

    Formally, a parentheses string is valid if and only if:
        - It is the empty string, contains only lowercase characters, or
        - It can be written as AB (A concatenated with B), where A and B are valid strings, or
        - It can be written as (A), where A is a valid string.

    Example 1:
    Input: s = "lee(t(c)o)de)"
    Output: "lee(t(c)o)de"
    Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

    Example 2:
    Input: s = "a)b(c)d"
    Output: "ab(c)d"

    Example 3:
    Input: s = "))(("
    Output: ""
    Explanation: An empty string is also valid.

    Example 4:
    Input: s = "(a(b(c)d)"
    Output: "a(b(c)d)"

    Constraints:
        1 <= s.length <= 10^5
        s[i] is one of  '(' , ')' and lowercase English letters.
     */
    //TC/S: O(n) & O(n) space due to StringBuilder use
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        char[] str = s.toCharArray();

        int oppPar = 0;
        /*
            scan the string from left to right marking closing parenthesis that need to be deleted. When an open parenthesis
            is encountered, we increase the count of opposite Parenthesis needed to make s valid. When a closing Parenthesis
            is encountered, if the count is greater than 0, decrease the count since we found a pair, otherwise, there is
            no open for the close so mark it for deletion
        */
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                oppPar++;
            } else if (str[i] == ')') {
                if (oppPar > 0) {
                    oppPar--;
                } else {
                    str[i] = 0;
                }
            }
        }

        oppPar = 0;
        //scan string from right to left and perform the same operations as before but for closing parenthesis
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] == ')') {
                oppPar++;
            } else if (str[i] == '(') {
                if (oppPar > 0) {
                    oppPar--;
                } else {
                    str[i] = 0;
                }
            }
        }

        //generate the new string now that all invalid parenthesis are marked
        for (char c : str) {
            if (c != 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
