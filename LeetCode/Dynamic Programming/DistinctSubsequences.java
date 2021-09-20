public class DistinctSubsequences {
    /*
    Given two strings s and t, return the number of distinct subsequences of s which equals t.

    A string's subsequence is a new string formed from the original string by deleting some (can be none) of the
    characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE"
    while "AEC" is not).

    It is guaranteed the answer fits on a 32-bit signed integer.

    Example 1:
    Input: s = "rabbbit", t = "rabbit"
    Output: 3
    Explanation:
    As shown below, there are 3 ways you can generate "rabbit" from S.
    rabbbit
    rabbbit
    rabbbit

    Example 2:
    Input: s = "babgbag", t = "bag"
    Output: 5
    Explanation:
    As shown below, there are 5 ways you can generate "bag" from S.
    babgbag
    babgbag
    babgbag
    babgbag
    babgbag

    Constraints:
        1 <= s.length, t.length <= 1000
        s and t consist of English letters.
     */
    //TC: O(m * n) where m is the length of s and n is the length of t
    public int numDistinct(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        int[][] dp = new int[slen + 1][tlen + 1];

        // when t is empty, the number of subsequences of an empty string is 1
        for (int i = 0; i < slen; i++) {
            dp[i][0] = 1;
        }

        /*
            compare characters from s to t, if two characters match, then the number of subsequences up to the current
            character is equal to the number of subsequences up to the previous character in s and the previous character
            in t. If two characters do not match, then the total subsequences up to the current character equals the
            number of subsequences up to the previous character in s.

                [""][b] [a] [g] --> t
            [""][1] [0] [0] [0]
            [b] [1] [1] [0] [0]
            [a] [1] [1] [1] [0]
            [b] [1] [2] [1] [0]
            [g] [1] [2] [1] [1]
            [b] [1] [3] [1] [1]
            [a] [1] [3] [4] [1]
            [g] [1] [3] [4] [5]
             s
            - first column is all 1's since it's the empty string, so we don't select any characters in s to match t, hence
              1 matching subsequence
         */
        for (int i = 1; i <= slen; i++) {
            for (int j = 1; j <= tlen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    /*
                        when characters match, we should have dp[i - 1][j - 1] subsequences, i.e. subsequences up to the
                        previous character in t, and the number of subsequences up to the previous character in s, or
                        dp[i - 1][j]
                     */
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    /*
                        when characters don't match, the number of subsequences is the number of subsequences up to the
                        previous character in s
                     */
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[slen][tlen];
    }
}
