package leetCode.twoDimentionArrays;

import java.util.LinkedList;
import java.util.Queue;

public class reshapeTheMatrix {
    /*
    In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different
    size but keep its original data.

    You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row
    number and column number of the wanted reshaped matrix, respectively.

    The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

    If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise,
    output the original matrix.

    Example 1:
    Input:
    nums =
    [[1,2],
     [3,4]]
    r = 1, c = 4
    Output:
    [[1,2,3,4]]
    Explanation:
    The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the
    previous list.

    Example 2:
    Input:
    nums =
    [[1,2],
     [3,4]]
    r = 2, c = 4
    Output:
    [[1,2],
     [3,4]]
    Explanation:
    There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.

    Note:
        The height and width of the given matrix is in range [1, 100].
        The given r and c are all positive.
     */
    //TC: O(n * m) & O(n * m) space where n are the columns and m are the rows in the matrix
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;

        //if the reshaped matrix is larger than the current matrix, the new matrix cant be made
        if (m * n < r * c) {
            return nums;
        }

        int[][] reshape = new int[r][c];

        Queue<Integer> queue = new LinkedList<>();

        //add all the values from the original matrix to the queue so values can be inserted into the new matrix in order
        for (int[] num : nums) {
            for (int j = 0; j < n; j++) {
                queue.add(num[j]);
            }
        }

        //form the new matrix
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshape[i][j] = queue.remove();
            }
        }
        return reshape;
    }

    public int[][] matrixReshapeArr(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;

        if (m * n < r * c) {
            return nums;
        }

        int[][] reshape = new int[r][c];

        //array to hold all values in the original matrix in linear order
        int[] vals = new int[m * n];
        int p = 0;

        //add all the values from the original matrix to the array so values can be inserted into the new matrix in order
        for (int[] num : nums) {
            for (int j = 0; j < n; j++) {
                vals[p++] = num[j];
            }
        }
        p = 0;
        //form the new matrix
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshape[i][j] = vals[p++];
            }
        }
        return reshape;
    }

    //TC: O(m * n)
    public int[][] matrixReshapeEz(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        //verify the reshaped matrix is of equal size to the current matrix
        if (m * n != r * c) {
            return mat;
        }

        int[][] reshape = new int[r][c];
        int cell = 0; // number of cells in the matrix
        /*
            a 2-D array is stored as a 1-D in main memory, i.e. mat[i][j] is represented in the form of a one dimensional
            array by using the index in the form: mat[n * i + j], where n is the number of columns in the given matrix.
            This is the one way of converting 2-d indices into one 1-d index.

            Therefore while putting values into the reshaped matrix we can make use of a cell variable which increases for
            every value traversed and gets added as if placed into a 1-D array. To convert the cell back into 2-D matrix
            indices with a column cell of c, indices are obtained as reshape[cell / c][cell % c] where cell / c is
            the row number and cell % c is the column number

            for each num array in matrix mat, loop through the values in the row and add them to the reshape matrix by
            extracting the indices based on the number of cells already seen
        */
        for (int[] num : mat) {
            for (int j = 0; j < n; j++) {
                reshape[cell / c][cell % c] = num[j];
                cell++;
            }
        }
        return reshape;
    }
}
