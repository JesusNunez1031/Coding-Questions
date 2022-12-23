package leetCode.slidingWindow_twoPointer;

public class LongestUncommonSubsequenceII {
    /*
    Given an array of strings strs, return the length of the longest uncommon subsequence between them. If the longest
    uncommon subsequence does not exist, return -1.

    An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.

    A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.

    For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get
    "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).

    Example 1:
    Input: strs = ["aba","cdc","eae"]
    Output: 3

    Example 2:
    Input: strs = ["aaa","aaa","aa"]
    Output: -1

    Constraints:
        1 <= strs.length <= 50
        1 <= strs[i].length <= 10
        strs[i] consists of lowercase English letters.
     */
    //TC:O(n^2)
    public int findLUSlength(String[] strs) {
        int maxLength = -1;

        for (int i = 0; i < strs.length; i++) {
            boolean isSubsequence = false;

            // compare the current string to all other strings in the array and check if ith string is a substring of a jth string
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isSubsequence = true;
                    break;
                }
            }

            //if ith string was not a substring of any other string, take note of its length
            if (!isSubsequence) {
                maxLength = Math.max(maxLength, strs[i].length());
            }
        }
        return maxLength;
    }

    //returns true is string a is in b
    private boolean isSubsequence(String a, String b) {
        if (a.equals(b)) {
            return true;
        }

        int i = 0;
        int j = 0;

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }
}
