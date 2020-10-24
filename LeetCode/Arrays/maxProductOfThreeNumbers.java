import java.util.Arrays;

public class maxProductOfThreeNumbers {
    /*
        Given an integer array, find three numbers whose product is maximum and output the maximum product.

        Example 1:
        Input: [1,2,3]
        Output: 6

        Example 2:
        Input: [1,2,3,4]
        Output: 24
     */

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        //we do the max of the first two nums multiplied with the last, or the last three numbers multiplied
        //this is for the case of there being negative numbers, the first 2 multiplied give a positive number
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }
}
