package codingbat.logic_1;

public class sumLimit {
    /*
    Given 2 non-negative ints, a and b, return their sum, so long as the sum has the same number of digits as a. If the sum has more digits than a, just return a without b. (Note: one way to compute the number of digits of a non-negative int n is to convert it to a string with String.valueOf(n) and then check the length of the string.)

    codingbat.logic_1.sumLimit(2, 3) → 5
    codingbat.logic_1.sumLimit(8, 3) → 8
    codingbat.logic_1.sumLimit(8, 1) → 9
     */
    public int sumLimit(int a, int b) {
        int sum = a + b;
        int length = String.valueOf(sum).length();
        int lengthOfA = String.valueOf(a).length();

        return length > lengthOfA ? a : sum;
    }
}
