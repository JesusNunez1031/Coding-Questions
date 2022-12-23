package leetCode.dynamicProgramming;

public class MaximumLengthOfRepeatedSubarray {
    /*
    Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

    Example 1:
    Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
    Output: 3
    Explanation: The repeated subarray with maximum length is [3,2,1].

    Example 2:
    Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
    Output: 5

    Constraints:
        1 <= nums1.length, nums2.length <= 1000
        0 <= nums1[i], nums2[i] <= 100
     */
    //TC: O(n x m) where n is the length of nums1 and m is the length of nums2
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        //dp array of length nums1 x nums2
        int[][] dp = new int[n1 + 1][n2 + 1];

        int max = 0; //largest subarray in both nums1 & nums2

        //start from 1 so we can always refer to the previous index in dp
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                //if values from the arrays match, add on to the subarray by adding 1 to the previous longest subarray
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    //update max if changed
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }
}
