package codingbat.warmup_1;

public class nearHundred {

    /*
    Given an int n, return true if it is within 10 of 100 or 200. Note: Math.abs(num) computes the absolute value of a number.

    codingbat.warmup_1.nearHundred(93) → true
    codingbat.warmup_1.nearHundred(90) → true
    codingbat.warmup_1.nearHundred(89) → false
         */

    public boolean nearHundred(int n) {
        return ((Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10));
    }

}
