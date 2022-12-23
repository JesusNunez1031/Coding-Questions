package leetCode.backtracking;

public class SudokuSolver {
    /*
    Write a program to solve a Sudoku puzzle by filling the empty cells.

    A sudoku solution must satisfy all the following rules:
        Each of the digits 1-9 must occur exactly once in each row.
        Each of the digits 1-9 must occur exactly once in each column.
        Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

    The '.' character indicates empty cells.

    Example 1:
    Input: board = [["5","3",".",".","7",".",".",".","."],
                    ["6",".",".","1","9","5",".",".","."],
                    [".","9","8",".",".",".",".","6","."],
                    ["8",".",".",".","6",".",".",".","3"],
                    ["4",".",".","8",".","3",".",".","1"],
                    ["7",".",".",".","2",".",".",".","6"],
                    [".","6",".",".",".",".","2","8","."],
                    [".",".",".","4","1","9",".",".","5"],
                    [".",".",".",".","8",".",".","7","9"]]
    Output: [["5","3","4","6","7","8","9","1","2"],
             ["6","7","2","1","9","5","3","4","8"],
             ["1","9","8","3","4","2","5","6","7"],
             ["8","5","9","7","6","1","4","2","3"],
             ["4","2","6","8","5","3","7","9","1"],
             ["7","1","3","9","2","4","8","5","6"],
             ["9","6","1","5","3","7","2","8","4"],
             ["2","8","7","4","1","9","6","3","5"],
             ["3","4","5","2","8","6","1","7","9"]]
    Explanation: The input board is shown above and the only valid solution is shown below:

    Constraints:
        board.length == 9
        board[i].length == 9
        board[i][j] is a digit or '.'.
        It is guaranteed that the input board has only one solution.
     */
    //TC: O(n^n) where n is the length of the board, i.e. 9
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        // when col == 9, the current row has just been completed
        if (col == 9) {
            // move to the next row and reset column
            row++;
            col = 0;
        }

        // if we reached the last row, the board was solved with no issues
        if (row == 9) {
            return true;
        }

        // move to the next column in the row if there already exists a value
        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        // start adding values to the current cell starting from 1 up to 9
        for (char num = '1'; num <= '9'; num++) {
            // check if the addition of num to the current cell breaks the validity of the board's row, column, and sub-box
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                // if the row was solved, return true
                if (solve(board, row, col + 1)) {
                    return true;
                } else {
                    // backtrack by deleting the value at the cell and then placing a new number
                    board[row][col] = '.';
                }
            }
        }
        // board was not solvable
        return false;
    }

    // checks all the cells of the current row, column, and sub-box in the board
    private boolean isValid(char[][] board, int row, int col, char num) {
        // calculate the current sub-box in the board
        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;

        for (int i = 0; i < 9; i++) {
            // check the row, column, and 3x3 sub-box
            if (board[i][col] == num || board[row][i] == num || board[sRow + i / 3][sCol + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
