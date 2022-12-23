package codingbat.string_2;

public class doubleChar {
    /*
    Given a string, return a string where for every char in the original, there are two chars.

    codingbat.string_2.doubleChar("The") → "TThhee"
    codingbat.string_2.doubleChar("AAbb") → "AAAAbbbb"
    codingbat.string_2.doubleChar("Hi-There") → "HHii--TThheerree"
     */
    public String doubleChar(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            result.append(str.charAt(i));
            result.append(str.charAt(i));
        }
        return result.toString();
    }
}
