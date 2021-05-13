public class RangeSumQuery2DImmutable {
    /*
    Given a 2D matrix matrix, handle multiple queries of the following type:
        1. Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1)
        and lower right corner (row2, col2).

    Implement the NumMatrix class:
        - NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
        - int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the
          rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

    Example 1:
    Input
    ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
    [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
    Output
    [null, 8, 11, 12]
    Explanation
    NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
    numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
    numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
    numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)

    Constraints:
        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 200
        -105 <= matrix[i][j] <= 105
        0 <= row1 <= row2 < m
        0 <= col1 <= col2 < n
        At most 104 calls will be made to sumRegion.
     */
    class NumMatrix {

        /**
         * Your NumMatrix object will be instantiated and called as such:
         * NumMatrix obj = new NumMatrix(matrix);
         * int param_1 = obj.sumRegion(row1,col1,row2,col2);
         */
        int[][] matrix;

        //TC: O(n * m) and O(1) time per query
        public NumMatrix(int[][] matrix) {
            //for each column in the row and each row in a column, find the prefix sum of the cell
            //column
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] += matrix[i][j - 1];
                }
            }

            //row
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }

            //matrix is now full of cells with the prefix sum, doing this helps avoid having to iterate matrix for every query
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            //get the sum up to the last required index, i.e. bottom right index [row2][col2]
            int total = matrix[row2][col2];

        /*
            the "extra" part of the sum is all values starting from [0,0] up to col2
            EX: given matrix:
            [1, 2, 3, 4, 1]   prefix sum [1, 3, 6, 10, 11]
            [2, 3, 1, 0, 1]       ==>    [3, 8, 12, 16, 18]
            [5, 0, 1, 5, 4]              [8, 13, 18, 27, 33]
            [1, 2, 3, 0, 2]              [9, 16, 24, 33, 41]

            if we wanted the sum from [2, 2] [3, 4], the total sum would be matrix[3][4] = 41 and extra would be
            everything outside the rectangle i.e. [3, 1] + [1, 4] - [1, 1]
            [1, 1] is overlap so we subtract it so as to not double count it
        */
            int extra = (col1 != 0 ? matrix[row2][col1 - 1] : 0) + (row1 != 0 ? matrix[row1 - 1][col2] : 0) - ((row1 != 0 && col1 != 0) ? matrix[row1 - 1][col1 - 1] : 0);

            //to get the actual sum, remove the extra part of the matrix from the total sum up to the last index
            return total - extra;
        }
    }
}
