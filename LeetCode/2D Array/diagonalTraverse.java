public class diagonalTraverse {
    /*
    Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
    Example:
    Input:
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]

    Output:  [1,2,4,7,5,3,6,8,9]
     */
    //TC: O(n) and constant space
    private int[] findDiagonalOrder(int[][] matrix) {
        //check if matrix is valid
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] diagonal = new int[m * n];
        int i = 0;
        int row = 0, col = 0;
        boolean up = true;  //diagonal traversal begins by going up

        while (row < m && col < n) {
            //going upwards
            if (up) {
                //to go up diagonally, the rows are decreased and the columns are increased
                while (row > 0 && col < n - 1) {
                    diagonal[i++] = matrix[row][col];
                    row--;
                    col++;
                }
                //since we break out of the loop before we add the last value, we add it here
                diagonal[i++] = matrix[row][col];

                /*
                    if we are at the end of a column, we need to start one column down from the current column so increase
                    the row, otherwise, we move one column to the right so we increase the column by 1
                */
                if (col == n - 1) {
                    row++;
                } else {
                    col++;
                }
                //going downwards
            } else {
                //to go down, we increase the rows and reduce the columns
                while (col > 0 && row < m - 1) {
                    diagonal[i++] = matrix[row][col];
                    row++;
                    col--;
                }
                //since we break out of the loop before we add the last value, we add it here
                diagonal[i++] = matrix[row][col];

                /*
                    if we are at the last row, we simply move one column to the right to begin upward traversal, otherwise,
                    we move down one row from the same column to begin the upwards traversal
                */
                if (row == m - 1) {
                    col++;
                } else {
                    row++;
                }
            }
            //alternate traversals
            up = !up;
        }
        return diagonal;
    }
}
