public class targetSum {
    /*
    You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
    For each integer, you should choose one from + and - as its new symbol.
    Find out how many ways to assign symbols to make sum of integers equal to target S.

    Example 1:
    Input: nums is [1, 1, 1, 1, 1], S is 3.
    Output: 5
    Explanation:
    -1+1+1+1+1 = 3
    +1-1+1+1+1 = 3
    +1+1-1+1+1 = 3
    +1+1+1-1+1 = 3
    +1+1+1+1-1 = 3

    There are 5 ways to assign symbols to make the sum of nums be target 3.

    Constraints:
        The length of the given array is positive and will not exceed 20.
        The sum of elements in the given array will not exceed 1000.
        Your output answer is guaranteed to be fitted in a 32-bit integer.
     */
    private static int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, S, 0);
    }

    /*
        DFS solution to find all possible ways TC: O(2^n) where n is the size of nums array, this performs poorly since
        we calculate sums more than once for various indexes therefore doing extra unnecessary work, DP can solve this
        inefficiency
     */
    private static int dfs(int[] nums, int sum, int target, int i) {
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            }
        }

        if (i < 0 || i >= nums.length || nums[i] < 0) {
            return 0;
        }

        //Search the right adding to the sum and then do the same but subtracting from the sum
        return dfs(nums, sum + nums[i], target, i + 1) + dfs(nums, sum - nums[i], target, i + 1);
    }

    //Method without the use of a sum variable
    private int dfs(int[] nums, int i, int target) {
        //when we reach the end of the array, if the target == 0, one way has been found
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            }
        }

        //check for bounds
        if (i < 0 || i >= nums.length || nums[i] < 0) {
            return 0;
        }

        //look to the right of the array adding and subtracting from target
        return dfs(nums, i + 1, target + nums[i]) + dfs(nums, i + 1, target - nums[i]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int sum = 3;
        System.out.println(findTargetSumWays(arr, sum));
    }
}
