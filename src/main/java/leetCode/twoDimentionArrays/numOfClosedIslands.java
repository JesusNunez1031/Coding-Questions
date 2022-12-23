package leetCode.twoDimentionArrays;

public class numOfClosedIslands {
    /*
    Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s
    and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
    Return the number of closed islands.

    Example 1:
    Input: grid = [[1,1,1,1,1,1,1,0],
                   [1,0,0,0,0,1,1,0],
                   [1,0,1,0,1,1,1,0],
                   [1,0,0,0,0,1,0,1],
                   [1,1,1,1,1,1,1,0]]
    Output: 2

    Example 2:
    Input: grid = [[0,0,1,0,0],
                   [0,1,0,1,0],
                   [0,1,1,1,0]]
    Output: 1

    Example 3:
    Input: grid = [[1,1,1,1,1,1,1],
                   [1,0,0,0,0,0,1],
                   [1,0,1,1,1,0,1],
                   [1,0,1,0,1,0,1],
                   [1,0,1,1,1,0,1],
                   [1,0,0,0,0,0,1],
                   [1,1,1,1,1,1,1]]
    Output: 2
     */
    //Because our island should be covered with all "1", So we will start from first row and go till second to last row.
    //TC: O(row * col) =O(m * n)

    public static int closedIsland(int[][] grid) {
        int numOfIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j)) {
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    private static boolean dfs(int[][] grid, int i, int j) {
        if (grid[i][j] == 1 || grid[i][j] == -1) {
            return true;
        }

        if (i < 1 || i >= grid.length - 1 || j < 1 || j >= grid[0].length - 1) {
            return false;
        }
        grid[i][j] = -1;

        boolean down = dfs(grid, i - 1, j);
        boolean up = dfs(grid, i + 1, j);
        boolean left = dfs(grid, i, j - 1);
        boolean right = dfs(grid, i, j + 1);

        //if true, we know we are standing on a closed island
        return down && up && left && right;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};

        System.out.println(closedIsland(grid));
    }
}
