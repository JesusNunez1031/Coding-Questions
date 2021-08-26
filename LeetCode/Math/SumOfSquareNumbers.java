public class SumOfSquareNumbers {
    /*
    Given a non-negative integer c, decide whether there are two integers a and b such that a^2 + b^2 = c.

    Example 1:
    Input: c = 5
    Output: true
    Explanation: 1 * 1 + 2 * 2 = 5

    Example 2:
    Input: c = 3
    Output: false

    Example 3:
    Input: c = 4
    Output: true

    Example 4:
    Input: c = 2
    Output: true

    Example 5:
    Input: c = 1
    Output: true

    Constraints:
        0 <= c <= 2^31 - 1
     */
    //TC: O(sqrt(c))
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            int sum = (left * left) + (right * right);

            if (sum == c) {
                return true;
            }

            if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
