public class houseRobberII {
    /*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
    stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last
    one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if
    two adjacent houses were broken into on the same night.

    Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount
    of money you can rob tonight without alerting the police.


    Example 1:
    Input: nums = [2,3,2]
    Output: 3
    Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

    Example 2:
    Input: nums = [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    Total amount you can rob = 1 + 3 = 4.

    Example 3:
    Input: nums = [0]
    Output: 0

    Constraints:
        1 <= nums.length <= 100
        0 <= nums[i] <= 1000
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        //calculate the total money made from robbing starting from house 1 and house 2, then compare which has larger pay

        // if we rob the first house, we cannot rob the last house since they are considered to be adjacent
        int house1 = robHouse(nums, 0, nums.length - 2);
        int house2 = robHouse(nums, 1, nums.length - 1);

        return Math.max(house1, house2);
    }

    private int robHouse(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(dp[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            /*
                for every new house, we either rob the current home and add its value to the house robbed two down or we
                stay with the current robbed house value one down
             */
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[end];
    }
}
