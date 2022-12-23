package codingbat.string_2;

public class xyBalance {
    /*
    We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later
    in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.

    codingbat.string_2.xyBalance("aaxbby") → true
    codingbat.string_2.xyBalance("aaxbb") → false
    codingbat.string_2.xyBalance("yaaxbb") → false
     */
    public boolean xyBalance(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 'x') {
                return false;
            } else if (str.charAt(i) == 'y') {
                return true;
            }
        }
        return true;
    }
}
