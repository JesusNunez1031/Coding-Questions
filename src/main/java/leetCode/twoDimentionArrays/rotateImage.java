package leetCode.twoDimentionArrays;

public class rotateImage {
    /*
    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
    DO NOT allocate another 2D matrix and do the rotation.

    Example 1:
    Input: matrix = [[1,2,3],
                     [4,5,6],
                     [7,8,9]]
    Output: [[7,4,1],
             [8,5,2],
             [9,6,3]]

    Example 2:
    Input: matrix = [[5,1,9,11],
                     [2,4,8,10],
                     [13,3,6,7],
                     [15,14,12,16]]
    Output: [[15,13,2,5],
             [14,3,4,1],
             [12,6,8,9],
             [16,7,10,11]]

    Example 3:
    Input: matrix = [[1]]
    Output: [[1]]

    Example 4:
    Input: matrix = [[1,2],
                     [3,4]]
    Output: [[3,1],
             [4,2]]


    Constraints:
        matrix.length == n
        matrix[i].length == n
        1 <= n <= 20
        -1000 <= matrix[i][j] <= 1000
     */

    //TC: O(N x N)
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            //we want to traverse diagonally in the matrix so we set j to i so at every new row we start at 0 + i
            for (int j = i; j < n; j++) {
                //swap values in row with its column counterpart to transpose matrix, all diagonal values remain unchanged
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //swap the first n/2 values in the row with the last half of the row to complete swap
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

        //since the matrix is N x N, we can preform this type of algorithm
    }

    public static void main(String[] args) {
        int[][] img = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        rotate(img);
    }
}
