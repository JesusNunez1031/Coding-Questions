package codingbat.warmup_1;

public class sumDouble {
    /*
    Given two int values, return their sum. Unless the two values are the same, then return double their sum.

    codingbat.warmup_1.sumDouble(1, 2) → 3
    codingbat.warmup_1.sumDouble(3, 2) → 5
    codingbat.warmup_1.sumDouble(2, 2) → 8
     */

    public int sumDouble(int a, int b) {
        int sum = a + b;
        if (a == b) {
            return sum * 2;
        }
        return sum;
    }

}
