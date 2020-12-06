public class jumpGame {
    /*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Determine if you are able to reach the last index.

    Example 1:
    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:
    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


    Constraints:
        1 <= nums.length <= 3 * 10^4
        0 <= nums[i][j] <= 10^5
     */
    /*
                                                    Pseudocode: Greedy Algorithm
        1. we start from the end and consider the last index as the last_good_index, where the last_good_index is the
            index that allows us to get to the end of nums from the current position in nums
        2. for every value n - 1, we check if the current index i + nums[i] is >= last_good_index, if it is, that means we
            can get to the end from the current index so we update the last_good_index to i
        3. finally we check if last_good_index == 0, meaning we successfully got to first index from the end, if it is 0,
            that means we can get to the end from index 0 given the values in nums
    */
    //TC: O(n) where n is the length of nums
    private static boolean canJump(int[] nums) {
        int last_good_index = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= last_good_index) {
                last_good_index = i;
            }
        }
        return last_good_index == 0;
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 1, 0, 2, 0};
        System.out.println(canJump(arr));
    }
}
