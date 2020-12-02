public class randomPickIndex {
    /*
    Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
    Note:
    The array size can be very large. Solution that uses too much extra space will not pass the judge.

    Example:
    int[] nums = new int[] {1,2,3,3,3};
    Solution solution = new Solution(nums);

    // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
    solution.pick(3);

    // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
    solution.pick(1);
     */
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int param_1 = obj.pick(target);
     */

    private int[] nums;

    /*
        Another approach is to iterate through the list of numbers adding the indexes of the target to a map, then
        choosing one index at random
     */
    public randomPickIndex(int[] nums) {
        this.nums = nums;
    }

    /*
        Reservoir sampling approach:
            We assume the numbers in the list come as a stream of values, so if we where to pick a random index for any
            value in the array, we would consider all possible index but since we are given a target value, the
            probability of an index being chosen still remains 1 / n, however, we only consider the indexes of the target
            value. So every time we encounter the target, we have to choose whether or not we pick the current index or not.

     */
    public int pick(int target) {
        int index = 0;
        int scope = 0;  //the more target indexes we encounter, the lower the probability to pick an index of i + 1 gets

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                scope++;
                if (Math.random() < 1.0 / scope) {
                    index = i;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 2, 4, 6, 2, 7, 8, 6, 2, 5, 6, 2, 2, 2, 2, 2};
        randomPickIndex ob = new randomPickIndex(nums);
        System.out.println(ob.pick(2));
    }
}
