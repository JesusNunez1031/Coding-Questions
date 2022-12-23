package leetCode.dynamicProgramming;

public class InterleavingString {
    /*
    Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

    An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
        - s = s1 + s2 + ... + sn
        - t = t1 + t2 + ... + tm
        - |n - m| <= 1
        - The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
    Note: a + b is the concatenation of strings a and b.

    Example 1:
    Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    Output: true

    Example 2:
    Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
    Output: false

    Example 3:
    Input: s1 = "", s2 = "", s3 = ""
    Output: true

    Constraints:
        0 <= s1.length, s2.length <= 100
        0 <= s3.length <= 200
        s1, s2, and s3 consist of lowercase English letters.

    Follow up: Could you solve it using only O(s2.length) additional memory space?
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                //the first cell is not considered
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                //compare the first row
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
                //compare the first column
                else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                /*
                    at any index that is not on the first row or column, we consider all characters up to the index from
                    rows and columns, e.g. given s1 = aabcc | s2 = dbbca | s3 = aadbbcbcac
                         "" | a | a(aa) | b (aab) | c (aabc) | c (aabcc)
                    "" |  T | T |   T   |    F    |    F     |    F
                     d |  F | T |   T   |         |          |
                b (db) |  F |   |       |         |          |
               b (dbb) |  F |   |       |         |          |
              c (dbbc) |  F |   |       |         |          |
             a (dbbca) |  F |   |       |         |          |

                  - dp[1][1] is true since we consider a and d with s3.charAt(i + j - 1), if either of these match, then
                    the cell is true.
                  - The same applies for the rest, at dp[1][2] we consider aa and db, since a == a we set to T
                  - at every new row, we compare the character at s3.charAt(rowValue) where rowValue = i + j - 1, by the
                    time the last index is reached, the entire s3 string will be compared to s1 and s2.
                 */
                else {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1) || dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
