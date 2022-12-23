package codingbat.array_2;

public class sum28 {
    /*
    Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.

    codingbat.array_2.sum28([2, 3, 2, 2, 4, 2]) → true
    codingbat.array_2.sum28([2, 3, 2, 2, 4, 2, 2]) → false
    codingbat.array_2.sum28([1, 2, 3, 4]) → false
     */
    public boolean sum28(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (num == 2) {
                sum += num;
            }
        }
        return sum == 8;
    }
}
