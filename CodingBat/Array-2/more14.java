public class more14 {
    /*
    Given an array of ints, return true if the number of 1's is greater than the number of 4's

    more14([1, 4, 1]) → true
    more14([1, 4, 1, 4]) → false
    more14([1, 1]) → true
     */
    public boolean more14(int[] nums) {
        int ones = 0;
        int fours = 0;

        for (int num : nums) {
            if (num == 1) {
                ones++;
            }
            if (num == 4) {
                fours++;
            }
        }
        return ones > fours;
    }
}
