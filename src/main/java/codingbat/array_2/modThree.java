package codingbat.array_2;

public class modThree {
    /*
    Given an array of ints, return true if the array contains either 3 even or 3 odd values all next to each other.

    codingbat.array_2.modThree([2, 1, 3, 5]) → true
    codingbat.array_2.modThree([2, 1, 2, 5]) → false
    codingbat.array_2.modThree([2, 4, 2, 5]) → true
     */
    public boolean modThree(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2 && nums[i] % 2 == nums[i + 2] % 2) {
                return true;
            }
        }
        return false;
    }
}
