package codingbat.string_2;

public class prefixAgain {
    /*
    Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear
    somewhere else in the string? Assume that the string is not empty and that N is in the range 1..str.length().

    codingbat.string_2.prefixAgain("abXYabc", 1) → true
    codingbat.string_2.prefixAgain("abXYabc", 2) → true
    codingbat.string_2.prefixAgain("abXYabc", 3) → false
     */
    public boolean prefixAgain(String str, int n) {
        String prefix = str.substring(0, n);
        for (int i = n; i <= str.length() - n; i++) {
            if (str.substring(i, i + n).equals(prefix)) {
                return true;
            }
        }
        return false;
    }
}
