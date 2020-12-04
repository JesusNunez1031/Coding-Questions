public class maximumProductSubarray {
    /*
    Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

    Example 1:
    Input: [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.

    Example 2:
    Input: [-2,0,-1]
    Output: 0
    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     */
    //TC: O(n) and constant space
    public int maxProduct(int[] nums) {
        int final_max = nums[0];
        int current_max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //save reference to the current_max since we update it before using it
            int temp = current_max;

             /*
                the new current_max becomes the current number multiplied by both the current_max and min or the current number
                itself, since it is possible that the current value nums[i] can be larger than the product of the it with max and min
            */
            current_max = Math.max(Math.max(current_max * nums[i], min * nums[i]), nums[i]);

            /*
                the new min becomes the smallest value between of the product of the current value nums[i] with the old max and min, or the
                current value itself, as again, it is possible for nums[i] to be a much smaller negative value or be negative in general
            */
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

            //check if we need to update the final_max
            if (current_max > final_max) {
                final_max = current_max;
            }
        }
        return final_max;
    }
}
