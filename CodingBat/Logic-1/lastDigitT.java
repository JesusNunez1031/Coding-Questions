public class lastDigitT {
    /*
    Given three ints, a b c, return true if two or more of them have the same rightmost digit. The ints are non-negative. Note: the % "mod" operator computes the remainder, e.g. 17 % 10 is 7.

    lastDigit(23, 19, 13) → true
    lastDigit(23, 19, 12) → false
    lastDigit(23, 19, 3) → true
     */
    public boolean lastDigit(int a, int b, int c) {
        int remA = a % 10;
        int remB = b % 10;
        int remC = c % 10;

        return remA - remB == 0 || remA - remC == 0 || remB - remC == 0;
    }
}
