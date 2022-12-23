package codingbat.recursion_1;

public class powerN {
    /*
    Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so
    codingbat.recursion_1.powerN(3, 2) is 9 (3 squared).

    codingbat.recursion_1.powerN(3, 1) → 3
    codingbat.recursion_1.powerN(3, 2) → 9
    codingbat.recursion_1.powerN(3, 3) → 27
     */
    public int powerN(int base, int n) {
        if (n == 0) {
            return 1;
        }
        return base * powerN(base, n - 1);
    }
}
