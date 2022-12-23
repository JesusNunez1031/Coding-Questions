package codingbat.recursion_1;

public class allStar {
    /*
    Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".

    codingbat.recursion_1.allStar("hello") → "h*e*l*l*o"
    codingbat.recursion_1.allStar("abc") → "a*b*c"
    codingbat.recursion_1.allStar("ab") → "a*b"
     */
    public String allStar(String str) {
        if (str.length() <= 1) {
            return str;
        }

        return str.charAt(0) + "*" + allStar(str.substring(1));
    }
}
