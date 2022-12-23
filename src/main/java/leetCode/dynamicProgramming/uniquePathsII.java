package leetCode.dynamicProgramming;

public class uniquePathsII {
    /*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
    corner of the grid (marked 'Finish' in the diagram below).

    Now consider if some obstacles are added to the grids. How many unique paths would there be?
    An obstacle and space is marked as 1 and 0 respectively in the grid.

    Example 1:
    [start][cell][cell]
    [cell][block][cell]
    [cell][cell][finish]
    key: start -> beginning of robot trail
         cell -> a valid option for a path
         block -> obstacle in path
    Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
    Output: 2
    Explanation: There is one obstacle in the middle of the 3x3 grid above.
    There are two ways to reach the bottom-right corner:
    1. Right -> Right -> Down -> Down
    2. Down -> Down -> Right -> Right

    Example 2:
    [start][block]
    [cell][finish]
    Input: obstacleGrid = [[0,1],[0,0]]
    Output: 1

    Constraints:
        m == obstacleGrid.length
        n == obstacleGrid[i].length
        1 <= m, n <= 100
        obstacleGrid[i][j] is 0 or 1.
     */
    //TC/S: O(m * n) since we use a dp array to not modify path
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //if we start on an obstacle, there are no valid paths
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        //dp array keeps track of all the number of valid paths at every cell
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //add to the first step if we are on the first row or column and there is/was no obstacle
                if (i == 0 || j == 0) {
                    /*
                        check if the current cell is an obstacle or if there was an obstacle in a previous cell on the
                        first row or column, an obstacle in the first row means that row cant be used, same with column.
                     */
                    if (obstacleGrid[i][j] == 1 || (i > 0 && dp[i - 1][0] == 0) || (j > 0 && dp[i][j - 1] == 0)) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    /*
                        for any other cell, if we are not at an obstacle, the robot being able to only move right and down
                        means we will reach the current cell from either the left or above, hence we add to the path using
                        these cells' values.

                        if we are on an obstacle, then the path will turn to 0 since its not a valid cell to move to
                     */
                    if (obstacleGrid[i][j] != 1) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        //the last cell in dp will hold the sum of all valid paths in the obstacleGrid
        return dp[m - 1][n - 1];
    }
}
