package leetCode.dynamicProgramming;

public class houseRobber {
    /*
        You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
        stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
        connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
        Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
        of money you can rob tonight without alerting the police.

        Example 1:
        Input: nums = [1,2,3,1]
        Output: 4
        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
                     Total amount you can rob = 1 + 3 = 4.

        Example 2:
        Input: nums = [2,7,9,3,1]
        Output: 12
        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
                     Total amount you can rob = 2 + 9 + 1 = 12.
     */
    public int rob(int[] nums) {
        //no houses to rob
        if (nums.length == 0) {
            return 0;
        }
        //rob the only house available
        if (nums.length == 1) {
            return nums[0];
        }
        //rob the house with the highest yield
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        //array to hold all the values we will use to find max, last value in array will hold the max
        int[] dp = new int[nums.length];

        /*
            store the profit from robbing first house, the max profit at dp[1] is the greater of the values between the
            first home or second house
         */
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            //is the current home nums[i] + the home 2 down dp[i - 2] greater profit than if we would of robbed the home prior to this one?
            //if it is, then we continue by robbing this home, otherwise, we rob the house before i
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
