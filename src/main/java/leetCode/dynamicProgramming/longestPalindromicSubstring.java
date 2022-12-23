package leetCode.dynamicProgramming;

public class longestPalindromicSubstring {
    /*
    Given a string s, return the longest palindromic substring in s.

    Example 1:
    Input: s = "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.

    Example 2:
    Input: s = "cbbd"
    Output: "bb"

    Example 3:
    Input: s = "a"
    Output: "a"

    Example 4:
    Input: s = "ac"
    Output: "a"

    Constraints:
        1 <= s.length <= 1000
        s consist of only digits and English letters (lower-case and/or upper-case),
     */

    /*
        TC: O(n^2) and O(n) space, we use Dynamic programming to store the indexes of all the substrings in s in 2-D boolean
        array, so if a new start to a substring is made, we check if the character at the start == end, and if the
        inside substring from start + 1 and end - 1 is also a palindrome. We'll know if it is or not by checking the cell
        of [i + 1][j - 1] where i is the start and j is the end
     */
    private static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s.length() == 0 ? "" : s;
        }
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        String result = "";

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                /*
                    A cell only becomes true, aka the current substring is a palindrome,if the given character i is equal
                    to the current character j and either the length of current substring observed is 2 or less since
                    any substring of length 2 is a palindrome, or if the substring from the i + 1 and j - 1 is also a palindrome
                    Ex:
                        given string acabbaab
                        if baab is being observed so i = 4 and j = 7, then if the substring from 5 - 6 is a palindrome,
                        then the current cell can become true, making it a palindrome, iff s.charAt(i) == s.charAt(j)
                 */
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);

                /*
                    if the current substring from i to j is a palindrome, check if its length is longer than that of the
                    current result, if so update it
                 */
                if (dp[i][j] && (result.isEmpty() || j - i + 1 > result.length())) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    /*
        Approach 2 is to iterate through the entire string and at each index, search outward while the char at i == char at j
        To account for non-direct middle starts, we search twice, once from i and again from i + 1

        TC: O(n^2) time and constant space is used
    */
    private static String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s.length() == 0 ? "" : s;
        }

        //variables to hold the start and end of the resulting palindrome
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            //call method twice starting from i and again from i to i + 1 to consider both odd and even length palindromes
            int odd = searchOut(s, i, i);
            int even = searchOut(s, i, i + 1);

            int length = Math.max(odd, even);

            if(length > end - start) {
                /*
                    for an even palindrome of length 6,
                    Ex: substring is a[abaccab]e
                        abaccab
                           ^^ -> i and i + 1

                        abaccab
                        ^     ^
                start=i-2     end=i+3

                start = 3 - (6 - 1 / 2) = 3 - 2 = 1

                */
                start = i - ((length - 1) / 2);

                //end is just the half of the substrings length
                end = i + length / 2;
            }

            //if the substring found is s, then we directly return s
            if (start == 0 && end == s.length() - 1) {
                return s;
            }
        }
        return s.substring(start, end + 1);
    }

    /*
        given a start left and right, method searches out from s[left] and s[right] as long as characters match, returns
        the length of the palindrome substring in s
     */
    private static int searchOut(String s, int left, int right) {
        if(left > right) {
            return 0;
        }
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //-1 to account for the extra increment before loop termination
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome2(s));
    }
}
