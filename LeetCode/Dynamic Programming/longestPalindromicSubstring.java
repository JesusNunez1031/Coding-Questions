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
    private String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s.length() == 0 ? "" : s;
        }

        //variables to hold the start and end of the resulting palindrome
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            /*
                the length of the palindrome, if any, is the max starting from the character and on, or
                starting from +1 of the character
                Ex:
                given the string abaaba and when we get to i = 2
                    1. the first search sets i and j to 2 and that returns 1 - 1 = 0
                    2. second search sets i to 2 and j to 3, this returns 5 - 1 = 4
            */
            int len = Math.max(searchOut(s, i, i), searchOut(s, i, i + 1));

            /*
                to check if the length of the new found substring is longer than one already found, we compare it to the
                value of end - start, this gives us the length of the current found palindrome
            */
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }

            //if the substring found is s, then we directly return s
            if (start == 0 && end == s.length() - 1) {
                return s;
            }
        }
        return s.substring(start, end + 1);
    }

    private int searchOut(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        String s = "acabbaab";
        System.out.println(longestPalindrome(s));
    }
}
