package ctci.arrays;

import java.util.Arrays;

public class RotateMatrix {

    /*
    Given an image represented by an NxN matrix, where each pixel in the image is 4
    bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
                                        On the first pass:      On the second pass:   On the third pass:  On the Fourth pass:
    Ex: given 4x4 matrix : 1 2 3 4      | 13 2 3 1              | 13 9 3 1            | 13 9 5 1          | 13 9 5 1
                           5 6 7 8      | 5 6 7 8               | 5 6 7 2             | 14 6 7 2          | 14 10 6 2    ==> finally the matrix is rotated
                           9 10 11 12   | 9 10 11 12            | 15 10 11 12         | 15 10 11 3        | 15 11 7 3        a spiral is made inwards if you
                           13 14 15 16  | 16 14 15 4            | 16 14 8 4           | 16 12 8 4         | 16 12 8 4        keep track of how the values change
                                                                                                                             after every iteration

     So what the algorithm is doing is, its swapping values as we go layer by layer, at our first iteration, we swap all values in corners starting from the top left and moving counter clockwise,
     then we go one layer down and move an offset index one to the right from the first layer. By the time we get to the first layer's last index, the array will have been rotated
     */

    //The best algorithm that touches all N^2 elements is O(n^2)
    public static boolean rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; //Save top

                //left -> top
                matrix[first][i] = matrix[last - offset][first];

                //bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                //right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                //top -> right
                matrix[i][last] = top; //right <- saved top
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int N = 4;
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8,},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println("Original matrix: \n");
        System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n"));

        rotateMatrix(matrix);

        System.out.println("\nRotated 90 degrees array:");
        System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n"));
    }
}
