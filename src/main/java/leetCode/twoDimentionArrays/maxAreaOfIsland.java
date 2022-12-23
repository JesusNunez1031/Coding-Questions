package leetCode.twoDimentionArrays;

public class maxAreaOfIsland {
    /*
    You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
    (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

    The area of an island is the number of cells with a value 1 in the island.

    Return the maximum area of an island in grid. If there is no island, return 0.

    Example 1:
    Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
                   [0,0,0,0,0,0,0,1,1,1,0,0,0],
                   [0,1,1,0,1,0,0,0,0,0,0,0,0],
                   [0,1,0,0,1,1,0,0,1,0,1,0,0],
                   [0,1,0,0,1,1,0,0,1,1,1,0,0],
                   [0,0,0,0,0,0,0,0,0,0,1,0,0],
                   [0,0,0,0,0,0,0,1,1,1,0,0,0],
                   [0,0,0,0,0,0,0,1,1,0,0,0,0]]
    Output: 6
    Explanation: The answer is not 11, because the island must be connected 4-directionally.

    Example 2:
    Input: grid = [[0,0,0,0,0,0,0,0]]
    Output: 0

    Constraints:
        m == grid.length
        n == grid[i].length
        1 <= m, n <= 50
        grid[i][j] is either 0 or 1.
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int area = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //dfs search from the current island
                if (grid[i][j] == 1) {
                    area = Math.max(area, findArea(grid, i, j));
                }
            }
        }
        return area;
    }

    private static int findArea(int[][] grid, int i, int j) {
        //check bounds and if we are still on an island, i.e. grid[i][j] == 1
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        //set the current value to 0 to not repeat
        grid[i][j] = 0;

        //search up down left and right
        return 1 + findArea(grid, i, j - 1) + findArea(grid, i, j + 1) + findArea(grid, i + 1, j) + findArea(grid, i - 1, j);

        //-------------------------------//
//                  Another way
//        int area = 1;
//        //set the current value to 0 to not repeat
//        grid[i][j] = 0;
//
//        area += findArea(grid, i, j - 1);
//        area += findArea(grid, i, j + 1);
//        area += findArea(grid, i + 1, j);
//        area += findArea(grid, i - 1, j);
//        return area;
    }

    public static void main(String[] args) {
        int[][] island = {{1, 1, 1, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(maxAreaOfIsland(island));
    }
}
