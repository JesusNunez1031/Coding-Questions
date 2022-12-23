package leetCode.arrays;

public class MaxConsecutiveOnes {
    /*
        Given a binary array, find the maximum number of consecutive 1s in this array.

        Example 1:
        Input: [1,1,0,1,1,1]
        Output: 3
        Explanation: The first two digits or the last three digits are consecutive 1s.
            The maximum number of consecutive 1s is 3.

        Example 2:
        Input: nums = [1,0,1,1,0,1]
        Output: 2

        Constraints:
            1 <= nums.length <= 105
            nums[i] is either 0 or 1.
     */
    //TC: O(n)
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 1 && nums[0] == 1) {
            return 1;
        }
        int max = 0, runningCount = 0;

        for (int num : nums) {
            // increase the sequence of one's if current index is 1
            if (num == 1) {
                runningCount++;
            }
            // update the max sequence if needed when the sequence of 1's is broken
            else {
                max = Math.max(max, runningCount);
                runningCount = 0; // reset sequence counter
            }
        }
        // if we ended on a sequence of 1's, do one final comparison, otherwise return the largest sequence
        return runningCount > 0 ? Math.max(max, runningCount) : max;
    }
}
