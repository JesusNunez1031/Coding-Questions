package codingbat.warmup_2;

public class array123 {
    /*
    Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.

    codingbat.warmup_2.array123([1, 1, 2, 3, 1]) → true
    codingbat.warmup_2.array123([1, 1, 2, 4, 1]) → false
    codingbat.warmup_2.array123([1, 1, 2, 1, 2, 3]) → true
     */

    public boolean array123(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 1) {
                if (nums[i + 1] == 2) {
                    if (nums[i + 2] == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
