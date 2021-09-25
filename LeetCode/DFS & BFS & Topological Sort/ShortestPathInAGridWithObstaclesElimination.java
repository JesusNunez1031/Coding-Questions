import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination {
    /*
    You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up,
    down, left, or right from and to an empty cell in one step.

    Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1)
    given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

    Example 1:
    Input:
    grid =
    [[0,0,0],
     [1,1,0],
     [0,0,0],
     [0,1,1],
     [0,0,0]],
    k = 1
    Output: 6
    Explanation:
    The shortest path without eliminating any obstacle is 10.
    The shortest path with one obstacle elimination at position (3,2) is 6.
    Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).

    Example 2:
    Input:
    grid =
    [[0,1,1],
     [1,1,1],
     [1,0,0]],
    k = 1
    Output: -1
    Explanation:
    We need to eliminate at least two obstacles to find such a walk.

    Constraints:
        m == grid.length
        n == grid[i].length
        1 <= m, n <= 40
        1 <= k <= m * n
        grid[i][j] == 0 or 1
        grid[0][0] == grid[m - 1][n - 1] == 0
     */

    class Coordinate {
        int x;
        int y;
        int swaps; // number of obstacles we can get rid of

        public Coordinate(int x, int y, int swaps) {
            this.x = x;
            this.y = y;
            this.swaps = swaps;
        }
    }

    //TC: O(m * n)
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int m = grid.length, n = grid[0].length;

        /*
            if we can clear more obstacles than the size of the array, we can get the shortest path by just clearing the
            shortest possible amount of obstacles, i.e. m - 1 + n - 1
         */
        if (k >= m + n - 2) {
            return m - 1 + n - 1;
        }
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // array used to track visited cells
        int[][] visited = new int[m][n];

        /*
            mark all cells as visited by setting their values to MAX. Each index represents the number of swaps, i.e. k
            value left for each cell in the grid. The way we'll know if a cell has been previously visited is by setting
            the number of swaps used so far to get to new cells, therefore, when we visit a new cell, and we've used
            more swaps than the current value set in the cell, we don't want to process this path since this would
            require the use of more swaps. In the case that there are no obstacles, because all cells are marked
            as Integer.MAX, we'll know if we've visited a cell if the cell value is 0.
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        // BFS queue
        Queue<Coordinate> queue = new LinkedList<>();

        // start on the first cell with no swaps used
        queue.add(new Coordinate(0, 0, 0));
        visited[0][0] = 0;

        int steps = 0; // number of steps to reach end cell

        while (!queue.isEmpty()) {
            int size = queue.size();

            // iterate through each cell in the queue and process the next vaid path from the cell
            while (size-- > 0) {
                Coordinate current = queue.remove();

                // check if we have reached the end
                if (current.x == m - 1 && current.y == n - 1) {
                    return steps;
                }

                // loop through all possible directions to see which new cell options are available
                for (int[] dir : directions) {
                    // row
                    int i = current.x + dir[0];
                    // col
                    int j = current.y + dir[1];

                    // check bounds
                    if (i >= 0 && i < m && j >= 0 && j < n) {
                        // calculate if we need to use a swap to be at the current cell
                        int swaps = current.swaps + grid[i][j];

                        /*
                            we can only move to this new cell if we still have swaps remaining and if the cell hasn't been
                            visited before, i.e. its value is Integer.MAX, or if we've found a shorter path using fewer
                            swaps than before
                         */
                        if (swaps <= k && swaps < visited[i][j]) {
                            queue.add(new Coordinate(i, j, swaps));
                            visited[i][j] = swaps; // mark the cell as visited by noting the number of swaps used to get here
                        }
                    }
                }
            }
            steps++;
        }
        return -1; // no valid path found
    }
}
