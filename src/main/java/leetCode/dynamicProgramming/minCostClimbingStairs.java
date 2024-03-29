package leetCode.dynamicProgramming;

public class minCostClimbingStairs {
    /*
    On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
    Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the
    floor, and you can either start from the step with index 0, or the step with index 1.

    Example 1:
    Input: cost = [10, 15, 20]
    Output: 15
    Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

    Example 2:
    Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
    Output: 6
    Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

    Note:
        cost will have a length in the range [2, 1000].
        Every cost[i] will be an integer in the range [0, 999].
     */
    //TC: O(n) and space
    private static int minCostClimbingStairs(int[] cost) {
        //2 items are guaranteed in the array hence if the current cost array only has 2 items, return the smallest
        if(cost.length < 3) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[cost.length];

        /*
            we can start from either the first value or the second, we will calculate the min cost by using both values,
            in the end, either dp[n - 1], starting from cost[0], or dp[n - 2], starting from cost[1], will have the smallest cost
         */
        dp[0] = cost[0];
        dp[1] = cost[1];

        int i = 2;
        while (i < cost.length) {
            /*
                At every iteration, the new cost up to the current value is found by adding the current cost to
                the smallest value from before, either from the starting of index 0 or 1
            */
            dp[i] = cost[i] + Math.min(dp[i - 2], dp[i - 1]);
            i++;
        }
        return Math.min(dp[i - 1], dp[i - 2]);
    }

    public static void main(String[] args) {
        //int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
