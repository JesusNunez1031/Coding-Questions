public class superPalindromes {
    /*
    Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.

    Given two positive integers left and right represented as strings, return the number of super-palindromes integers
    in the inclusive range [left, right].

    Example 1:
    Input: left = "4", right = "1000"
    Output: 4
    Explanation: 4, 9, 121, and 484 are superpalindromes.
    Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.

    Example 2:
    Input: left = "1", right = "2"
    Output: 1

    Constraints:
        1 <= left.length, right.length <= 18
        left and right consist of only digits.
        left and right cannot have leading zeros.
        left and right represent integers in the range [1, 10^18].
        left is less than or equal to right.
     */
    //TC: O(n ^ 1/4 * log n) where n = 10^18, log n is checking if n^2 is a palindrome
    public int superpalindromesInRange(String left, String right) {
        //turn the strings into values we can work with
        long l = Long.valueOf(left);
        long r = Long.valueOf(right);
        int super_palindromes = 0;

        /*
            find all even length palindromes
            Ex: all single digit values are palindromes so we just need to check if their squares are palindromes for
            the number to be considered a super palindrome

            for every value after 9, i.e. 10+, we take this value and append its reverse to it so,
                10 ==> 1001  |  20 ==> 2002  | 100 ==> 100001
                11 ==> 1111  |  50 ==> 5005  | 521 ==> 521125
                12 ==> 1221  |  90 ==> 9009  | 999 ==> 999999

           the largest value right can be is 10^9 before taking the square so since we find odd and even palindromes we
           only check up to 10^5 i.e. half of the values.
           then when we take the square of a value, we can reach values up to 10^18 which is the largest value range
         */
        for (int i = 1; i < (int) 1e5; i++) {
            //convert i to a string
            StringBuilder sb = new StringBuilder(Integer.toString(i));

            //append the reverse of i to the string value of i since we want even palindromes
            for (int j = sb.length() - 1; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }

            //convert string back to long
            long n = Long.valueOf(sb.toString());

            /*
                A value is a super palindrome if its normal and square values are palindromes, so we take the square of n
                so we can check if its a palindrome
             */
            n *= n;

            //break out of the loop when n exceeds the "right"
            if (n > r) {
                break;
                //if the square of n is also a palindrome, we can increase the count of super palindromes
            } else if (n >= l && isPalindrome(n)) {
                super_palindromes++;
            }
        }

        /*
            find all odd length palindromes
            Ex: all single digit values are palindromes so we just need to check if their squares are palindromes for
            the number to be considered a super palindrome

            for every value after 9, i.e. 10+, we take this value and append its reverse to it so,
                10 ==> 101  |  20 ==> 202  | 156 ==> 15651
                11 ==> 111  |  50 ==> 505  | 521 ==> 52125
                12 ==> 121  |  90 ==> 909  | 999 ==> 99999

           the largest value right can be is 10^9 so since we find odd and even palindromes we only check up to 10^5,
           i.e. half of the values.
         */
        for (int i = 1; i < (int) 1e5; i++) {
            //convert i to a string
            StringBuilder sb = new StringBuilder(Integer.toString(i));

            //since we want odd length palindromes, we only append starting from the second to last value of every ith value
            for (int j = sb.length() - 2; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }

            //convert string back to long
            long n = Long.valueOf(sb.toString());

            /*
                A value is a super palindrome if its normal and square values are palindromes, so we take the square of n
                so we can check if its a palindrome
             */
            n *= n;

            //break out of the loop when n exceeds the "right"
            if (n > r) {
                break;
                //if the square of n is also a palindrome, we can increase the count of super palindromes
            } else if (n >= l && isPalindrome(n)) {
                super_palindromes++;
            }
        }
        return super_palindromes;
    }

    //check if n is a palindrome
    private boolean isPalindrome(long n) {
        return n == reverse(n);
    }

    //takes in a long n and returns n reversed
    private long reverse(long n) {
        long reversed = 0;

        while (n > 0) {
            reversed = 10 * reversed + (n % 10);
            n /= 10;
        }
        return reversed;
    }
}
