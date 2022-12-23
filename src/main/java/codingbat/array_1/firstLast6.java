package codingbat.array_1;

public class firstLast6 {
    /*
        Given an array of ints, return true if 6 appears as either the first or last element in the array. The array will be length 1 or more.
        codingbat.array_1.firstLast6([1, 2, 6]) → true
        codingbat.array_1.firstLast6([6, 1, 2, 3]) → true
        codingbat.array_1.firstLast6([13, 6, 1, 2, 3]) → false
     */
    public boolean firstLast6(int[] nums) {
        return nums[0] == 6 || nums[nums.length - 1] == 6;
    }

}
