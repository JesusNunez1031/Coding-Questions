package codingbat.recursion_1;

public class endX {
    /*
    Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string.

    codingbat.recursion_1.endX("xxre") → "rexx"
    codingbat.recursion_1.endX("xxhixx") → "hixxxx"
    codingbat.recursion_1.endX("xhixhix") → "hihixxx"
     */
    public String endX(String str) {
        if (str.length() <= 1) {
            return str;
        }

        if (str.charAt(0) == 'x') {
            return endX(str.substring(1)) + 'x';
        }
        return str.charAt(0) + endX(str.substring(1));
    }
}
