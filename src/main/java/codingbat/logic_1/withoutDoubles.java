package codingbat.logic_1;

public class withoutDoubles {
    /*
    Return the sum of two 6-sided dice rolls, each in the range 1..6. However, if noDoubles is true, if the two dice show the same value, increment one die to the next value, wrapping around to 1 if its value was 6.

    codingbat.logic_1.withoutDoubles(2, 3, true) → 5
    codingbat.logic_1.withoutDoubles(3, 3, true) → 7
    codingbat.logic_1.withoutDoubles(3, 3, false) → 6
     */
    public int withoutDoubles(int die1, int die2, boolean noDoubles) {
        int sum = die1 + die2;
        if (noDoubles) {
            if (die1 == 6 && die2 == 6) {
                return die1 + 1;
            }
            if (die1 == die2) {
                return sum + 1;
            }
        }
        return sum;
    }
}
