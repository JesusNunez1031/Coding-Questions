package leetCode.dynamicProgramming;

public class longestIncreasingPathInMatrix {
    /*
    Given an m x n integers matrix, return the length of the longest increasing path in matrix.
    From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move
    outside the boundary (i.e., wrap-around is not allowed).

    Example 1:
    Input: matrix = [[9,9,4],
                     [6,6,8],
                     [2,1,1]]
    Output: 4
    Explanation: The longest increasing path is [1, 2, 6, 9].

    Example 2:
    Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
    Output: 4
    Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

    Example 3:
    Input: matrix = [[1]]
    Output: 1

    Constraints:
        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 200
        0 <= matrix[i][j] <= 2^31 - 1
     */
    //TC/S: O(n * m)
    public int longestIncreasingPath(int[][] matrix) {
        //check for a valid matrix
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;

        //dp array holds the length of the longest path for each matrix[i][j] value
        int[][] dp = new int[m][n];
        int longest = 0; //longest increasing path

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int path = dfs(matrix, dp, Integer.MIN_VALUE, i, j); //longest path generated from the current index
                longest = Math.max(longest, path);
            }
        }
        return longest;
    }

    private int dfs(int[][] matrix, int[][] dp, int prev, int i, int j) {
        //check bounds and if we are on a valid path
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || matrix[i][j] <= prev) {
            return 0;
        }
        //if we're at an index where a path has been found, return it so as to avoid extra work, i.e. memoization
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int maxPath = 0; //length of the current path

        //current path searching in all directions from the start index
        maxPath = Math.max(maxPath, dfs(matrix, dp, matrix[i][j], i + 1, j));
        maxPath = Math.max(maxPath, dfs(matrix, dp, matrix[i][j], i - 1, j));
        maxPath = Math.max(maxPath, dfs(matrix, dp, matrix[i][j], i, j + 1));
        maxPath = Math.max(maxPath, dfs(matrix, dp, matrix[i][j], i, j - 1));

        //the max length is 1 + the path found, +1 to account for the current element
        dp[i][j] = 1 + maxPath;

        //return the max path of the start i j indexes
        return dp[i][j];
    }
}
