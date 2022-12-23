package codingbat.recursion_1;

public class array6 {
    /*
    Given an array of ints, compute recursively if the array contains a 6. We'll use the convention of considering only
    the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down
    the array. The initial call will pass in index as 0.

    codingbat.recursion_1.array6([1, 6, 4], 0) → true
    codingbat.recursion_1.array6([1, 4], 0) → false
    codingbat.recursion_1.array6([6], 0) → true
     */
    public boolean array6(int[] nums, int index) {
        if (index >= nums.length) {
            return false;
        }
        if (nums[index] == 6) {
            return true;
        }
        return array6(nums, index + 1);
    }
}
