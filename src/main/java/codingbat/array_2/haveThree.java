package codingbat.array_2;

public class haveThree {
    /*
    Given an array of ints, return true if the value 3 appears in the array exactly 3 times, and no 3's are next to each other.

    codingbat.array_2.haveThree([3, 1, 3, 1, 3]) → true
    codingbat.array_2.haveThree([3, 1, 3, 3]) → false
    codingbat.array_2.haveThree([3, 4, 3, 3, 4]) → false
     */
    public boolean haveThree(int[] nums) {
        int threeCount = 0;

        if (nums.length >= 1 && nums[0] == 3) {
            threeCount++;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 3 && nums[i] == nums[i - 1]) {
                return false;
            }
            if (nums[i] == 3) {
                threeCount++;
            }
        }
        return threeCount == 3;
    }
}
