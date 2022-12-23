package leetCode.twoDimentionArrays;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    /*
    Given an m x n matrix, return all elements of the matrix in spiral order.

    Example 1:
     ___________
    | 1 → 2 → 3 |
    |         ↓ |
    | 4 → 5   6 |
    |  ↑      ↓ |
    | 7 ← 8 ← 9 |
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1,2,3,6,9,8,7,4,5]

    Example 2:
     __________________
    | 1 →  2 →  3 →  4 |
    |                ↓ |
    | 5 →  6 →  7    8 |
    |  ↑             ↓ |
    | 9 ← 10 ← 11 ← 12 |
    Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]


    Constraints:
        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 10
        -100 <= matrix[i][j] <= 100
     */
    //TC:O(n) and constant space
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        /*  row_start - starting row index
            row_end - ending row index
            col_start - starting column index
            col_end - length of the first row
        */
        int row_start = 0, row_end = matrix.length - 1;
        int col_start = 0, col_end = matrix[0].length - 1;

        while (row_start <= row_end && col_start <= col_end) {
            //depending on what row we are, we want to add values from left to right
            for (int j = col_start; j <= col_end; j++) {
                res.add(matrix[row_start][j]);
            }
            /*
                once we reach the end of the row, we add the values from top down starting from one row under the last
                used row to avoid adding a duplicate
             */
            for (int i = row_start + 1; i <= row_end; i++) {
                res.add(matrix[i][col_end]);
            }

            /*
                if we haven't yet reached the final row if the spiral, we now do the reverse, adding values from left
                to right, and then down up
             */
            if (row_start < row_end && col_start < col_end) {
                /*
                    add the values from the row we just ended at starting from -1 the last used value in the row and end
                    at col_start
                 */

                for (int j = col_end - 1; j > col_start; j--) {
                    res.add(matrix[row_end][j]);
                }

                //we add values going up from col_start to the row just before the last used row
                for (int i = row_end; i > row_start; i--) {
                    res.add(matrix[i][col_start]);
                }
            }

            /*
                increment the start of the row and col so we start from the row below the last executed, and decrement the
                row_end end and col_end so as to close the gap
            */
            row_start++;
            row_end--;
            col_start++;
            col_end--;
        }
        return res;
    }
}
