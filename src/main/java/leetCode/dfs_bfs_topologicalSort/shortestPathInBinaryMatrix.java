package leetCode.dfs_bfs_topologicalSort;

import java.util.LinkedList;
import java.util.Queue;

public class shortestPathInBinaryMatrix {
    /*
    In an N by N square grid, each cell is either empty (0) or blocked (1).

    A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
        - Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
        - C_1 is at location (0, 0) (ie. has value grid[0][0])
        - C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
        - If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
   Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

    Example 1:
    Input: [[0,1],
            [1,0]]
    Output: 2

    Example 2:
    Input: [[0,0,0],
            [1,1,0],
            [1,1,0]]
    Output: 4

    Note:
        1 <= grid.length == grid[0].length <= 100
        grid[r][c] is 0 or 1
     */
    //TC/S: O(m*n) where m is the number of rows and n is the number of columns
    public int shortestPathBinaryMatrix(int[][] grid) {
        //rows
        int m = grid.length;
        //columns
        int n = grid[0].length;

        //if the c_1 or c_k is 1, we can not start or reach the end
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        //perform a BFS search to search for the shortest path
        Queue<int[]> queue = new LinkedList<>();
        //add the first cell into the queue, e.g. row, column, steps
        queue.add(new int[]{0, 0, 1});

        //mark the first cell as visited
        grid[0][0] = 1;

        /*
            direction array has 8 different directions we can move:
            up, down, left, right and diagonally up-right, up-left, down-left, down-right
        */
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cell = queue.remove();

                //if we are at the last cell return the number of steps
                if (cell[0] == m - 1 && cell[1] == n - 1) {
                    return cell[2];
                }

                //look through all possible directions we can traverse to at the current cell
                for (int[] dir : directions) {
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];

                    /*
                        check for valid bounds and if the current cell is a 0, add the cell to the queue with an increased
                        count in steps, also mark the cell as visited
                     */
                    if (row < m && col < n && row >= 0 && col >= 0 && grid[row][col] == 0) {
                        queue.add(new int[]{row, col, cell[2] + 1});
                        grid[row][col] = 1;
                    }
                }
            }
        }
        //the last cell was never reached
        return -1;
    }
}
