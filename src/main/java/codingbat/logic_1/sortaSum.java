package codingbat.logic_1;

public class sortaSum {
    /*
    Given 2 ints, a and b, return their sum. However, sums in the range 10..19 inclusive, are forbidden, so in that case just return 20.

    codingbat.logic_1.sortaSum(3, 4) → 7
    codingbat.logic_1.sortaSum(9, 4) → 20
    codingbat.logic_1.sortaSum(10, 11) → 21
     */
    public int sortaSum(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 19 ? 20 : sum;
    }
}
