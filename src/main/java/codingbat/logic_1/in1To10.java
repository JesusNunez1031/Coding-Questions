package codingbat.logic_1;

public class in1To10 {
    /*
    Given a number n, return true if n is in the range 1..10, inclusive. Unless outsideMode is true, in which case return true if the number is less or equal to 1, or greater or equal to 10.

    codingbat.logic_1.in1To10(5, false) → true
    codingbat.logic_1.in1To10(11, false) → false
    codingbat.logic_1.in1To10(11, true) → true
     */
    public boolean in1To10(int n, boolean outsideMode) {
        if (outsideMode) {
            return n <= 1 || n >= 10;
        }
        return n >= 1 && n <= 10;
    }
}
