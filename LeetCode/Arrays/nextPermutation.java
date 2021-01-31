public class nextPermutation {
    /*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

    The replacement must be in place and use only constant extra memory.

    Example 1:
    Input: nums = [1,2,3]
    Output: [1,3,2]

    Example 2:
    Input: nums = [3,2,1]
    Output: [1,2,3]

    Example 3:
    Input: nums = [1,1,5]
    Output: [1,5,1]

    Example 4:
    Input: nums = [1]
    Output: [1]

    Constraints:
        1 <= nums.length <= 100
        0 <= nums[i] <= 100
     */
    //TC: O(n) and constant space
    public void nextPermutation(int[] nums) {
        //find the first decreasing sequence starting from the end
        int i = nums.length - 2;
        //break when nums[i] is less than nums[i + 1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //find the number to swap with the nums[i] by repeating the first step with j
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        //if the array is in decreasing order, both i and j will == 0 and the entire array will be reversed

        //reverse the array section from i + 1 to complete the permutation, this will give a sorted array
        reverse(nums, i + 1);
    }

    //Method to reverse the subarray in nums from index start to nums.length - 1
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;

        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    //Method to swap value at index i and j in nums
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
