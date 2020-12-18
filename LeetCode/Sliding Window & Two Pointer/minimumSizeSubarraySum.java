public class minimumSizeSubarraySum {
    /*
    Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of
    which the sum ≥ s. If there isn't one, return 0 instead.

    Example:
    Input: s = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: the subarray [4,3] has the minimal length under the problem constraint.
     */
    private int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int min_length = Integer.MAX_VALUE;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            //reduce the sum as long as its >= s
            while (sum >= s) {
                min_length = Math.min(min_length, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }
        return min_length != Integer.MAX_VALUE ? min_length : 0;
    }
}
