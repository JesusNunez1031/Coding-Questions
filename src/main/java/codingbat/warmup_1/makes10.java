package codingbat.warmup_1;

public class makes10 {

    /*
    Given 2 ints, a and b, return true if one if them is 10 or if their sum is 10.

    codingbat.warmup_1.makes10(9, 10) → true
    codingbat.warmup_1.makes10(9, 9) → false
    codingbat.warmup_1.makes10(1, 9) → true
     */
    public boolean makes10(int a, int b) {
        int sum = a + b;
        if (a == 10 || b == 10 || sum == 10) {
            return true;
        }
        return false;
    }
}
