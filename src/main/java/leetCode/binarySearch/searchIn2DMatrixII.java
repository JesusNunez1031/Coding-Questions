package leetCode.binarySearch;

public class searchIn2DMatrixII {
    /*
    Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
        - Integers in each row are sorted in ascending from left to right.
        - Integers in each column are sorted in ascending from top to bottom.

    Example 1:
    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
    Output: true

    Example 2:
    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
    Output: false

    Constraints:
        m == matrix.length
        n == matrix[i].length
        1 <= n, m <= 300
        -10^9 <= matrix[i][j] <= 10^9
        All the integers in each row are sorted in ascending order.
        All the integers in each column are sorted in ascending order.
        -10^9 <= target <= 10^9
     */
    //TC: O(m + n) where m is the rows and n are the columns in the matrix
    private boolean searchMatrix(int[][] matrix, int target) {
        //check for valid matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        /*
            start at the last column of the first row and move either left if current value is greater than the target,
            or down if its less than
        */
        int row = 0;
        int column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else {
                //if the current value is less than the target, we search in the next row otherwise we search backwards in the same row
                if (matrix[row][column] < target) {
                    row++;
                } else {
                    column--;
                }
            }
        }
        return false;
    }
}
