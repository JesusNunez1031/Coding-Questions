package codingbat.logic_1;

public class greenTicket {
    /*
    You have a green lottery ticket, with ints a, b, and c on it. If the numbers are all different from each other, the result is 0. If all of the numbers are the same, the result is 20. If two of the numbers are the same, the result is 10.

    codingbat.logic_1.greenTicket(1, 2, 3) → 0
    codingbat.logic_1.greenTicket(2, 2, 2) → 20
    codingbat.logic_1.greenTicket(1, 1, 2) → 10
     */
    public int greenTicket(int a, int b, int c) {
        if (a == b && b == c) {
            return 20;
        }
        return a == b || a == c || b == c ? 10 : 0;
    }
}
