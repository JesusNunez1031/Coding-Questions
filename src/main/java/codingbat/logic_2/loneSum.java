package codingbat.logic_2;

public class loneSum {
    /*
    Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values,
    it does not count towards the sum.

    codingbat.logic_2.loneSum(1, 2, 3) → 6
    codingbat.logic_2.loneSum(3, 2, 3) → 2
    codingbat.logic_2.loneSum(3, 3, 3) → 0
     */
    public int loneSum(int a, int b, int c) {
        if (a == b && b == c) {
            return 0;
        }
        if (a == b) {
            return c;
        } else if (a == c) {
            return b;
        } else if (b == c) {
            return a;
        }
        return a + b + c;
    }
}
