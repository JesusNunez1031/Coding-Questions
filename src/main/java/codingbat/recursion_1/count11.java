package codingbat.recursion_1;

public class count11 {
    /*
    Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap.

    codingbat.recursion_1.count11("11abc11") → 2
    codingbat.recursion_1.count11("abc11x11x11") → 3
    codingbat.recursion_1.count11("111") → 1
     */
    public int count11(String str) {
        if (str.length() <= 1) {
            return 0;
        }

        if (str.startsWith("11")) {
            return 1 + count11(str.substring(2));
        }
        return count11(str.substring(1));
    }
}
