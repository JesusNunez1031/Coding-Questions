import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class luckyNumbersInMatrix {
    /*
    Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
    A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

    Example 1:
    Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
    Output: [15]
    Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column

    Example 2:
    Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
    Output: [12]
    Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

    Example 3:
    Input: matrix = [[7,8],[1,2]]
    Output: [7]

    Constraints:
        m == mat.length
        n == mat[i].length
        1 <= n, m <= 50
        1 <= matrix[i][j] <= 10^5.
        All elements in the matrix are distinct.
     */
    //TC: O(n * m)
    private List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> lucky = new ArrayList<>();

        //arrays to save the smallest and largest values in the matrix row and columns
        int[] min_row = new int[matrix.length];
        int[] max_col = new int[matrix[0].length];

        //fill the min array with large values and max with small values to ensure we get right values
        Arrays.fill(min_row, Integer.MAX_VALUE);
        Arrays.fill(max_col, Integer.MIN_VALUE);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                //save the smallest value in the row to the row array
                if (matrix[i][j] < min_row[i]) {
                    min_row[i] = matrix[i][j];
                }
                //save the largest value in the column to the column array
                if (matrix[i][j] > max_col[j]) {
                    max_col[j] = matrix[i][j];
                }
            }
        }

        //if the current value in matrix[i][j] is in both the max and min, the number is lucky
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == min_row[i] && matrix[i][j] == max_col[j]) {
                    lucky.add(matrix[i][j]);
                }
            }
        }
        return lucky;
    }
}
