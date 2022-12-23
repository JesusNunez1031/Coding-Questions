package codingbat.array_1;

public class no23 {
    /*
    Given an int array length 2, return true if it does not contain a 2 or 3.

    codingbat.array_1.no23([4, 5]) → true
    codingbat.array_1.no23([4, 2]) → false
    codingbat.array_1.no23([3, 5]) → false
     */
    public boolean no23(int[] nums) {
        for (int num : nums) {
            if (num == 2 || num == 3) {
                return false;
            }
        }
        return true;
    }

}
