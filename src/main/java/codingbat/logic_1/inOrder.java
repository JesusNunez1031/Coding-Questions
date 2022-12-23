package codingbat.logic_1;

public class inOrder {
    /*
    Given three ints, a b c, return true if b is greater than a, and c is greater than b. However, with the exception that if "bOk" is true, b does not need to be greater than a.

    codingbat.logic_1.inOrder(1, 2, 4, false) → true
    codingbat.logic_1.inOrder(1, 2, 1, false) → false
    codingbat.logic_1.inOrder(1, 1, 2, true) → true
     */
    public boolean inOrder(int a, int b, int c, boolean bOk) {
        boolean Ba = b > a;
        boolean Cb = c > b;
        if (bOk) {
            return (!Ba || Ba) && Cb;
        }
        return Ba && Cb;
    }
}
