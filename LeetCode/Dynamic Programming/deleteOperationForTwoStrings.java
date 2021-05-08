public class deleteOperationForTwoStrings {
    /*
    Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

    In one step, you can delete exactly one character in either string.

    Example 1:
    Input: word1 = "sea", word2 = "eat"
    Output: 2
    Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

    Example 2:
    Input: word1 = "leetcode", word2 = "etco"
    Output: 4

    Constraints:
        1 <= word1.length, word2.length <= 500
        word1 and word2 consist of only lowercase English letters.
     */
    //TC: O(m * n)
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                /*
                    in the case that one of the strings is empty, we need to delete n characters where n is the number
                    of characters in the non-empty string, hence at the first row and column we need to add the number
                    of characters in the current sting thus far the first row will hold the length of word2, while the
                    first column will hold the length of word1
                */
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                }
                /*
                    if the characters match, we don't do nothing since no deletions are required hence we just set
                    the current value to whatever the previous index was to carry on the number of deleted characters
                    thus far.

                    if the characters don't match we need to delete one more character, hence we take the min value
                    of the sequence of all previously deleted characters and add 1 to it

                */
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public int minDistanceLCS(String word1, String word2) {
        //get the length of the longest common subsequence between the words
        int lcs = findLcs(word1, word2);

        /*
            minimum number of deletions needed will be the length of both strings - the length of the longest common
            subsequence between the two words, x2 since we have 2 words

            Ex: w1 = sea | w2 = eat
                the LCS of the two words is e since both strings have e

                if we delete s, a, t, then we get both of the words to match, thus minimum number of deletions will be

                sea: 3 - 1 = 2
                eat: 3 - 1 = 2

                or, 6 - 4 = 2
         */
        return word1.length() + word2.length() - (2 * lcs);
    }

    private int findLcs(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                //skip any zero indexes since we cant use to compare previous values
                if (i == 0 || j == 0) {
                    continue;
                }

                //increase the LCS if the current characters match, otherwise, carry on the longest LCS seen thus far
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
