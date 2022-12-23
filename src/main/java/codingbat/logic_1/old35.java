package codingbat.logic_1;

public class old35 {
    /*
    Return true if the given non-negative number is a multiple of 3 or 5, but not both. Use the % "mod" operator

    codingbat.logic_1.old35(3) → true
    codingbat.logic_1.old35(10) → true
    codingbat.logic_1.old35(15) → false
     */
    public boolean old35(int n) {
        return n % 3 == 0 ^ n % 5 == 0;
    }
}
