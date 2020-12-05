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
        if(nums.length <= 1) {
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

        for(int i = 1; i < nums.length;i++) {
            for(int j = 0; j < i;j++) {
                /*
                    if the current value we are at i is greater than the value at j, then we want to add it to the longest
                    sequence since it is increasing, so we compare the current longest sequence at i which originally should
                    be 1, to 1 + the longest sequence at j.
                 */
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            //at the end of each new value comparison we update the new longest_sequence
            largest_sequence = Math.max(largest_sequence, dp[i]);
        }
        return largest_sequence;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(nums));
    }
}
