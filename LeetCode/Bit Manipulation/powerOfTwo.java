public class powerOfTwo {
    /*
    Given an integer n, return true if it is a power of two. Otherwise, return false.

    An integer n is a power of two, if there exists an integer x such that n == 2^x.

    Example 1:
    Input: n = 1
    Output: true
    Explanation: 20 = 1

    Example 2:
    Input: n = 16
    Output: true
    Explanation: 24 = 16

    Example 3:
    Input: n = 3
    Output: false

    Example 4:
    Input: n = 4
    Output: true

    Example 5:
    Input: n = 5
    Output: false

    Constraints:
        -2^31 <= n <= 2^31 - 1

    Follow up: Could you solve it without loops/recursion?
     */
    //TC: O(log n)
    public boolean isPowerOfTwo(int n) {
        //any value 0 or less is not a powers of 2
        if (n <= 0) {
            return false;
        }
        long val = 1; //start with a default value of 1, long to avoid any issues

        /*
            starting from 1, we generate all values that are powers of 2 by shifting val's bits by 1 to the left at every
            iteration. If at any point val == n, then n is a powers of 2 value, otherwise, if after a shift, val > n,
            n is not a powers of 2 value
         */
        while (val <= n) {
            if (val == n) {
                return true;
            }
            val <<= 1;
        }
        return false;
    }

    public boolean isPowerOfTwoDiv(int n) {
        if (n <= 0) {
            return false;
        }

        //divide n by 2 by shifting bits to the right by 1, if at any point n is not divisible by 2, its not a power of 2
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }

            n >>= 1;
        }

        //the lowest power of 2 value is 1
        return n == 1;
    }

    //TC: O(1)
    public boolean isPowerOfTwoEz(int n) {
        if (n <= 0) {
            return false;
        }
        /*
            since any power of 2 value only has 1 set bit, we check if n & n - 1 gives us 0 to confirm its a power of 2,
            if a number is not a powers of 2, we will get a 1 since any number with more than 1 set bit will return 1.
            We do n - 1 so all bits before the set bit are 1, if n is not a powers of 2, it will have more than one set
            bit and when we & it with n - 1 then there will be one set bit not 0
                Ex: 16 = ....010000
                    15 = ....001111
                    16 & 15 == 0 thus 16 is a power of 2

                Ex 2: 3 = ....0011
                      2 = ....0010
                      3 & 2 == 1, thus 3 is not a power of 2

			n      n      n-1   n&(n-1)
			--    ----    ----  -------
			0     0000   0111    0000
			1     0001   0000    0000
			2     0010   0001    0000
			3     0011   0010    0010
			4     0100   0011    0000
	    */
        return (n & (n - 1)) == 0;
    }
}
