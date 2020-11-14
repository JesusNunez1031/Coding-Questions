public class groupNoAdj {
    /*
    Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given
    target with this additional constraint: If a value in the array is chosen to be in the group, the value immediately
    following it in the array must not be chosen. (No loops needed.)

    groupNoAdj(0, [2, 5, 10, 4], 12) → true
    groupNoAdj(0, [2, 5, 10, 4], 14) → false
    groupNoAdj(0, [2, 5, 10, 4], 7) → false
     */
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }

        //if we use start, the next call will use the value 2 down from start avoiding adjacent value
        if (groupNoAdj(start + 2, nums, target - nums[start])) {
            return true;
        }

        //call the method again not considering start used on first call
        return groupNoAdj(start + 1, nums, target);
    }
}
