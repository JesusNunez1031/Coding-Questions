import java.util.HashMap;
import java.util.Map;

public class numberOfSubmatricesThatSumToTarget {
    /*
    Given a matrix and a target, return the number of non-empty submatrices that sum to target.
    A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
    Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.

    Example 1:
    Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
    Output: 4
    Explanation: The four 1x1 submatrices that only contain 0.

    Example 2:
    Input: matrix = [[1,-1],[-1,1]], target = 0
    Output: 5
    Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.

    Example 3:
    Input: matrix = [[904]], target = 0
    Output: 0

    Constraints:
        1 <= matrix.length <= 100
        1 <= matrix[0].length <= 100
        -1000 <= matrix[i] <= 1000
        -10^8 <= target <= 10^8
     */

    //TC:O(m * n^2) and O(n) space
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //get the prefix sums of all rows in the matrix
        for (int[] row : matrix) {
            for (int j = 1; j < matrix[0].length; j++) {
                row[j] += row[j - 1];
            }
        }

        int count = 0; //number of sub-matrices that sum to target

        /*
            search diagonally through the matrix starting from [0][0], for each column, we search through all the rows and
            keep a running sum of the current r2 columns values, if r1 > 0, the sum is row[r2] - row[r1 - 1] so sum is
            a sum of all running values in the current search, otherwise, sum is just the value in row[r2], if the running
            sum - target has been seen before in the current search, this means there are [count of sum] sub-matrices that
            sum to target
         */
        for (int r1 = 0; r1 < matrix[0].length; r1++) {
            for (int r2 = r1; r2 < matrix[0].length; r2++) {

                Map<Integer, Integer> map = new HashMap<>();
                //by default, 0 can be made by using no values hence we add it to the map
                map.put(0, 1);
                int sum = 0; //running sum for the sub-matrix observed

                for (int[] row : matrix) {
                    sum += row[r2] - (r1 > 0 ? row[r1 - 1] : 0);
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}
