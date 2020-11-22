public class islandPerimeter {
    /*
    You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
    Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
    The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

    Example 1:
    Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
    Output: 16
    Explanation: The perimeter is the 16 yellow stripes in the image above.

    Example 2:
    Input: grid = [[1]]
    Output: 4

    Example 3:
    Input: grid = [[1,0]]
    Output: 4

    Constraints:
        row == grid.length
        col == grid[i].length
        1 <= row, col <= 100
        grid[i][j] is 0 or 1.
     */
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //if the current value is 1, we assume its a lone square so add 4
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    //check if there is a 1 left to it and if there is, subtract 2 from perimeter
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter--;
                    }
                    //check right for a 1, if there is we have one less connection
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                        perimeter--;
                    }
                    //check down for a 1
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        perimeter--;
                    }
                    //check up for a 1
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter--;
                    }
                    /*
                    //--------------------------------------------//
                                simplified
                      since we know that grid cells are connected horizontally/vertically
                      (not diagonally) we can just check once side and above for each 1 encountered
                      if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                      }
                      if (i > 0 && grid[i - 1][j] == 1) {
                         perimeter -= 2;
                      }
                      we don't have to check all the dimensions of a found 1
                     */
                }
            }
        }
        return perimeter;
    }
}
