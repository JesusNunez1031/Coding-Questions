package codingbat.logic_1;

public class nearTen {
    /*
    Given a non-negative number "num", return true if num is within 2 of a multiple of 10. Note: (a % b) is the remainder of dividing a by b, so (7 % 5) is 2.

    codingbat.logic_1.nearTen(12) → true
    codingbat.logic_1.nearTen(17) → false
    codingbat.logic_1.nearTen(19) → true
     */
    public boolean nearTen(int num) {
        int rem = num % 10;
        return num % 10 == 2 || num % 10 == 1 || num % 10 == 0 || rem == 8 || rem == 9;
    }
}
