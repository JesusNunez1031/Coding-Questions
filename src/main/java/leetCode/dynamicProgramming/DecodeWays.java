package leetCode.dynamicProgramming;

public class DecodeWays {
    /*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:
    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given a non-empty string containing only digits, determine the total number of ways to decode it.

    The answer is guaranteed to fit in a 32-bit integer.

    Example 1:
    Input: s = "12"
    Output: 2
    Explanation: It could be decoded as "AB" (1 2) or "L" (12).

    Example 2:
    Input: s = "226"
    Output: 3
    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

    Example 3:
    Input: s = "0"
    Output: 0
    Explanation: There is no character that is mapped to a number starting with '0'. We cannot ignore a zero when we
    face it while decoding. So, each '0' should be part of "10" --> 'J' or "20" --> 'T'.

    Example 4:
    Input: s = "1"
    Output: 1

    Constraints:
        1 <= s.length <= 100
        s contains only digits and may contain leading zero(s).
     */

    /*
                      Pseudocode : dynamic programming
     1. we need to solve the number of ways to decode substrings of 1 character and 2 characters from s so we initialize
        a dp array of s.length + 1 to account for the empty string
     2. dp[0] = 1, no ways to decode the empty string = 1 way to decode a string
     3. if the first character of s is 0, dp[1] = 0 since 0 is not in the range of 1-26, otherwise dp[1] = 1
     4. for every integer in s starting from i = 2, the number of ways to decode i, will be the number of ways to decode
        dp[i - 1] and dp[i - 2] assuming the substring s of (i - 1, i) is not zero and substring s of (i - 2, i) is
        greater than or equal to 10 and less than or equal to 26. substring of s(i - 1, i) is one digit and s(i - 2, i)
        is two digits.
     5. The number of ways to decode s, will be dp[s.length()] which is the number of ways to decode a string of length
        s

     */

    //TC: O(n) where n is the length of the string s and linear space to store the solutions of substrings s
    private static int numDecodings(String s) {
        //set the dp array to +1 the length of s to account for the empty string
        int[] dp = new int[s.length() + 1];

        //dp[0] represents the number of ways to decode the empty string, since there are no ways, its value is 1
        dp[0] = 1;

        //if the first character in s is a 0, there are no ways to decode it, of its anything else, it will be 1
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            /*
                from the current position of i, we want to extract the one digit value from s and a two digit value from
                s, then we check if the digit values are in the range of 1 - 26, if so we add the value of the solutions
                from the predecessor indexes

                at every i, we solve the value for i by adding the solutions of the previous values in dp, this will allow
                us to get the solution for the string of length s
             */
            int one_digit = Integer.parseInt(s.substring(i - 1, i));
            int two_digit = Integer.parseInt(s.substring(i - 2, i));
            if (one_digit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (two_digit >= 10 && two_digit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "225";
        System.out.println(numDecodings(s));
    }
}
