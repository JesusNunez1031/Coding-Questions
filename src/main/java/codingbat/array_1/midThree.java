package codingbat.array_1;

public class midThree {
    /*

    Given an array of ints of odd length, return a new array length 3 containing the elements from the middle of the array. The array length will be at least 3.

    codingbat.array_1.midThree([1, 2, 3, 4, 5]) → [2, 3, 4]
    codingbat.array_1.midThree([8, 6, 7, 5, 3, 0, 9]) → [7, 5, 3]
    codingbat.array_1.midThree([1, 2, 3]) → [1, 2, 3]
     */
    public int[] midThree(int[] nums) {
        if (nums.length <= 3) {
            return nums;
        }
        int mid = nums.length / 2;

        return new int[]{nums[mid - 1], nums[mid], nums[mid + 1]};
    }

}
