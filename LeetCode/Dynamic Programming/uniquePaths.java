public class uniquePaths {
    /*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
    corner of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?

    Example 1:
    Input: m = 3, n = 7
    Output: 28

    Example 2:
    Input: m = 3, n = 2
    Output: 3
    Explanation:
    From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    1. Right -> Down -> Down
    2. Down -> Down -> Right
    3. Down -> Right -> Down

    Example 3:
    Input: m = 7, n = 3
    Output: 28

    Example 4:
    Input: m = 3, n = 3
    Output: 6

    Constraints:
        1 <= m, n <= 100
        It's guaranteed that the answer will be less than or equal to 2 * 10^9.
     */
    /*
                     Pseudocode : dynamic programming
     1. we can only move right and down, so for the first row and column, or whenever i == 0 or j == 0, we set the value
        to 1
     2. for every index that is not in the fist row or column, we will have arrived from either the top or left since we
        are trying to get to the bottom right index, so the number of ways to get to it will be the sum of ways to get
        to the position at dp[i][j - 1] (left) and dp[i - 1][j] (top)
     3. continue iteration through the m * n board adding the values from dp[i][j - 1] (left) and dp[i - 1][j] (top) to
        dp[i][j]
     4.  The number of all possible unique paths to the bottom right will be at dp[m - 1][n - 1]
     */
    //TC: O(m * n) and O(n) space
    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        /*
            we can only move right and down, so the first column and row will be initialized as 1, once we are at any other
            position, the number of ways to get to that index, is by taking the number of ways to get to the path above
            and to the path to the left. For every position, we would have arrived from either the top or left since again,
            we can only move down and right
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        System.out.println(uniquePaths(m, n));
    }
}
