package codingbat.array_1;

public class makeMiddle {
    /*
    Given an array of ints of even length, return a new array length 2 containing the middle two elements from the original array. The original array will be length 2 or more.

    codingbat.array_1.makeMiddle([1, 2, 3, 4]) → [2, 3]
    codingbat.array_1.makeMiddle([7, 1, 2, 3, 4, 9]) → [2, 3]
    codingbat.array_1.makeMiddle([1, 2]) → [1, 2]
     */
    public int[] makeMiddle(int[] nums) {
        if (nums.length == 2) {
            return nums;
        }
        int mid = nums.length / 2;

        return new int[]{nums[mid - 1], nums[mid]};
    }
}
