public class MaxSubarray {

    //Also known as kadanes Algorithm

    //Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
    public int maxSubArray(int[] nums) {
        //Set max possible sum to the first value in nums
        int max_sum = nums[0];

        //Set the current sum to current max sum
        int current_sum = max_sum;

        for(int i = 1; i < nums.length;i++) {
            //Set the current sum to the greatest value btw current sum and current nums[i] value, or if nums[i] is bigger
            //than nums[i] + current_sum, then just set that as the sum
            current_sum = Math.max(nums[i] + current_sum, nums[i]);
            //Update the max sum to either the new current_sum if it increased, or leave as is
            max_sum = Math.max(current_sum, max_sum);
        }
        return max_sum;
    }
}
