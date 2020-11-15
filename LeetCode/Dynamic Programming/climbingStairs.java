public class climbingStairs {
    /*
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Example 1:
    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

    Example 2:
    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step

    Constraints:
        1 <= n <= 45
     */

    public int climbStairs(int n) {
        //there is only 1 way given 1, and 2 ways given 2
        if (n == 1 || n == 2) {
            return n;
        }
        //if n is greater than 2
        int[] dp = new int[n + 1];
        dp[1] = 1;  //there is only one way to climb one stair [one at a time]
        dp[2] = 2;  //there is 2 ways to climb 2 stairs [1 at a time or 2 at a time]

        int i = 3;
        while (i <= n) {
            //the solution to n is the solution of the previous 2 ways
            dp[i] = dp[i - 1] + dp[i - 2];
            i++;
        }
        //return the solution of n
        return dp[n];
    }
}
