package codingbat.warmup_1;

public class close10 {

    /*

Given 2 int values, return whichever value is nearest to the value 10, or return 0 in the event of a tie.
Note that Math.abs(n) returns the absolute value of a number.

    codingbat.warmup_1.close10(8, 13) → 8
    codingbat.warmup_1.close10(13, 8) → 8
    codingbat.warmup_1.close10(13, 7) → 0
     */
    public int close10(int a, int b) {
        int result1 = Math.abs(a - 10);
        int result2 = Math.abs(b - 10);

        if (result1 == result2) {
            return 0;
        }
        return Math.abs(Math.min(a, b));
    }
}
