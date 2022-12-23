package codingbat.string_1;

public class left2 {

    /*
    Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end. The string length will be at least 2.

    codingbat.string_1.left2("Hello") → "lloHe"
    codingbat.string_1.left2("java") → "vaja"
    codingbat.string_1.left2("Hi") → "Hi"
     */

    public String left2(String str) {
        if (str.length() <= 2) {
            return str;
        }
        String firstTwo = str.substring(0, 2);
        return str.substring(2) + firstTwo;
    }
}
