import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    /*
    You are given an m x n grid where each cell can have one of three values:
        - 0 representing an empty cell,
        - 1 representing a fresh orange, or
        - 2 representing a rotten orange.

    Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

    Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

    Example 1:
    Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
    Output: 4

    Example 2:
    Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
    Output: -1
    Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

    Example 3:
    Input: grid = [[0,2]]
    Output: 0
    Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

    Constraints:
        m == grid.length
        n == grid[i].length
        1 <= m, n <= 10
        grid[i][j] is 0, 1, or 2.
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0; // number of fresh oranges

        // search for rotten, and fresh oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // add rotten oranges to the queue for later BFS processing
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // check if all oranges are rotten
        if (freshCount == 0) {
            return 0;
        }

        // there is nothing to rot
        if (queue.size() == 0) {
            return -1;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = -1; // set to -1 so last iteration is not counted

        // go through all rotten oranges, and simulate rotting neighbor oranges
        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.remove();

                // check all 4 directions of a rotten orange
                for (int[] dir : directions) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    // check bounds
                    if (x <= grid.length - 1 && x >= 0 && y >= 0 && y <= grid[0].length - 1) {
                        // rot fresh oranges
                        if (grid[x][y] == 1) {
                            queue.add(new int[]{x, y});
                            grid[x][y] = 2;
                            freshCount--;
                        }
                    }
                }
            }
        }
        // if all oranges were rotten successfully return the elapsed time, otherwise it was not possible to rot all
        return freshCount == 0 ? minutes : -1;
    }
}
