package codingbat.array_1;

public class swapEnds {
    /*
    Given an array of ints, swap the first and last elements in the array. Return the modified array. The array length will be at least 1.

    codingbat.array_1.swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
    codingbat.array_1.swapEnds([1, 2, 3]) → [3, 2, 1]
    codingbat.array_1.swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
     */
    public int[] swapEnds(int[] nums) {
        int first = nums[0];
        int last = nums[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0) {
                nums[i] = last;
            }
            if (i == nums.length - 2) {
                nums[i + 1] = first;
            }
        }
        return nums;
    }
}
