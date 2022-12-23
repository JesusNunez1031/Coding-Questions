package codingbat.string_1;

public class seeColor {
    /*

Given a string, if the string begins with "red" or "blue" return that color string, otherwise return the empty string.

    codingbat.string_1.seeColor("redxx") → "red"
    codingbat.string_1.seeColor("xxred") → ""
    codingbat.string_1.seeColor("blueTimes") → "blue"
     */
    public String seeColor(String str) {
        if (str.length() < 3) {
            return "";
        }
        if (str.charAt(0) == 'r') {
            return "red";
        } else if (str.charAt(0) == 'b' && str.length() >= 4) {
            return "blue";
        }
        return "";
    }
}
