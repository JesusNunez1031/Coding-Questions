package leetCode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    /*
    The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
    Given an integer n, return all distinct solutions to the n-queens puzzle.

    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

    Example 1:
    Input: n = 4
    Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

    Example 2:
    Input: n = 1
    Output: [["Q"]]

    Constraints:
        1 <= n <= 9
     */
    List<List<String>> result = new ArrayList<>();

    //TC: O(n ^ n) since we solve for all board leetCode.backtracking.combinations, and O(n) space
    public List<List<String>> solveNQueens(int n) {
        //a queen can move in all directions in a n x n board so we have sets to check the diagonals and vertical positions previous queens have been placed to avoid wring placements
        solveNQueens(new int[n][n], 0, new HashSet<>(), new HashSet<>(), new HashSet<>());

        return result;
    }

    private void solveNQueens(int[][] board, int i, Set<Integer> diagonal, Set<Integer> diagonal2, Set<Integer> vertical) {
        //i are the rows in the board, so when all rows have been processed, we have a complete board
        if (i == board.length) {
            addToResult(board);
            return;
        }

        //j are the columns in the current ith row
        for (int j = 0; j < board.length; j++) {
            //we can place a queen of there is no other queen on the left or right diagonal, or directly above or below it
            if (!diagonal.contains(i + j) && !diagonal2.contains(j - i) && !vertical.contains(j)) {
                //setting the board index to 1 is equivalent to placing a queen at the index
                board[i][j] = 1;

                //add the current diagonals and column position to the sets so we can use them to check for a valid position of the next queen
                diagonal.add(i + j);
                diagonal2.add(j - i);
                vertical.add(j);
                solveNQueens(board, i + 1, diagonal, diagonal2, vertical);
                board[i][j] = 0;
                diagonal.remove(i + j);
                diagonal2.remove(j - i);
                vertical.remove(j);
            }
        }
    }

    //Converts a board where 1's are queens and 0's are dots to a string matrix of Q's and ...'s
    private void addToResult(int[][] board) {
        List<String> qBoard = new ArrayList<>();
        for (int[] rows : board) {
            StringBuilder sb = new StringBuilder(); //converts the row to a string row
            for (int value : rows) {
                if (value == 0) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            qBoard.add(sb.toString());
        }
        result.add(qBoard);
    }
}
