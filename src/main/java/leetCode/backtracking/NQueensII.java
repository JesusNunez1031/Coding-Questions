package leetCode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class NQueensII {
    /*
    The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
    Given an integer n, return the number of distinct solutions to the n-queens puzzle.

    Example 1:
    [][♕][][]       [][][♕][]
    [][][][♕]       [♕][][][]
    [♕][][][]       [][][][♕]
    [][][♕][]       [][♕][][]
    Input: n = 4
    Output: 2
    Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

    Example 2:
    Input: n = 1
    Output: 1

    Constraints:
        1 <= n <= 9
     */
    int solutions = 0;

    //TC: O(n ^ n) since we seek to find all solution on an n x n board
    public int totalNQueens(int n) {

        solveQueens(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());

        return solutions;
    }

    private void solveQueens(int n, int i, Set<Integer> diag, Set<Integer> diag2, Set<Integer> vertical) {
        /*
            when the whole board is traversed, we know all queens have been placed properly so we add 1 to the number of
            solutions made thus far
         */
        if (i == n) {
            solutions++;
            return;
        }

        for (int j = 0; j < n; j++) {
            /*
                a valid placement for a queen means no other queens exists on either of its diagonals and above or below
                it thus before placing a queen we check if these conditions are satisfied if they do, we move to set the
                current queen in row i at position j and save the index positions for later reference when placing other
                queens, otherwise, we backtrack and pick a new position for the previous queen
             */
            if (!diag.contains(i + j) && !diag2.contains(j - i) && !vertical.contains(j)) {
                diag.add(i + j);
                diag2.add(j - i);
                vertical.add(j);
                solveQueens(n, i + 1, diag, diag2, vertical);
                diag.remove(i + j);
                diag2.remove(j - i);
                vertical.remove(j);
            }
        }
    }
}
