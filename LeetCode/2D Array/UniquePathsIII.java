public class UniquePathsIII {
    /*
    You are given an m x n integer array grid where grid[i][j] could be:
        - 1 representing the starting square. There is exactly one starting square.
        - 2 representing the ending square. There is exactly one ending square.
        - 0 representing empty squares we can walk over.
        - -1 representing obstacles that we cannot walk over.
    Return the number of 4-directional walks from the starting square to the ending square, that walk over every
    non-obstacle square exactly once.

    Example 1:
    Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
    Output: 2
    Explanation: We have the following two paths:
    1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
    2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

    Example 2:
    Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
    Output: 4
    Explanation: We have the following four paths:
    1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
    2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
    3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
    4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

    Example 3:
    Input: grid = [[0,1],[2,0]]
    Output: 0
    Explanation: There is no path that walks over every empty square exactly once.
    Note that the starting and ending square can be anywhere in the grid.

    Constraints:
        m == grid.length
        n == grid[i].length
        1 <= m, n <= 20
        1 <= m * n <= 20
        -1 <= grid[i][j] <= 2
        There is exactly one starting cell and one ending cell.
     */
    //TC: O(m * n) where m is the number of rows and n is the number of columns
    public int uniquePathsIII(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int squares = 0; // number of empty squares
        int startRow = 0;
        int startCol = 0;

        // search for start and count how many squares we can walk through
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                } else if (grid[i][j] == 0) {
                    squares++;
                }
            }
        }
        return findPaths(grid, startRow, startCol, squares + 1);
    }

    private int findPaths(int[][] grid, int i, int j, int squares) {
        // check bounds
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == -1) {
            return 0;
        }

        /*
            check if we are at the end, and if all squares have been used, a path was found, as all empty squares must
            be used once.
         */
        if (grid[i][j] == 2) {
            if (squares == 0) {
                return 1;
            }
            return 0;
        }

        int temp = grid[i][j];
        grid[i][j] = -1; // mark the current cell as visited

        // search on all directions from the current i,j cell
        int paths = findPaths(grid, i + 1, j, squares - 1) +
                findPaths(grid, i - 1, j, squares - 1) +
                findPaths(grid, i, j - 1, squares - 1) +
                findPaths(grid, i, j + 1, squares - 1);

        grid[i][j] = temp; // backtrack

        return paths;
    }
}
