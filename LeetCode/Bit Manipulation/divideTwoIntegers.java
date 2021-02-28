public class divideTwoIntegers {
    /*
    Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
    Return the quotient after dividing dividend by divisor.
    The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

    Note:
        Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range:
        [−231,  231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.

    Example 1:
    Input: dividend = 10, divisor = 3
    Output: 3
    Explanation: 10/3 = truncate(3.33333..) = 3.

    Example 2:
    Input: dividend = 7, divisor = -3
    Output: -2
    Explanation: 7/-3 = truncate(-2.33333..) = -2.

    Example 3:
    Input: dividend = 0, divisor = 1
    Output: 0

    Example 4:
    Input: dividend = 1, divisor = 1
    Output: 1

    Constraints:
        -2^31 <= dividend, divisor <= 2^31 - 1
        divisor != 0
     */
    //TC: O(log n^2) and constant space
    public static int divide(int dividend, int divisor) {
        //if the dividend is -2^31 and we are dividing by -1, return 2^31
        if (dividend == 1 << 31 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        /*
            check for the sign of the result, true -> positive | false -> negative
            4 possible signs:
                + + => +
                - - => +
                + - => -
                - + => -
         */
        boolean sign = (dividend >= 0) == (divisor >= 0);

        //take the absolute values of both values to avoid sign issues
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;

        /*
            loop while we can subtract divisor from dividend, if this holds true, then double the divisor and increment
            the count, which is the number if times the divisor was doubled
            Example:
                dividend = 10 | divisor = 3
                [double 3 while its value is <= 10]
                1. 6 >= 10
                2. 12 >= 10 [break, times doubled = 1]
                result += 2
                dividend = 4

                [double 3 while its value <= 4]
                1. 6 >= 4 [break, times doubled = 0]
                result += 1
                dividend = 1 [break, 1 - 3 < 0]

                ***we perform multiplication through bit manipulation by shifting bits left***
         */
        while (dividend - divisor >= 0) {
            int count = 0;
            //as long as the doubled divisor count times subtracted from the dividend still yields a value >= 0, increase the doubled count
            while (dividend - (divisor << 1 << count) >= 0) {
                count++;
            }
            //add the count to the result and subtract the total times the divisor was doubled from the dividend
            result += 1 << count;
            dividend -= divisor << count;
        }

        //if the sign is true, result is positive, negative otherwise
        return sign ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
    }
}
