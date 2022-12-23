package leetCode.dynamicProgramming;

import java.util.Arrays;

public class PerfectSquares {
    /*
    Given an integer n, return the least number of perfect square numbers that sum to n.

    A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer
    with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

    Example 1:
    Input: n = 12
    Output: 3
    Explanation: 12 = 4 + 4 + 4.

    Example 2:
    Input: n = 13
    Output: 2
    Explanation: 13 = 4 + 9.

    Constraints:
        1 <= n <= 10^4
     */
    //TC: O(n * sqrt(n))
    public static int numSquares(int n) {
        int[] dp = new int[n + 1]; // min number of perfect squares

        // assume the largest number of perfect squares is needed for all values up to n
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0; // 0 has no perfect squares that sum up to it

        for (int i = 1; i <= n; i++) {
            // check all perfect squares less than the current number i
            for (int j = 1; j * j <= i; j++) {
                /*
                    the sum of perfect squares for i is the smallest value between the sum of squares using previously
                    seen perfect squares + 1 to account for the current square being used. if i is a perfect square,
                    dp[i] = 1
                 */
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        numSquares(12);
    }
}
