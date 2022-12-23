package leetCode.twoDimentionArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pacificAtlanticWaterFlow {
    /*
    Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the
    "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
    Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

    Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

    Note:
    The order of returned grid coordinates does not matter.
    Both m and n are less than 150.

    Example:
    Given the following 5x5 matrix:
      Pacific ~   ~   ~   ~   ~
           ~  1   2   2   3  (5) *
           ~  3   2   3  (4) (4) *
           ~  2   4  (5)  3   1  *
           ~ (6) (7)  1   4   5  *
           ~ (5)  1   1   2   4  *
              *   *   *   *   * Atlantic
    Return:
    [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
     */
    //TC: (m * n) and O(n) space to store visited cells
    private List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> flow = new ArrayList<>();

        //check if the matrix is valid
        if (matrix.length == 0) {
            return flow;
        }

        //number of rows in matrix
        int m = matrix.length;

        //number of columns int matrix
        int n = matrix[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        /*
            placeholder value as the first smallest value, we don't set it to MAX_VALUE otherwise first case will always
            be true in dfs and no values will be checked
         */
        int minVal = Integer.MIN_VALUE;

        //traverse the row of each specific sea and mark all cells we can reach at every point
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, pacific, minVal);
            dfs(matrix, i, n - 1, atlantic, minVal);
        }

        //search through the columns of each sea and mark all the cells that can be reached
        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, pacific, minVal);
            dfs(matrix, m - 1, i, atlantic, minVal);
        }

        //search through the entire matrix and for every intersection we find, we add the cell to the final list
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //if a cell has been visited from the pacific and atlantic, we add it to the list
                if (pacific[i][j] && atlantic[i][j]) {
                    flow.add(Arrays.asList(i, j));
                }
            }
        }
        return flow;
    }

    private void dfs(int[][] matrix, int i, int j, boolean[][] visited, int minVal) {
        //check bounds for i and j and if the cell we are at has been visited
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length || visited[i][j]) {
            return;
        }

        //we can only move to the next value if the current value is greater than the last seen value
        if (matrix[i][j] < minVal) {
            return;
        }

        visited[i][j] = true;   //only mark a cell as visited if its value is greater than the previous value "minVal"

        //search all adjacent cells
        dfs(matrix, i - 1, j, visited, matrix[i][j]);   //search up
        dfs(matrix, i + 1, j, visited, matrix[i][j]);   //search down
        dfs(matrix, i, j + 1, visited, matrix[i][j]);   //search right
        dfs(matrix, i, j - 1, visited, matrix[i][j]);   //search left
    }
}
