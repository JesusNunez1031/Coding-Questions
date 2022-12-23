package codingbat.warmup_1;

public class loneTeen {

    /*
    We'll say that a number is "teen" if it is in the range 13..19 inclusive.
    Given 2 int values, return true if one or the other is teen, but not both.

    codingbat.warmup_1.loneTeen(13, 99) → true
    codingbat.warmup_1.loneTeen(21, 19) → true
    codingbat.warmup_1.loneTeen(13, 13) → false
     */

    public boolean loneTeen(int a, int b) {
        boolean aTeen = (a >= 13 && a <= 19);
        boolean bTeen = (b >= 13 && b <= 19);

        //using the XOR operator, returns true if one or the other is true but not both
        return (aTeen ^ bTeen);
    }
}
