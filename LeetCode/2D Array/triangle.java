import java.util.List;

public class triangle {
    /*
    Given a triangle array, return the minimum path sum from top to bottom.

    For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the
    current row, you may move to either index i or index i + 1 on the next row.

    Example 1:
    Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    Output: 11
    Explanation: The triangle looks like:
                           2
                          3 4
                         6 5 7
                        4 1 8 3
    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

    Example 2:
    Input: triangle = [[-10]]
    Output: -10

    Constraints:
        1 <= triangle.length <= 200
        triangle[0].length == 1
        triangle[i].length == triangle[i - 1].length + 1
        -10^4 <= triangle[i][j] <= 10^4

    Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
     */
    //TC:O(n^2) and constant space since we update the triangle array
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        /*
            bottom up approach, we start form the 2nd to last row and update all paths in the triangle to the
            current sum of each path, at the end the smallest sum will be at the tip of the triangle, or first
            row
        */
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int j = 0; j < triangle.get(row).size(); j++) {
                /*
                    for each ith index in the current row get the smallest index between the adjacent indexes of the
                    next row and then sum this value to the current jth index, finally, update the current path sum so
                    when the next row up is checked, we have the smallest sums from the paths available
                 */
                int min = Math.min(triangle.get(row + 1).get(j), triangle.get(row + 1).get(j + 1));
                int sum = min + triangle.get(row).get(j);
                triangle.get(row).set(j, sum);
            }
        }
        return triangle.get(0).get(0);
    }

    //TC: O(n^2) using O(n) space due to dp array
    public int minimumTotalDP(List<List<Integer>> triangle) {
        int length = triangle.size();

        //dp array used to build the smallest sum of each path in the triangle
        int[][] dp = new int[length][length];

        //start from the first row and its first index
        return searchPath(triangle, 0, 0, dp);
    }

    private static int searchPath(List<List<Integer>> triangle, int row, int i, int[][] dp) {
        //if the current row is the last row, no more need to search
        if (row == triangle.size()) {
            return 0;
        }

        /*
            if the current index in "row" has a value, that means we are on a valid path hence we return the value to be
            used to compare in getting the smallest sum
         */
        if (dp[row][i] != 0) {
            return dp[row][i];
        }

        /*
            the current value at row and index i is the sum of the current value in the triangle array + the smallest of
            the two indexes below it also in the triangle array.
         */
        dp[row][i] = Math.min(triangle.get(row).get(i) + searchPath(triangle, row + 1, i, dp),
                triangle.get(row).get(i) + searchPath(triangle, row + 1, i + 1, dp));

        //the smallest path sum will be at the first index of the triangle in the dp array
        return dp[row][i];
    }
}
