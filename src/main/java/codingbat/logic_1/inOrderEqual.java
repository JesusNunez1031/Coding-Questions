package codingbat.logic_1;

public class inOrderEqual {
    /*
    Given three ints, a b c, return true if they are in strict increasing order, such as 2 5 11, or 5 6 7, but not 6 5 7 or 5 5 7. However, with the exception that if "equalOk" is true, equality is allowed, such as 5 5 7 or 5 5 5.

    codingbat.logic_1.inOrderEqual(2, 5, 11, false) → true
    codingbat.logic_1.inOrderEqual(5, 7, 6, false) → false
    codingbat.logic_1.inOrderEqual(5, 5, 7, true) → true
     */
    public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
        boolean inOrder = a < b && a < c && b < c;
        if (equalOk) {
            if (b > c || a > b) {
                return false;
            }
            return !inOrder;
        }
        return inOrder;
    }
}
