public class ArrangingCoins {
    /*
    You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith
    row has exactly i coins. The last row of the staircase may be incomplete.

    Given the integer n, return the number of complete rows of the staircase you will build.

    Example 1:
    [$]
    [$][$]
    [$][$][-]
    Input: n = 5
    Output: 2
    Explanation: Because the 3rd row is incomplete, we return 2.

    Example 2:
    [$]
    [$][$]
    [$][$][$]
    [$][$][-][-]
    Input: n = 8
    Output: 3
    Explanation: Because the 4th row is incomplete, we return 3.

    Constraints:
        1 <= n <= 2^31 - 1
     */
    //TC: O(log n)
    public int arrangeCoins(int n) {
        long left = 1;
        long right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            // calculate the sum of all values up to mid
            long sum = mid * (mid + 1) / 2;

            // if the sum is n, then we have found the number of rows that make up n coins
            if (sum == n) {
                return (int) mid;
            } else {
                // increase the lowest complete row if the sum < n, or reduce the largest row by one otherwise
                if (sum < n) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        // the right pointer will be at the last complete row
        return (int) right;
    }
}
