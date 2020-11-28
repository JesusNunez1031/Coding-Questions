import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class setMatrixZeros {
    /*
    Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

    Follow up:
        A straight forward solution using O(mn) space is probably a bad idea.
        A simple improvement uses O(m + n) space, but still not the best solution.
        Could you devise a constant space solution?


    Example 1:
     ___________         ___________
    |_1_|_1_|_1_|       |_1_|_0_|_1_|
    |_1_|_0_|_1_|   ==> |_0_|_0_|_0_|
    |_1_|_1_|_1_|       |_1_|_0_|_0_|

    Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
    Output: [[1,0,1],[0,0,0],[1,0,1]]

    Example 2:
     _______________         _______________
    |_0_|_1_|_2_|_0_|       |_0_|_0_|_0_|_0_|
    |_3_|_4_|_5_|_2_|   ==> |_0_|_4_|_5_|_0_|
    |_1_|_3_|_1_|_5_|       |_0_|_3_|_1_|_0_|

    Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


    Constraints:
        m == matrix.length
        n == matrix[0].length
        1 <= m, n <= 200
        -2^31 <= matrix[i][j] <= 2^31 - 1
     */
    /*
        Method using two sets to store the rows ans columns that need to be converted to 0
        TC: O(m * n) and O(n) space
     */
    private static void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                //if the current value is 0, the row i and column must be changed to 0
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //Method implemented using constant space TC: O(n * m)
    private static void setZeroesNoSpace(int[][] matrix) {
        boolean firstCol = false;

        for (int i = 0; i < matrix.length; i++) {
            //if the first index in the first row is a zero, we mark firstCol as true so later we can convert row and column to 0
            if (matrix[i][0] == 0) {
                firstCol = true;
            }
            for (int j = 1; j < matrix[i].length; j++) {
                //if the current value is 0, we set the first value in the specific row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;

                }
            }
        }

        /*
            for every value after the first row and the first index of the row, we check if there is a 0 in the row, we skip
            the first row since "firstCol" will let us know if the there was a zero at the start of the first row, if there was,
            we will later turn the entire row and column to 0. At any given index, we check if the start of the row has a zero, or the
            top of the column is a 0, if either of these is true, we convert the current index to 0
        */
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //check if the first row needs to be set to 0
        if (matrix[0][0] == 0) {
            //override the current row to make all values 0
            matrix[0] = new int[matrix[0].length];
        }

        //check if the first column needs to be set to 0
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroesNoSpace(matrix);
        System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n"));
    }
}
