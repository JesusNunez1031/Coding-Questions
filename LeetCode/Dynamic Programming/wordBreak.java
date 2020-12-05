import java.util.Arrays;
import java.util.List;

public class wordBreak {
    /*
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
    segmented into a space-separated sequence of one or more dictionary words.

    Note:
    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

    Example 1:
    Input: s = "leetcode", wordDict = ["leet", "code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".

    Example 2:
    Input: s = "applepenapple", wordDict = ["apple", "pen"]
    Output: true
    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
                 Note that you are allowed to reuse a dictionary word.

    Example 3:
    Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    Output: false
     */
    private static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        /*
            get the length of the largest word in the dictionary so we don't have to do unnecessary work if we encounter
            a substring of length larger than the length of the largest word
         */
        int maxLen = 0;
        for(String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        //the empty string is counted as being true since the empty word is indirectly included in the list
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                /*
                    if the current substring length is larger than the largest word in the dictionary, there is no point
                    in checking if its in the dictionary
                 */
                if(i - j > maxLen) {
                    continue;
                }
                /*
                    at every letter in the string s, we check starting from i and decrementing j if there exists a substring
                    from j to i that is found in the dictionary, if there is, then we set the index of the end of the word
                    to true, therefore, as we move forward, the next word will be found from the index of j that is true
                    to i, if the given string can be divided, then the last word in s will be found in the dictionary so we
                    set the index of s.length - 1 to true
                 */
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");
        System.out.println(wordBreak(s, wordDict));
    }
}
