public class splitAStringInBalancedStrings {
    /*
    Balanced strings are those who have equal quantity of 'L' and 'R' characters.
    Given a balanced string s split it in the maximum amount of balanced strings.
    Return the maximum amount of splitted balanced strings.

    Example 1:
    Input: s = "RLRRLLRLRL"
    Output: 4
    Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.

    Example 2:
    Input: s = "RLLLLRRRLR"
    Output: 3
    Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.

    Example 3:
    Input: s = "LLLLRRRR"
    Output: 1
    Explanation: s can be split into "LLLLRRRR".

    Example 4:
    Input: s = "RLRRRLLRLL"
    Output: 2
    Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
     */
    public int balancedStringSplit(String s) {
        int Ls = 0;
        int Rs = 0;
        int splits = 0;

        if (s.charAt(0) == 'R') {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == 'R') {
                    Rs++;
                } else {
                    Rs--;
                }
                if (Rs == 0) {
                    splits++;
                }
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == 'L') {
                    Ls++;
                } else {
                    Ls--;
                }
                if (Ls == 0) {
                    splits++;
                }
            }
        }
        return splits;
    }
}
