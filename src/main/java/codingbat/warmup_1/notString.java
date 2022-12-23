package codingbat.warmup_1;

public class notString {

    /*

    Given a string, return a new string where "not " has been added to the front. However, if the string already begins with "not", return the string unchanged. Note: use .equals() to compare 2 strings.

    codingbat.warmup_1.notString("candy") → "not candy"
    codingbat.warmup_1.notString("x") → "not x"
    codingbat.warmup_1.notString("not bad") → "not bad"
     */

    public String notString(String str) {
        if (str.length() >= 3 && str.startsWith("not")) {
            return str;
        }
        return "not " + str;
    }

}
