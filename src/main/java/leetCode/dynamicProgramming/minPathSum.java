package leetCode.dynamicProgramming;

public class minPathSum {
    /*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the
    sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.

    Example 1:
    Input: grid = [[1,3,1],
                   [1,5,1],
                   [4,2,1]]
    Output: 7
    Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

    Example 2:
    Input: grid = [[1,2,3],
                   [4,5,6]]
    Output: 12


    Constraints:
        m == grid.length
        n == grid[i].length
        1 <= m, n <= 200
        0 <= grid[i][j] <= 100
     */

    //TC: O(n^2) and O(n^2) space
    private int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        //initialize the first value of dp to the first value in grid
        dp[0][0] = grid[0][0];

        //add sum up to ith value of the first column in grid to dp array
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        //add sum up to ith value of the first row in grid to dp array
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        /*
            search through the grid starting from grid[1][1] adding to dp[i][j] the smallest value from the left or
            above plus the current value in grid[i][j]
         */
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }

        //the sum of the path will be at the last index of dp
        return dp[m - 1][n - 1];
    }
}
