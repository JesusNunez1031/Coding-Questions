package codingbat.array_2;

public class lucky13 {
    /*
    Given an array of ints, return true if the array contains no 1's and no 3's.

    codingbat.array_2.lucky13([0, 2, 4]) → true
    codingbat.array_2.lucky13([1, 2, 3]) → false
    codingbat.array_2.lucky13([1, 2, 4]) → false
     */
    public boolean lucky13(int[] nums) {
        for (int num : nums) {
            if (num == 1 || num == 3) {
                return false;
            }
        }
        return true;
    }
}
