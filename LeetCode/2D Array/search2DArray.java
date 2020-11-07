public class search2DArray {
    /*
        Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.

        THis method runs in O(M + N) time since we first do a search for the row that might hold the target value, then if we find a row where its
        first value is less than the target, the target might be there so we avoid searching all cells taking O(N^2) time
     */
    public boolean searchMatrix(int[][] matrix, int target) {
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
