package leetCode.arrays;

public class twoSumII {
    /*
    Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

    Note:
    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice.

    ex:
        Input: numbers = [2,7,11,15], target = 9
        Output: [1,2]
        Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

        Since the question said there is EXACTLY one solution and didn't provide any info about when there is no valid answer, so we can always assume there is one and only one answer,
        which means i and j never across each other.
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {

            int sum = nums[i] + nums[j];

            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else {
                //if the sum is larger than the target, we bring our end pointer down by one for a smaller sum
                if (sum > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return result;
    }
}
