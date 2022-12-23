package codingbat.array_1;

public class maxEnd3 {
    /*
        Given an array of ints length 3, figure out which is larger, the first or last element in the array, and set all the other elements to be that value. Return the changed array.

        codingbat.array_1.maxEnd3([1, 2, 3]) → [3, 3, 3]
        codingbat.array_1.maxEnd3([11, 5, 9]) → [11, 11, 11]
        codingbat.array_1.maxEnd3([2, 11, 3]) → [3, 3, 3]
     */
    public int[] maxEnd3(int[] nums) {
        int max = Math.max(nums[0], nums[nums.length - 1]);
        return new int[]{max, max, max};
    }

}
