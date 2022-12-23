package codingbat.array_1;

public class sameFirstLast {
    /*
        Given an array of ints, return true if the array is length 1 or more, and the first element and the last element are equal.

        codingbat.array_1.sameFirstLast([1, 2, 3]) → false
        codingbat.array_1.sameFirstLast([1, 2, 3, 1]) → true
        codingbat.array_1.sameFirstLast([1, 2, 1]) → true
     */
    public boolean sameFirstLast(int[] nums) {
        if (nums.length < 1) {
            return false;
        }
        return nums[0] == nums[nums.length - 1];
    }

}
