package codingbat.string_1;

public class right2 {

    /*

Given a string, return a "rotated right 2" version where the last 2 chars are moved to the start. The string length will be at least 2.

    codingbat.string_1.right2("Hello") → "loHel"
    codingbat.string_1.right2("java") → "vaja"
    codingbat.string_1.right2("Hi") → "Hi"
     */
    public String right2(String str) {
        if (str.length() <= 2) {
            return str;
        }
        String lastTwo = str.substring(str.length() - 2);
        return lastTwo + str.substring(0, str.length() - 2);
    }
}
