package codingbat.logic_1;

public class maxMod5 {
    /*
    Given two int values, return whichever value is larger. However if the two values have the same remainder when divided by 5, then the return the smaller value. However, in all cases, if the two values are the same, return 0. Note: the % "mod" operator computes the remainder, e.g. 7 % 5 is 2.

    codingbat.logic_1.maxMod5(2, 3) → 3
    codingbat.logic_1.maxMod5(6, 2) → 6
    codingbat.logic_1.maxMod5(3, 2) → 3
     */
    public int maxMod5(int a, int b) {
        int remA = a % 5;
        int remB = b % 5;
        if (a == b) {
            return 0;
        }
        return remA == remB ? Math.min(a, b) : Math.max(a, b);
    }
}
