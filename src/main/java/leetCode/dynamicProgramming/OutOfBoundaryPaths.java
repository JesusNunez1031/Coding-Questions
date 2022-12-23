package leetCode.dynamicProgramming;

import java.util.Arrays;

public class OutOfBoundaryPaths {
    /*
    There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed
    to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary).
    You can apply at most maxMove moves to the ball.

    Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the
    grid boundary. Since the answer can be very large, return it modulo 109 + 7.

    Example 1:
    Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
    Output: 6

    Example 2:
    Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
    Output: 12

    Constraints:
        1 <= m, n <= 50
        0 <= maxMove <= 50
        0 <= startRow < m
        0 <= startColumn < n
     */
    private static final int MOD = (int) (1e9 + 7);

    //TC: O(m * n * N) since the dp array is of size m * n * N
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        /*
            3D array holds an m arrays, with n rows, and maxMoves columns since in each cell in the grid, we can move
            maxMoves times hence we have maxMoves columns
         */
        int[][][] dp = new int[m][n][maxMove + 1];

        /*
            fill in all the rows with -1 in each grid to reflect that no paths have been found so far
        */
        for (int[][] grid : dp) {
            for (int[] array : grid) {
                Arrays.fill(array, -1);
            }
        }

        return searchForPaths(dp, m, n, maxMove, startRow, startColumn);
    }

    private static int searchForPaths(int[][][] dp, int m, int n, int N, int i, int j) {
        //return 1 if outside of bounds
        if (i >= m || i < 0 || j >= n || j < 0) {
            return 1;
        }

        //if no moves left return 0
        if (N == 0) {
            return 0;
        }

        //check if a grid cell has been visited before, if so return the number of paths found from this grid using N moves
        if (dp[i][j][N] >= 0) {
            return dp[i][j][N];
        }

        dp[i][j][N] = (
                (searchForPaths(dp, m, n, N - 1, i + 1, j) + searchForPaths(dp, m, n, N - 1, i - 1, j)) % MOD +
                        (searchForPaths(dp, m, n, N - 1, i, j + 1) + searchForPaths(dp, m, n, N - 1, i, j - 1)) % MOD) % MOD;

        //return all paths from the starting position i, j
        return dp[i][j][N];
    }

    public static void main(String[] args) {
        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        findPaths(m, n, maxMove, startRow, startColumn);
    }
}
