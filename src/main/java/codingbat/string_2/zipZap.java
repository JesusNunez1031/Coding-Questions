package codingbat.string_2;

public class zipZap {
    /*
    Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'.
    Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".

    codingbat.string_2.zipZap("zipXzap") → "zpXzp"
    codingbat.string_2.zipZap("zopzop") → "zpzp"
    codingbat.string_2.zipZap("zzzopzop") → "zzzpzp"
     */
    public String zipZap(String str) {
        StringBuilder result = new StringBuilder();
        if (str.length() <= 2) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
                result.append(str.charAt(i)).append(str.charAt(i + 2));
                i += 2;
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
