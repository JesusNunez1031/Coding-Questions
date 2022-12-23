package leetCode.arrays;

public class FindWinnerOnATicTacToeGame {
    /*
    Tic-tac-toe is played by two players A and B on a 3 x 3 grid.

    Here are the rules of Tic-Tac-Toe:
        - Players take turns placing characters into empty squares (" ").
        - The first player A always places "X" characters, while the second player B always places "O" characters.
        - "X" and "O" characters are always placed into empty squares, never on filled ones.
        - The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
        - The game also ends if all squares are non-empty.
        - No more moves can be played if the game is over.
    Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid
    where they mark their respective character in the order in which A and B play.

    Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are
    still movements to play return "Pending".

    You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will
    play first.

    Example 1:
    Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
    Output: "A"
    Explanation: "A" wins, he always plays first.
    "X  "    "X  "    "X  "    "X  "    "X  "
    "   " -> "   " -> " X " -> " X " -> " X "
    "   "    "O  "    "O  "    "OO "    "OOX"

    Example 2:
    Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
    Output: "B"
    Explanation: "B" wins.
    "X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
    "   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
    "   "    "   "    "   "    "   "    "   "    "O  "

    Example 3:
    Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
    Output: "Draw"
    Explanation: The game ends in a draw since there are no moves to make.
    "XXO"
    "OOX"
    "XOX"

    Example 4:
    Input: moves = [[0,0],[1,1]]
    Output: "Pending"
    Explanation: The game has not finished yet.
    "X  "
    " O "
    "   "

    Constraints:
        1 <= moves.length <= 9
        moves[i].length == 2
        0 <= moves[i][j] <= 2
        There are no repeated elements on moves.
        moves follow the rules of tic tac toe.
     */
    //TC: O(m) where m is the number of rows in moves
    public String tictactoe(int[][] moves) {
        int n = 3; // board is 3 x 3

        // use arrays to track the rows and columns played by players
        int[] rows = new int[n], cols = new int[n];

        // used to track diagonals played by players
        int diag = 0, anti_diag = 0;

        // A = 1 B = -1 | player A starts
        int player = 1;

        for (int[] move : moves) {
            // get the row and column played
            int row = move[0];
            int col = move[1];

            // update the cell by the player that used it
            rows[row] += player;
            cols[col] += player;

            // check if the move was played on a diagonal
            if (row == col) {
                diag += player;
            }

            // check if the move was played on an anti-diagonal
            if (row + col == n - 1) {
                anti_diag += player;
            }

            /*
                check for winning conditions. If any cell in the rows or columns arrays is 3 the current player wins since
                each cell in the arrays represent an entire row in a "matrix", so if a player wins by choosing all 3 cells
                in the first row, rows[0] == 3, or the last columns, cols[2] == 3.

                This same logic applies to the diagonals, were any diagonal reaching 3 means the current player wins
             */
            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(anti_diag) == n) {
                return player == 1 ? "A" : "B";
            }

            // change players
            player *= -1;
        }

        // If all moves are completed and there is still no result, check if the grid is full or not. If so, the game ends with draw, otherwise pending.
        return moves.length == n * n ? "Draw" : "Pending";
    }
}
