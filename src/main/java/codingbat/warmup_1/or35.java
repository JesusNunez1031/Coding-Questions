package codingbat.warmup_1;

public class or35 {

    /*
    Return true if the given non-negative number is a multiple of 3 or a multiple of 5.
    Use the % "mod" operator -- see Introduction to Mod

    codingbat.warmup_1.or35(3) → true
    codingbat.warmup_1.or35(10) → true
    codingbat.warmup_1.or35(8) → false
     */
    public boolean or35(int n) {
        return n % 5 == 0 || n % 3 == 0;
    }
}
