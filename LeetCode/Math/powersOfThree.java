public class powersOfThree {
    /*
    Given an integer n, return true if it is a power of three. Otherwise, return false.

    An integer n is a power of three, if there exists an integer x such that n == 3^x.

    Example 1:
    Input: n = 27
    Output: true

    Example 2:
    Input: n = 0
    Output: false

    Example 3:
    Input: n = 9
    Output: true

    Example 4:
    Input: n = 45
    Output: false

    Constraints:
        -2^31 <= n <= 2^31 - 1


    Follow up: Could you solve it without loops/recursion?
     */
    //TC: O(log3(n)) base 3 since we are looking for powers of 3 so we divide n by 3 at every step
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    //Follow up:
     public boolean isPowerOfThreeEz(int n) {
         /*
            Knowing the limitation of n, we can now deduce that the maximum value of n that is also a power of three is
            1162261467, 3 ^ ⌊ log3 (INTEGER.MAX_VALUE) ⌋ = 3 ⌊19.56⌋ = 3 ^ 19 = 1162261467
          */
         return n > 0 && 1162261467 % n == 0;
     }
}
