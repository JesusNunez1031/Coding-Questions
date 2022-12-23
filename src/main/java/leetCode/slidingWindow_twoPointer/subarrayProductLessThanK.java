package leetCode.slidingWindow_twoPointer;

public class subarrayProductLessThanK {
    /*
    Your are given an array of positive integers nums.
    Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

    Example 1:
    Input: nums = [10, 5, 2, 6], k = 100
    Output: 8
    Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
    Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

    Note:
        0 < nums.length <= 50000.
        0 < nums[i] < 1000.
        0 <= k < 10^6.
     */
    //TC: O(n)
    private int numSubarrayProductLessThanK(int[] nums, int k) {
        //check for valid k
        if (k <= 1) {
            return 0;
        }

        //variable to hold the product of subarray
        int prod = 1;

        //number of contiguous subarrays of product < k
        int subarrays = 0;

        //pointers for the start and end of the subarray
        int left = 0, right = 0;

        while (right < nums.length) {
            //calculate the current product of the subarray
            prod *= nums[right];

            //if the product is larger than k, reduce by moving left forward until its less than k
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }

            //get the size of the subarray +1 to include the current value nums[right]
            subarrays += right - left + 1;

            //move to next value
            right++;
        }
        return subarrays;
    }
}
