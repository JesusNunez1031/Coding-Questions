package codingbat.string_1;

public class hasBad {

    /*
    Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0. Note: use .equals() to compare 2 strings.

    codingbat.string_1.hasBad("badxx") → true
    codingbat.string_1.hasBad("xbadxx") → true
    codingbat.string_1.hasBad("xxbadxx") → false
     */
    public boolean hasBad(String str) {
        if (str.length() <= 3 && !str.equals("bad")) {
            return false;
        }
        return (str.startsWith("bad") || str.startsWith("bad", 1));
    }

}
