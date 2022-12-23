package codingbat.warmup_2;

public class stringX {
    /*

Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end should not be removed.

    codingbat.warmup_2.stringX("xxHxix") → "xHix"
    codingbat.warmup_2.stringX("abxxxcd") → "abcd"
    codingbat.warmup_2.stringX("xabxxxcdx") → "xabcdx"
     */
    public String stringX(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x' && (i == 0 || i == str.length() - 1)) {
                result.append(str.charAt(i));
            } else {
                if (str.charAt(i) != 'x') {
                    result.append(str.charAt(i));
                }
            }
        }
        return result.toString();
    }

}
