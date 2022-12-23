package codingbat.recursion_1;

public class strCopies {
    /*
    Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string
    somewhere, possibly with overlapping. N will be non-negative.

    codingbat.recursion_1.strCopies("catcowcat", "cat", 2) → true
    codingbat.recursion_1.strCopies("catcowcat", "cow", 2) → false
    codingbat.recursion_1.strCopies("catcowcat", "cow", 1) → true
     */
    public boolean strCopies(String str, String sub, int n) {
        if (n == 0) {
            return true;
        }

        if (str.length() < sub.length()) {
            return false;
        }

        if (str.startsWith(sub)) {
            return strCopies(str.substring(1), sub, n - 1);
        }

        return strCopies(str.substring(1), sub, n);
    }
}
