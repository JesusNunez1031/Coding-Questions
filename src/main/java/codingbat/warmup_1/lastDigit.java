package codingbat.warmup_1;

public class lastDigit {

    /*
    Given two non-negative int values, return true if they have the same last digit, such as with 27 and 57. Note that the % "mod" operator computes remainders, so 17 % 10 is 7.

    codingbat.warmup_1.lastDigit(7, 17) → true
    codingbat.warmup_1.lastDigit(6, 17) → false
    codingbat.warmup_1.lastDigit(3, 113) → true
     */
    public boolean lastDigit(int a, int b) {
        int rem1 = a % 10;
        int rem2 = b % 10;

        return rem1 == rem2;
    }
}
