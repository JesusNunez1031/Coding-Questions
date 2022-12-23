package codingbat.array_1;

public class has23 {
    /*
    Given an int array length 2, return true if it contains a 2 or a 3.

    codingbat.array_1.has23([2, 5]) → true
    codingbat.array_1.has23([4, 3]) → true
    codingbat.array_1.has23([4, 5]) → false
     */
    public boolean has23(int[] nums) {
        return nums[0] == 2 || nums[0] == 3 || nums[1] == 3;
    }
}
