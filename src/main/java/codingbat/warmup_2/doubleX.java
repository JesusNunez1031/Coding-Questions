package codingbat.warmup_2;

public class doubleX {

    /*

Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".

    codingbat.warmup_2.doubleX("axxbb") → true
    codingbat.warmup_2.doubleX("axaxax") → false
    codingbat.warmup_2.doubleX("xxxxx") → true
     */

    boolean doubleX(String str) {
        int i = str.indexOf("x");
        if (i == -1) {
            return false;
        }
        String x = str.substring(i);
        return x.startsWith("xx");

    }
}
