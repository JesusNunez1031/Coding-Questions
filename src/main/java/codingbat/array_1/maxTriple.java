package codingbat.array_1;

public class maxTriple {
    /*
    Given an array of ints of odd length, look at the first, last, and middle values in the array and return the largest. The array length will be a least 1.

    codingbat.array_1.maxTriple([1, 2, 3]) → 3
    codingbat.array_1.maxTriple([1, 5, 3]) → 5
    codingbat.array_1.maxTriple([5, 2, 3]) → 5
     */
    public int maxTriple(int[] nums) {
        int mid = nums.length / 2;

        int firstCheck = Math.max(nums[0], nums[mid]);

        return Math.max(firstCheck, nums[nums.length - 1]);
    }
}
