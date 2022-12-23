package leetCode.dynamicProgramming;

public class onesAndZeros {
    /*
    You are given an array of binary strings strs and two integers m and n.
    Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
    A set x is a subset of a set y if all elements of x are also elements of y.

    Example 1:
    Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
    Output: 4
    Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
    Other valid but smaller leetCode.backtracking.subsets include {"0001", "1"} and {"10", "1", "0"}.
    {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.

    Example 2:
    Input: strs = ["10","0","1"], m = 1, n = 1
    Output: 2
    Explanation: The largest subset is {"0", "1"}, so the answer is 2.

    Constraints:
        1 <= strs.length <= 600
        1 <= strs[i].length <= 100
        strs[i] consists only of digits '0' and '1'.
        1 <= m, n <= 100
     */

    //TC: O(s * n * m) where s is the length of strs array, and O(n * m) space
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            //count of ones and zeros for string s
            int[] count = countDigits(s);

            //range of zeros can be from m to 0, or whatever count[0] is, the same applies to the range of ones
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    /*
                        dp[i][j] represents the max subset of 1's and 0's possible for the current string s, i.e. we
                        either consider the string s to be in the current substring set so we subtract the count of ones
                        and zeros from i and j and add 1, or we don't consider the string hence keep dp[i][j]
                    */
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    //Returns an array of length 2 where arr[0] and arr[1] are the count of ones and zeros in string s
    private int[] countDigits(String s) {
        int[] count = new int[2];

        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}
