package codingbat.warmup_1;

public class intMax {
    /*
    Given three int values, a b c, return the largest.

    codingbat.warmup_1.intMax(1, 2, 3) → 3
    codingbat.warmup_1.intMax(1, 3, 2) → 3
    codingbat.warmup_1.intMax(3, 2, 1) → 3
     */

    public int intMax(int a, int b, int c) {
        int max1 = Math.max(a, b);
        return Math.max(max1, c);
    }
}
