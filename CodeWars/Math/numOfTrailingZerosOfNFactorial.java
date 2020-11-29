import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class numOfTrailingZerosOfNFactorial {
    /*
    Write a program that will calculate the number of trailing zeros in a factorial of a given number.
    N! = 1 * 2 * 3 * ... * N
    Be careful 1000! has 2568 digits...

    Examples
    zeros(6) = 1
    # 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720 --> 1 trailing zero

    zeros(12) = 2
    # 12! = 479001600 --> 2 trailing zeros
     */

    /*given a list of factorials, every 5 factorials increase by one zero at the end
        Ex:
        1! = 1
        2! = 2
        3! = 6
        4! = 24
        5! = 120    -> 1 zero
        6! = 720
        7! = 5040
        8! = 40320
        9! = 362880
        10! = 3628800   -> 2 zeros
        11! = 39916800
        12! = 479001600
        13! = 6227020800
        14! = 87178291200
        15! = 1307674368000     -> 3 zeros
        16! = 20922789888000
        17! = 355687428096000
        18! = 6402373705728000
        19! = 121645100408832000
        20! = 2432902008176640000   -> 4 zeros

        so we just take the n input, without computing its factorial, we continuously add the amount of zeros that are in it repeatedly dividing n by 5 until we get to zero
            Example: given n = 20
                20 / 5 = 4 (at 20 factorial we have 4 zeros)
                4 / 5 = 0 (program ends)

                result is 4 zeros, 20! is 2432902008176640000 and has 4 trailing zeros
     */

    public static int zeros(int n) {
        int numOfZeroes = 0;
        while (n != 0) {
            numOfZeroes += (int) Math.floor(n / 5);
            n /= 5;
        }
        return numOfZeroes;
    }

    //Method calculates the factorial and then counts number of zeros at the end. This method is limited since it wont be able to take large inputs
    public static int zerosNon(int n) {
        BigInteger value = factorial(BigInteger.valueOf(n));

        String strFac = String.valueOf(value);
        int zeros = 0;

        for (int i = strFac.length() - 1; i >= 0; i--) {
            if (strFac.charAt(i) == '0') {
                zeros++;
            } else {
                break;
            }
        }
        return zeros;
    }

    public static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.valueOf(1);

        for (long factor = 2; factor <= n.longValue(); factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }
        return result;
    }

    @Test
    public void testZeros() throws Exception {
        assertThat(numOfTrailingZerosOfNFactorial.zeros(0), is(0));
        assertThat(numOfTrailingZerosOfNFactorial.zeros(6), is(1));
        assertThat(numOfTrailingZerosOfNFactorial.zeros(14), is(2));
    }

    public static void main(String[] args) {
        System.out.println("Total Number of Zeros: " + zeros(10));
    }
}
