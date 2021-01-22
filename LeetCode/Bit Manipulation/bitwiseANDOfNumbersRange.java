public class bitwiseANDOfNumbersRange {
    /*
    Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

    Example 1:
    Input: [5,7]
    Output: 4

    Example 2:
    Input: [0,1]
    Output: 0
     */
    //TC: O(log(n)) using Brian Kernighan’s Algorithm to count set bits in an integer. An integer n has log(n) bits
    private int rangeBitwiseAnd(int m, int n) {
        /*
            Bitwise-AND of any two numbers will always produce a number less than or equal to the smaller number.
            Example:
									7  ---- 0111
									6  ---- 0110
									5  ---- 0101
                                    4  ---- 0100
                                    3  ---- 0011
                                    2  ---- 0010
                                    1  ---- 0001
            range: [4, 7]
            m = 4, n = 7
                1. n = 7 & 6 = 6
                2. n = 6 & 5 = 4
                    loop breaks since n == m
                return n since n == m and n & m will = m

        */
        while (n > m) {
            n = n & n - 1;
        }
        return n;
    }
}
