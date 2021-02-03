public class reverseInteger {
    /*
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the
    signed 32-bit integer range [-231, 231 - 1], then return 0.

    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

    Example 1:
    Input: x = 123
    Output: 321

    Example 2:
    Input: x = -123
    Output: -321

    Example 3:
    Input: x = 120
    Output: 21

    Example 4:
    Input: x = 0
    Output: 0

    Constraints:
    -2^31 <= x <= 2^31 - 1
     */
    //TC: O(n)
    public static int reverse(int x) {
        long result = 0;    //the resulting reversed x can be out of the range of an int so use a long
        while (x != 0) {
            /*
                take the last digit from the number x by taking % 10, and multiply the current value of "result" to
                simulate moving to a new 10's place and add the last digit to it
             */
            result = result * 10 + (x % 10);
            x /= 10;

            //if at any point the result exceeds the max range of an int, [-2^31, 2^31 - 1], return 0
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
