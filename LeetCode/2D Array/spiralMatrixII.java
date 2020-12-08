public class spiralMatrixII {
    /*
    Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

    Example 1:
     ___________
    | 1 → 2 → 3 |
    |         ↓ |
    | 8 → 9   4 |
    |  ↑      ↓ |
    | 7 ← 6 ← 5 |
    Input: n = 3
    Output: [[1,2,3],[8,9,4],[7,6,5]]
    Example 2:

    Input: n = 1
    Output: [[1]]

    Constraints:
        1 <= n <= 20
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int row_start = 0, row_end = n - 1;
        int col_start = 0, col_end = n - 1;

        int val = 1;

        while (row_start <= row_end && col_start <= col_end) {
            //add values for the current row "row_start" from left to right changing the column
            for (int j = col_start; j <= col_end; j++) {
                matrix[row_start][j] = val++;
            }
            //add values to the last column going from top down changing only the row
            for (int i = row_start + 1; i <= row_end; i++) {
                matrix[i][col_end] = val++;
            }

            //If we still haven't yet finished populating the matrix
            if (row_start < row_end && col_start < col_end) {
                //we are now at row "row_end" "col_end", so we add values in that row from left to right changing the column
                for (int j = col_end - 1; j > col_start; j--) {
                    matrix[row_end][j] = val++;
                }

                /*
                    last, we need to add values going down up from the last "row_end" "col_start" to the row just below
                    the first row used changing the row
                 */
                for (int i = row_end; i > row_start; i--) {
                    matrix[i][col_start] = val++;
                }
            }
            //inc the start of row and column by 1 and decrement the ends by 1 since we've populated the insides of the matrix
            row_start++;
            row_end--;
            col_start++;
            col_end--;
        }
        return matrix;
    }
}
