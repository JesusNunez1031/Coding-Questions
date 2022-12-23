package leetCode.dynamicProgramming;

import java.util.Arrays;

public class longestIncreasingSubsequence {
    /*
    Given an integer array nums, return the length of the longest strictly increasing subsequence.
    A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the
    order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

    Example 1:
    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4

    Example 2:
    Input: nums = [0,1,0,3,2,3]
    Output: 4

    Example 3:
    Input: nums = [7,7,7,7,7,7,7]
    Output: 1

    Constraints:
        1 <= nums.length <= 2500
        -10^4 <= nums[i] <= 10^4


    Follow up:

    Could you come up with the O(n2) solution?
    Could you improve it to O(n log(n)) time complexity?
     */

    //TC: O(n^2) since we compare n values in nums n times to see if the longest subsequence increases from up to every value
    private static int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length == 0 ? 0 : 1;
        }

        int[] dp = new int[nums.length];
        int largest_sequence = 1;

        /*
            fill in all all the cells in dp array to 1 since that is the default longest increasing subsequence at every value
            Ex:
                if we are given an array of length 1, then the largest increasing sequence is 1 since the length of the
                array is 1
        */
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                /*
                    if the current value we are at i is greater than the value at j, then we want to add it to the longest
                    sequence since it is increasing, so we compare the current longest sequence at i which originally should
                    be 1, to 1 + the longest sequence at j.
                 */
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            //at the end of each new value comparison we update the new longest_sequence
            largest_sequence = Math.max(largest_sequence, dp[i]);
        }
        return largest_sequence;
    }

    //TC: O(n log n)
    public int lengthOfLISBS(int[] nums) {
        //the dp array will not hold the LIS, it holds the length of the LIS
        int[] dp = new int[nums.length];

        int longest_sequence = 0;

        for (int num : nums) {
            //returns the index where num belongs in dp
            int i = binarySearch(dp, 0, longest_sequence, num);

            /* if num is not found, flip i to a new insertion point
             if(i < 0) {
                 i = -(i + 1);
             }
              */

            /*
                if the "num" is largest, we add it to the end of the dp array
                if "num" is not the largest, we want to keep it and replace the previous ith value in the dp array with it
                We do this because even if this new num does not directly increase the LIS, it gives us a better chance to
                build a longer LIS, e.g. if the LIS is currently [0, 4, 5, 10] and "num" = 6, we want to replace the 10
                with 6, that way if we encounter any value from 7-10, we increase the LIS by 1, rather than keep it at
                length 4
                All elements before this ith position will be the best(smallest) LIS so far
            */
            dp[i] = num;
            /*
                if we insert "num" at the index of longest_sequence, we've added a value at the end of the LIS so we increase
                it by 1 so if next time "num" is larger, LIS will increase by 1 again, otherwise, it will remain the same
                since ith value was just replaced
             */
            if (i == longest_sequence) {
                longest_sequence++;
            }
        }
        return longest_sequence;
    }

    //returns the index of target in dp array
    private int binarySearch(int[] dp, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums));
    }
}
