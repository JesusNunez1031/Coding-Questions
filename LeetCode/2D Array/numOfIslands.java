public class numOfIslands {
    /*
    Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    Example 1:
    Input: grid = [
      ['1','1','1','1','0'],
      ['1','1','0','1','0'],
      ['1','1','0','0','0'],
      ['0','0','0','0','0']
    ]
    Output: 1

    Example 2:
    Input: grid = [
      ['1','1','0','0','0'],
      ['1','1','0','0','0'],
      ['0','0','1','0','0'],
      ['0','0','0','1','1']
    ]
    Output: 3

    Constraints:
        m == grid.length
        n == grid[i].length
        1 <= m, n <= 300
        grid[i][j] is '0' or '1'.
     */
    //Perform a DFS search on each value that is 1, sink surrounding land, and continue TC: O(n * n) and constant space
    public static int numIslands(char[][] grid) {
        int numOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //if we encounter some land, we need to sink all surrounding land to ensure we don't double count
                if(grid[i][j] == '1') {
                    numOfIslands++;
                    sinkLand(grid, i, j);
                }
            }
        }

        return numOfIslands;
    }

    private static void sinkLand(char[][] grid, int i, int j) {
        //check bounds and if we are not at sea
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        //sink piece of land
        grid[i][j] = '0';

        //check all adjacent cells
        sinkLand(grid, i - 1, j);   //search up
        sinkLand(grid, i + 1, j);   //search down
        sinkLand(grid, i, j + 1);   //search right
        sinkLand(grid, i, j - 1);   //search left
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands(grid));
    }
}
