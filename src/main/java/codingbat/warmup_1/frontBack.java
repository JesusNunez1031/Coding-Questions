package codingbat.warmup_1;

public class frontBack {

    /*

    Given a string, return a new string where the first and last chars have been exchanged.

    codingbat.warmup_1.frontBack("code") → "eodc"
    codingbat.warmup_1.frontBack("a") → "a"
    codingbat.warmup_1.frontBack("ab") → "ba"
     */

    public String frontBack(String str) {
        if (str.length() <= 1) {
            return str;
        }
        char firstChar = str.charAt(0);
        char lastChar = str.charAt(str.length() - 1);

        return lastChar + str.substring(1, str.length() - 1) + firstChar;
    }
}
