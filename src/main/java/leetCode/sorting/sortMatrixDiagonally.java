package leetCode.sorting;

import java.util.Arrays;

public class sortMatrixDiagonally {
    /*
    A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column
    and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting
    from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

    Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.

    Example 1:

    Input: mat = [[3,3,1,1],
                  [2,2,1,2],
                  [1,1,1,2]]
    Output: [[1,1,1,1],
             [1,2,2,2],
             [1,2,3,3]]

    Constraints:
        m == mat.length
        n == mat[i].length
        1 <= m, n <= 100
        1 <= mat[i][j] <= 100
     */
    //TC/S: O((m + n) * k) where k = min(m. n) and constant space since an array of size 100 can be considered constant space
    private static int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        //sort diagonals that start from the first row
        for (int j = 0; j < n; j++) {
            sort(mat, 0, j, m, n);
        }

        //sort diagonals that start from the first column
        for (int i = 1; i < m; i++) {   //start from first row since the first rows diagonals have been sorted
            sort(mat, i, 0, m, n);
        }
        return mat;
    }

    //Sorts a given row and column of 2-D matrix mat
    private static void sort(int[][] mat, int row, int col, int m, int n) {
        //since the max value mat[i][j] == 100, we can use count sort to sort the matrix
        int[] values = new int[101];

        int r = row, c = col;

        //add the count of values to the values array
        while (r < m && c < n) {
            values[mat[r][c]]++;
            r++;
            c++;
        }

        r = row;
        c = col;

        //sort the matrix
        for (int i = 0; i < 101; i++) {
            if (values[i] > 0) {
                while (values[i]-- > 0) {
                    mat[r++][c++] = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        System.out.println(Arrays.deepToString(diagonalSort(mat)));
    }
}
