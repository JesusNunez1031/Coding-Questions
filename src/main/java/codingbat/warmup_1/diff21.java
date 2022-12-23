package codingbat.warmup_1;

public class diff21 {
    /*

Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n is over 21.

    codingbat.warmup_1.diff21(19) → 2
    codingbat.warmup_1.diff21(10) → 11
    codingbat.warmup_1.diff21(21) → 0
     */
    public int diff21(int n) {
        int diff = 21 - n;
        if (n > 21) {
            return 2 * (n - 21);
        }
        return diff;
    }


}
