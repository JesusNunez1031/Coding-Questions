public class burstBalloons {
    /*
    Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You
    are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
    Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

    Find the maximum coins you can collect by bursting the balloons wisely.

    Note:
        You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
        0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

    Example:
    Input: [3,1,5,8]
    Output: 167
    Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
                 coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
     */
    //TC: O(n^3) since we check all permutations of the array for highest coin yield and space used is O(n^2)
    private static int maxCoins(int[] nums) {
        int n = nums.length;

        /*
            we need a left value for the first index and a right value for the last value in nums so
            we make a new array of nums.length + 2 to account for these values
        */
        int[] newNums = new int[n + 2];
        for (int i = 0; i < newNums.length; i++) {
            if (i == 0 || i == newNums.length - 1) {
                newNums[i] = 1;
            } else {
                newNums[i] = nums[i - 1];
            }
        }
        int len = newNums.length;

        //dp array to hold the resulting coin value of popping balloons in different orders
        int[][] dp = new int[n + 2][n + 2];

        //start from the second balloon since this is the first position we can have a valid left index
        for (int k = 2; k < len; k++) {
            /*
                1. populate all the indexes calculating coins linearly through the array
                2. repeat step one, but now we exclude an index and the new max coins takes in consideration previous solutions
             */
            for (int left = 0; left < len - k; left++) {
                /*
                    when k increases, we are checking a new subarray
                    Ex: array = [1, 3, 1, 5, 8, 1] k is the window of values considered
                    k = 2, all the values of right = 1, 5, 8, 1
                    k = 3, right = 5, 8, 1
                    k = 4, right = 8, 1
                    k = 5 right = 1
                 */
                int right = left + k;
                /*
                    i is the index in between left and right so we check all the indexes of i until we reach right
                    Ex: [1, 3, 1, 5, 8, 1] ==> [1, 3, 1, 5, 8, 1]
                         ↑  ↑  ↑                   ↑  ↑  ↑
                       left i right              left i right
                 */
                for (int i = left + 1; i < right; i++) {
                    /*
                        we set the value of dp[left][right] to the greater value between the current value in the index
                        or the new value of popping the current balloon with its left and right + all solutions of popping
                        the left balloons + all the right balloons
                     */
                    dp[left][right] = Math.max(dp[left][right], newNums[left] * newNums[i] * newNums[right] + dp[i][right] + dp[left][i]);
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        int[] balloons = {3, 1, 5, 8};
        System.out.println(maxCoins(balloons));
    }
}
