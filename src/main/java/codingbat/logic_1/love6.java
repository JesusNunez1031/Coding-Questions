package codingbat.logic_1;

public class love6 {
    /*
    The number 6 is a truly great number. Given two int values, a and b, return true if either one is 6. Or if their sum or difference is 6. Note: the function Math.abs(num) computes the absolute value of a number.

    codingbat.logic_1.love6(6, 4) → true
    codingbat.logic_1.love6(4, 5) → false
    codingbat.logic_1.love6(1, 5) → true
     */
    public boolean love6(int a, int b) {
        int sum = a + b;
        int diff = Math.abs(a - b);
        return a == 6 || b == 6 || sum == 6 || diff == 6;
    }
}
