public class matrixDiagonalSum {
    /*
        Given a square matrix mat, return the sum of the matrix diagonals.
        Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

        Example 1:
        Input: mat = [[1,2,3],
                      [4,5,6],
                      [7,8,9]]
        Output: 25
        Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
        Notice that element mat[1][1] = 5 is counted only once.

        Example 2:
        Input: mat = [[1,1,1,1],
                      [1,1,1,1],
                      [1,1,1,1],
                      [1,1,1,1]]
        Output: 8

        Example 3:
        Input: mat = [[5]]
        Output: 5
     */
    private int diagonalSum(int[][] mat) {
        int rows = mat.length;
        int col = mat[0].length;
        int sum = 0;

        //add all values from left to right diagonal
        for (int i = 0, j = 0; i < rows && j < col; i++, j++) {
            sum += mat[i][j];
        }

        //add all values from right to left diagonal
        for (int i = 0, j = col - 1; i < rows && j >= 0; i++, j--) {
            //if the length of the matrix is odd, we skip over the duplicate index
            if (rows % 2 != 0 && i == j) {
                continue;
            } else {
                sum += mat[i][j];
            }
        }
        return sum;
    }
}
