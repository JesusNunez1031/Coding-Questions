package codingbat.warmup_1;

public class endUp {
    /*

Given a string, return a new string where the last 3 chars are now in upper case. If the string has less than 3 chars, uppercase whatever is there. Note that str.toUpperCase() returns the uppercase version of a string.

    codingbat.warmup_1.endUp("Hello") → "HeLLO"
    codingbat.warmup_1.endUp("hi there") → "hi thERE"
    codingbat.warmup_1.endUp("hi") → "HI"
     */

    public String endUp(String str) {
        if (str.length() <= 3) {
            return str.toUpperCase();
        }
        int modStr = str.length() - 3;
        String start = str.substring(0, str.length() - 3);
        String last = str.substring(modStr);

        return start + last.toUpperCase();
    }
}
