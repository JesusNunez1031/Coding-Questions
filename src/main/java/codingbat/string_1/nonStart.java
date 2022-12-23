package codingbat.string_1;

public class nonStart {

    /*

Given 2 strings, return their concatenation, except omit the first char of each. The strings will be at least length 1.

    codingbat.string_1.nonStart("Hello", "There") → "ellohere"
    codingbat.string_1.nonStart("java", "code") → "avaode"
    codingbat.string_1.nonStart("shotl", "java") → "hotlava"
     */

    public String nonStart(String a, String b) {
        return a.substring(1) + b.substring(1);
    }
}
