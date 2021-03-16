public class palindromicSubstrings {
    /*
    Given a string, your task is to count how many palindromic substrings in this string.
    The substrings with different start indexes or end indexes are counted as different substrings even they consist of
    same characters.

    Example 1:
    Input: "abc"
    Output: 3
    Explanation: Three palindromic strings: "a", "b", "c".

    Example 2:
    Input: "aaa"
    Output: 6
    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

    Note:
        The input string length won't exceed 1000.
     */

    /*
                                                    Pseudocode: Dynamic Programming
       1. Initialize a 2-D array of n x n length where n is size of string s that will hold a boolean value for
           all the substrings that are palindromes, i is the start and j is the end of the substring, hence if
           dp[i][j] == true, s.substring(i, j) is a palindrome
       2. Starting i from the end of string s, we loop and check every substring from j to s.length, where j = i
       3. dp[i][j] is a valid palindrome iff character s[i] == s[j] and if the length of the substring is <= 2, j - i,
           or if the substring inside i, j is also a palindrome, e.g. dp[i + 1][j - 1]
       4. if dp[i][j] == true, add to the total count of palindrome substrings in s
       5. return count
     */
    //TC: O(n^2) where n is the length of s. we loop through s for every character in s
    private static int countSubstrings(String s) {
        int n = s.length();

        //dp 2-D array will hold all the substrings in s that are palindromes where i is start of the substring and j is the end
        boolean[][] dp = new boolean[n][n];

        //count of palindrome substrings  in s
        int palindromes = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                /*
                    if the character at s[i] == s[j] and the substring is less than 2 or the substring inside of i and
                    j, s[i + 1] - s[j - 1] is a palindrome, then the current substring from i to j is also a palindrome
                    Ex:
                      given abba
                      a == a and bb is a palindrome therefore, abba is a palindrome, so dp[i][j] is a palindrome
                */
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    palindromes++;
                }
            }
        }
        return palindromes;
    }
    /*
        Approach 2 is to search outward from every position in the string s checking at every step if the character at
        left matches to the character at right
        if i < s.length - 1, then we also search starting from i and i + 1 in case the string is not of odd length
        Ex: given string aabaa
            when we search from b, if left and right start at b, the next iteration left == a and right == b

            however, if the string is of even length, aabbaa
        - if we search from the first b to the left, if both left and right start at b, we will return 1 since after left and
        right move, left == a and right == b, which will break out

        - to account for this, we also search from i to i + 1, therefore, starting from b, left == b and right == b, this
        will return a valid count of 3

     */
    //TC: O(n^2) and constant space used
    private int countSubstringsConst(String s) {
        int palindromes = 0;

        for (int i = 0; i < s.length(); i++) {
            palindromes += searchOut(i, i, s);
            if (i < s.length() - 1) {
                palindromes += searchOut(i, i + 1, s);
            }
        }
        return palindromes;
    }

    private int searchOut(int left, int right, String s) {
        if (left > right) {
            return 0;
        }
        //count is the number of times s[left] == s[right] since single letters are palindromes
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}
