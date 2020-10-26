public class mixString {
    /*
    Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second char
    of a, the second char of b, and so on. Any leftover chars go at the end of the result.

    mixString("abc", "xyz") → "axbycz"
    mixString("Hi", "There") → "HTihere"
    mixString("xxxx", "There") → "xTxhxexre"
     */
    public String mixString(String a, String b) {
        StringBuilder result = new StringBuilder();
        int aLen = a.length();
        int bLen = b.length();
        int max = Math.max(aLen, bLen);

        for (int i = 0; i < max; i++) {
            if (i <= aLen - 1) {
                result.append(a.substring(i, i + 1));
            }
            if (i <= bLen - 1) {
                result.append(b.substring(i, i + 1));
            }
        }
        return result.toString();
    }
}
