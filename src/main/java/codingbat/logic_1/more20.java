package codingbat.logic_1;

public class more20 {
    /*
    Return true if the given non-negative number is 1 or 2 more than a multiple of 20.

    codingbat.logic_1.more20(20) → false
    codingbat.logic_1.more20(21) → true
    codingbat.logic_1.more20(22) → true
     */
    public boolean more20(int n) {
        return n % 20 == 1 || n % 20 == 2;
    }
}
