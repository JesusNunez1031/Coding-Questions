package codingbat.logic_2;

public class makeChocolate {
    /*
    We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) and big bars (5 kilos each).
    Return the number of small bars to use, assuming we always use big bars before small bars. Return -1 if it can't be done.

    codingbat.logic_2.makeChocolate(4, 1, 9) → 4
    codingbat.logic_2.makeChocolate(4, 1, 10) → -1
    codingbat.logic_2.makeChocolate(4, 1, 7) → 2
     */
    public int makeChocolate(int small, int big, int goal) {
        if (big * 5 + small < goal) {
            return -1;
        }

        if (big * 5 == goal) {
            return 0;
        }

        if (big * 5 < goal) {
            return Math.abs(big * 5 - goal);
        }
        while (big * 5 > goal) {
            big--;
        }
        return Math.abs(big * 5 - goal) <= small ? Math.abs(big * 5 - goal) : -1;
    }
}
