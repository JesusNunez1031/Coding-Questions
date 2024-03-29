package codingbat.string_2;

public class countCode {
    /*
    Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count.

    codingbat.string_2.countCode("aaacodebbb") → 1
    codingbat.string_2.countCode("codexxcode") → 2
    codingbat.string_2.countCode("cozexxcope") → 2
     */
    public int countCode(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.startsWith("co", i) && str.charAt(i + 3) == 'e') {
                count++;
            }
        }
        return count;
    }
}
