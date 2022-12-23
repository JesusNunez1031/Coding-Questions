package codingbat.logic_1;

public class specialEleven {
    /*
    We'll say a number is special if it is a multiple of 11 or if it is one more than a multiple of 11. Return true if the given non-negative number is special. Use the % "mod" operator -- see Introduction to Mod

    codingbat.logic_1.specialEleven(22) → true
    codingbat.logic_1.specialEleven(23) → true
    codingbat.logic_1.specialEleven(24) → false
     */
    public boolean specialEleven(int n) {
        return n % 11 == 0 || n % 11 == 1;
    }
}
