package leetCode.binarySearch;

public class search2DMatrix {
    /*
        Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
        - Integers in each row are sorted from left to right.
        - The first integer of each row is greater than the last integer of the previous row.

    Example 1:
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
    Output: true

    Example 2:
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
    Output: false

    Example 3:
    Input: matrix = [], target = 0
    Output: false


    Constraints:

    m == matrix.length
    n == matrix[i].length
    0 <= m, n <= 100
    -104 <= matrix[i][j], target <= 104
     */

    /*
        TC: O(m log n), we search through m rows to check which row we will search for the target in, once a row is
        found we do a binary search through the n columns for the target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        //search through the start values in the rows to see which array we need to search through
        int row = 0;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == target) {
                return true;
            } else {
                if (matrix[i][0] <= target) {
                    row = i;
                }
            }
        }

        //if the target is not in the range of the given row values, the target does not exist in matrix
        if (!(target >= matrix[row][0] && target <= matrix[row][n - 1])) {
            return false;
        }

        //Perform a normal binary search for the target on the row
        int left = 0;
        int right = matrix[row].length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else {
                if (matrix[row][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        //target was not found
        return false;
    }

    /*
        This method runs in O(M + N) time since we first do a search for the row that might hold the target value, then
        if we find a row where its first value is less than the target, the target might be there so we avoid searching
        all cells taking O(N^2) time. This is much less efficient than doing a binary search
     */
    public boolean searchMatrixEz(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == target) {
                return true;
            } else {
                //if the target is greater than the first value of a row, we search that row
                if (matrix[i][0] <= target) {
                    row = i;
                }
            }
        }
        //search the given row for the value
        for (int j = 0; j < matrix[row].length; j++) {
            if (matrix[row][j] == target) {
                return true;
            }
        }
        return false;
    }
}
