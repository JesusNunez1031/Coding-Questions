package codingbat.array_2;

public class either24 {
    /*
    Given an array of ints, return true if the array contains a 2 next to a 2 or a 4 next to a 4, but not both.

    codingbat.array_2.either24([1, 2, 2]) → true
    codingbat.array_2.either24([4, 4, 1]) → true
    codingbat.array_2.either24([4, 4, 1, 2, 2]) → false
     */
    public boolean either24(int[] nums) {
        int pairs = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2 || nums[i] == 4 && nums[i + 1] == 4) {
                pairs++;
            }
        }
        return pairs == 1;
    }
}
