public class NumberOfSubarraysWithBoundedMaximum {
    /*
    We are given an array nums of positive integers, and two positive integers left and right (left <= right).
    Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that
    subarray is at least left and at most right.

    Example:
    Input:
    nums = [2, 1, 4, 3]
    left = 2
    right = 3
    Output: 3
    Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].

    Note:
        left, right, and nums[i] will be an integer in the range [0, 10^9].
        The length of nums will be in the range of [1, 50000].
     */
    //TC: O(n)
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int subarrays = 0;
        int windowCount = 0;
        int i = 0, j = 0;

        while (j < nums.length) {
            /*
                if the current value is in range of left and right increase window size and add since the window size
                increased by 1, two new subarrays were created, the old subarray + nums[j] and nums[j], hence we add
                the windowCount to the total number of subarrays
             */
            if (left <= nums[j] && nums[j] <= right) {
                windowCount = j - i + 1;
                subarrays += windowCount;
            }

            //reset the window count and move to the start of the window, i, to the next value if nums[j] is larger than right
            else if (nums[j] > right) {
                windowCount = 0;
                i = j + 1;
            }

            /*
                use the old window size if nums[j] is less than left since adding this value to the current window creates
                2 new subarrays, the previous subarray and the subarray of the previous value with the current value, hence
                we add the previous windowCount
             */
            else if (nums[j] < left) {
                subarrays += windowCount;
            }
            j++;
        }
        return subarrays;
    }

    public int numSubarrayBoundedMaxEz(int[] nums, int left, int right) {
        /*
            find the number of subarrays where values are less than right and subtract the number of subarrays that
            are strictly less than left, the remaining value are subarrays that are in the range of [left, right]
            inclusive.
         */
        return subarrays(nums, right) - subarrays(nums, left - 1);
    }

    private int subarrays(int[] nums, int bound) {
        int windows = 0, count = 0;

        for (int num : nums) {
            //increase the window size by 1 if num is in the range of bound, otherwise reset the window size
            windows = num <= bound ? windows + 1 : 0;
            //add the number of windows found to the total count of subarrays
            count += windows;
        }
        return count;
    }
}
