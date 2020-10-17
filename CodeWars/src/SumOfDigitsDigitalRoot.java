import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class SumOfDigitsDigitalRoot {
    /*
    Digital root is the recursive sum of all the digits in a number.
    Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in this way until a single-digit number is produced.
    The input will be a non-negative integer.

        Examples
            16  -->  1 + 6 = 7
           942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
        132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
     */

    public static long digital_root(long n) {
        // ...
        long sum = 0;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        n = sum;
        return String.valueOf(n).length() > 1 ? digital_root(n) : n;
    }


    @Test
    public void Test1() {
        assertEquals("Nope!", 7, SumOfDigitsDigitalRoot.digital_root(16));
    }

    @Test
    public void Test2() {
        assertEquals("Nope!", 1, SumOfDigitsDigitalRoot.digital_root(325864));
    }


    public static void main(String[] args) {
    }
}
