package codingbat.warmup_1;

public class posNeg {

    /*

    Given 2 int values, return true if one is negative and one is positive. Except if the parameter "negative" is true, then return true only if both are negative.

    codingbat.warmup_1.posNeg(1, -1, false) → true
    codingbat.warmup_1.posNeg(-1, 1, false) → true
    codingbat.warmup_1.posNeg(-4, -5, true) → true
     */

    public boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            return (a < 0) && (b < 0);
        }
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            return true;
        }
        return false;
    }

}
