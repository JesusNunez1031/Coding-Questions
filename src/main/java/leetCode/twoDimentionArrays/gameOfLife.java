package leetCode.twoDimentionArrays;

public class gameOfLife {
    /*
    According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by
    the British mathematician John Horton Conway in 1970."
    The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or
    dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the
    following four rules (taken from the above Wikipedia article):

        - Any live cell with fewer than two live neighbors dies as if caused by under-population.
        - Any live cell with two or three live neighbors lives on to the next generation.
        - Any live cell with more than three live neighbors dies, as if by over-population.
        - Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    The next state is created by applying the above rules simultaneously to every cell in the current state, where births
    and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.



    Example 1:
    Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
    Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

    Example 2:
    Input: board = [[1,1],[1,0]]
    Output: [[1,1],[1,1]]


    Constraints:
        m == board.length
        n == board[i].length
        1 <= m, n <= 25
        board[i][j] is 0 or 1.

     */
    //TC/S: O(n)
    private void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] updated = new int[m][n];

        //direction array
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;  //holds the number of live neighbors
                //look at all directions from the current cell
                for (int[] d : dir) {
                    int p = i + d[0];
                    int q = j + d[1];

                    //check bounds and if the current cell is live
                    if (p >= 0 && p < m && q >= 0 && q < n && board[p][q] == 1) {
                        count++;
                    }
                }
                //we only care to update live cells, if the cell is 0, then we cant update it
                if (board[i][j] == 1) {
                    //Any live cell with two or three live neighbors lives on to the next generation.
                    if (count == 2 || count == 3) {
                        updated[i][j] = 1;
                    }
                } else {
                    //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                    if (count == 3) {
                        updated[i][j] = 1;
                    }
                }
            }
        }

        //update the board to the new board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = updated[i][j];
            }
        }
    }
}
