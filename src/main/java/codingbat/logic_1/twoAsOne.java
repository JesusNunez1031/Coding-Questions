package codingbat.logic_1;

public class twoAsOne {
    /*
    Given three ints, a b c, return true if it is possible to add two of the ints to get the third.

    codingbat.logic_1.twoAsOne(1, 2, 3) → true
    codingbat.logic_1.twoAsOne(3, 1, 2) → true
    codingbat.logic_1.twoAsOne(3, 2, 2) → false
     */
    public boolean twoAsOne(int a, int b, int c) {
        int sum1 = a + b;
        int sum2 = b + c;
        int sum3 = a + c;

        return sum1 == c || sum2 == a || sum3 == b;
    }
}
