package codingbat.array_2;

public class has22 {
    /*
    Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.

    codingbat.array_2.has22([1, 2, 2]) → true
    codingbat.array_2.has22([1, 2, 1, 2]) → false
    codingbat.array_2.has22([2, 1, 2]) → false
     */
    public boolean has22(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2) {
                return true;
            }
        }
        return false;
    }
}
