package leetCode.math;

public class factorialTrailingZeros {
    /*
    Given an integer n, return the number of trailing zeroes in n!.
    Follow up: Could you write a solution that works in logarithmic time complexity?

    Example 1:
    Input: n = 3
    Output: 0
    Explanation: 3! = 6, no trailing zero.

    Example 2:
    Input: n = 5
    Output: 1
    Explanation: 5! = 120, one trailing zero.

    Example 3:
    Input: n = 0
    Output: 0

    Constraints:
        1 <= n <= 10^4
     */
    //TC: O(log n)
    public int trailingZeroes(int n) {
        /*
            Every 5 factorials the number of trailing zeros increases by 1 so all we do is check if the number is greater
            than 5, if its not, it will have no trailing zeros, if it is, we get the number of trailing zeros of n by
            dividing n by 5 and then reduce it to n / 5, that way we check every 5 factorials until n is less than 5
         */
        if (n < 5) {
            return 0;
        }
        int zeros = 0;
        while (n >= 5) {
            zeros += n / 5;
            n /= 5;
        }
        return zeros;
    }
}
