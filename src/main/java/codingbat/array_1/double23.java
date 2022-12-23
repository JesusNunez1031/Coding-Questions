package codingbat.array_1;

public class double23 {
    /*
    Given an int array, return true if the array contains 2 twice, or 3 twice. The array will be length 0, 1, or 2.

    codingbat.array_1.double23([2, 2]) → true
    codingbat.array_1.double23([3, 3]) → true
    codingbat.array_1.double23([2, 3]) → false
     */
    public boolean double23(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        return (nums[0] == 3 && nums[1] == 3 || nums[0] == 2 && nums[1] == 2);
    }

}
