public class blackjack {
    /*
    Given 2 int values greater than 0, return whichever value is nearest to 21 without going over. Return 0 if they both go over.

    blackjack(19, 21) → 21
    blackjack(21, 19) → 21
    blackjack(19, 22) → 19
     */
    public int blackjack(int a, int b) {
        return isClosest(a, b);
    }

    public int isClosest(int a, int b) {
        if (a > 21 && b > 21) {
            return 0;
        } else if (a < 21 && b > 21) {
            return a;
        } else if (b < 21 && a > 21) {
            return b;
        }
        if (a == 21 || b == 21) {
            return 21;
        } else if (Math.abs(a - 21) < Math.abs(b - 21)) {
            return a;
        }
        return b;
    }
}
