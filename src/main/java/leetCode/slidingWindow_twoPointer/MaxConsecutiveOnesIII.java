package leetCode.slidingWindow_twoPointer;

public class MaxConsecutiveOnesIII {
    /*
    Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can
    flip at most k 0's.

    Example 1:
    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    Output: 6
    Explanation: [1,1,1,0,0,1,1,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

    Example 2:
    Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
    Output: 10
    Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

    Constraints:
        1 <= nums.length <= 105
        nums[i] is either 0 or 1.
        0 <= k <= nums.length
     */
    //TC: O(n)
    public static int longestOnes(int[] nums, int k) {
        int i = 0;
        int zerosFlipped = 0;
        int maxOnes = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zerosFlipped++;

                //reduce window if the number of flipped zeros exceeds the limit k
                while (zerosFlipped > k) {
                    if (nums[i] == 0) {
                        zerosFlipped--;
                    }
                    i++;
                }
            }
            //calculate the window size
            maxOnes = Math.max(maxOnes, j - i + 1);
        }
        return maxOnes;
    }
}
