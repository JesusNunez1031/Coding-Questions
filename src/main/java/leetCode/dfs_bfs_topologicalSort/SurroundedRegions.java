package leetCode.dfs_bfs_topologicalSort;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    /*
    Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
    A region is captured by flipping all 'O's into 'X's in that surrounded region.

    Example 1:
    Input: board = [
                    ["X","X","X","X"],
                    ["X","O","O","X"],
                    ["X","X","O","X"],
                    ["X","O","X","X"]]
    Output: [
            ["X","X","X","X"],
            ["X","X","X","X"],
            ["X","X","X","X"],
            ["X","O","X","X"]]
    Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are
    not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped
    to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

    Example 2:
    Input: board = [["X"]]
    Output: [["X"]]

    Constraints:
        m == board.length
        n == board[i].length
        1 <= m, n <= 200
        board[i][j] is 'X' or 'O'.
     */
    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // TC: O(m * n)
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // queue used to store all O's located in borders
        Queue<Coordinate> queue = new LinkedList<>();

        /* search for all border O's */
        for (int i = 0; i < n; i++) {
            // check first cell in row
            if (board[i][0] == 'O') {
                board[i][0] = '.';  // mark cell
                queue.add(new Coordinate(i, 0));
            }

            // check last cell in row
            if (board[i][m - 1] == 'O') {
                board[i][m - 1] = '.';  // mark cell
                queue.add(new Coordinate(i, m - 1));
            }
        }

        for (int j = 1; j <= m - 1; j++) {
            // check cells in first row
            if (board[0][j] == 'O') {
                board[0][j] = '.';  // mark cell
                queue.add(new Coordinate(0, j));
            }

            // check cells in last row
            if (board[n - 1][j] == 'O') {
                board[n - 1][j] = '.';  // mark cell
                queue.add(new Coordinate(n - 1, j));
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        /*
            starting from each O found on boarders, check if they are connected to other inner O's in the board, if so,
            they cannot be tuned to X's, so we mark them to not convert them
        */
        while (!queue.isEmpty()) {
            Coordinate p = queue.remove();

            /* check all directions to the current O */
            for (int[] dir : directions) {
                int i = p.x + dir[0];
                int j = p.y + dir[1];

                // check bounds, and if the current cell is an O, add it to the queue
                if (i >= 0 && i <= n - 1 && j >= 0 && j <= m - 1 && board[i][j] == 'O') {
                    board[i][j] = '.';
                    queue.add(new Coordinate(i, j));
                }
            }
        }

        // loop through matrix, and switch all valid O's, i.e. non '.' cells to X's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
