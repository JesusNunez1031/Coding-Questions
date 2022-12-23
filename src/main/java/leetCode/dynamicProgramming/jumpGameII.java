package leetCode.dynamicProgramming;

public class jumpGameII {
    /*
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Your goal is to reach the last index in the minimum number of jumps.

    You can assume that you can always reach the last index.

    Example 1:
    Input: nums = [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps
    to the last index.

    Example 2:
    Input: nums = [2,3,0,1,4]
    Output: 2

    Constraints:
        1 <= nums.length <= 1000
        0 <= nums[i] <= 10^5
     */
    //TC: O(n)
    public int jump(int[] nums) {
        int jumps = 0; //number of jumps needed to reach end

        /*
            furthest is the farthest index that can be reached using all seen values
            Ex: given [2, 3, 1, 4]

            at the start furthest is 2 since we only have 2 jumps
            then when we get to index 1, using 3 jumps we can move to index 3 hence the furthest we can jump thus far is
            index 4

            end is the last index of ith jump, its updated when we've jumped "i" times
         */
        int end = 0, furthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            //update the furthest index we can jump to from the current index
            furthest = Math.max(furthest, i + nums[i]);

            /*
                when the ith index is equal to the "end" index, that means we've reached the end of a jump so we need to
                find a new jump hence we've used a jump and we update the end to the current furthest index we can jump
                to given the previous jump index values
             */
            if (i == end) {
                jumps++;
                end = furthest;

            }
        }
        return jumps;
    }
}
