package codingbat.logic_1;

public class shareDigit {
    /*
    Given two ints, each in the range 10..99, return true if there is a digit that appears in both numbers, such as the 2 in 12 and 23. (Note: division, e.g. n/10, gives the left digit while the % "mod" n%10 gives the right digit.)

    codingbat.logic_1.shareDigit(12, 23) → true
    codingbat.logic_1.shareDigit(12, 43) → false
    codingbat.logic_1.shareDigit(12, 44) → false
     */
    public boolean shareDigit(int a, int b) {
        int aLeftD = a / 10;
        int bLeftD = b / 10;

        int aRightD = a % 10;
        int bRightD = b % 10;

        return (aLeftD == bLeftD || aLeftD == bRightD || aRightD == bLeftD || aRightD == bRightD);
    }
}
