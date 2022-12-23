package codingbat.warmup_2;

public class stringMatch {

    /*
    Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings.

    codingbat.warmup_2.stringMatch("xxcaazz", "xxbaaz") → 3
    codingbat.warmup_2.stringMatch("abc", "abc") → 2
    codingbat.warmup_2.stringMatch("abc", "axc") → 0
     */

    public int stringMatch(String a, String b) {
        int count = 0;
        int len = Math.min(a.length(), b.length());

        for (int i = 0; i < len - 1; i++) {
            if (a.substring(i, i + 2).equals(b.substring(i, i + 2))) {
                count++;
            }
        }
        return count;
    }
}
