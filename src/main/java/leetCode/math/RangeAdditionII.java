package leetCode.math;

public class RangeAdditionII {
    /*
    You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi]
    means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.

    Count and return the number of maximum integers in the matrix after performing all the operations.

    Example 1:
    [0][0][0]     [1][1][0]     [2][2][1]
    [0][0][0] ==> [1][1][0] ==> [2][2][1]
    [0][0][0]     [0][0][0]     [1][1][1]
    Input: m = 3, n = 3, ops = [[2,2],[3,3]]
    Output: 4
    Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.

    Example 2:
    Input: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
    Output: 4

    Example 3:
    Input: m = 3, n = 3, ops = []
    Output: 9

    Constraints:
        1 <= m, n <= 4 * 10^4
        0 <= ops.length <= 10^4
        ops[i].length == 2
        1 <= ai <= m
        1 <= bi <= n
     */
    //TC: O(n) where n is the length of the operations matrix
    public int maxCount(int m, int n, int[][] ops) {
        int xMin = m;
        int yMin = n;

        /*
            the result matrix will always be in the top left of the original matrix as these values will be the first
            updated when updates are done. The cells that will be increased by 1 will be in following range,
            x <= minimum of prev x coordinates and y <= minimum of prev y coordinates.

            The max is simply the product of the minimum values in the x and y part of the operation matrix, so we do not
            need to simulate adding to the m x n matrix.
         */
        for (int[] op : ops) {
            xMin = Math.min(xMin, op[0]);
            yMin = Math.min(yMin, op[1]);
        }
        return xMin * yMin;
    }
}
