package codingbat.warmup_1;

public class backAround {

    /*
    Given a string, take the last char and return a new string with the last char added at the front and back, so "cat" yields "tcatt". The original string will be length 1 or more.

    codingbat.warmup_1.backAround("cat") → "tcatt"
    codingbat.warmup_1.backAround("Hello") → "oHelloo"
    codingbat.warmup_1.backAround("a") → "aaa"
     */

    public String backAround(String str) {
        if (str.length() == 1) {
            return str + str + str;
        }
        char lastChar = str.charAt(str.length() - 1);

        return lastChar + str + lastChar;
    }
}
