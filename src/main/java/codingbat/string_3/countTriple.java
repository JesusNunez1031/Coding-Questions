package codingbat.string_3;

public class countTriple {

    /*
    We'll say that a "triple" in a string is a char appearing three times in a row. Return the number of triples in the given string. The triples may overlap.

    codingbat.string_3.countTriple("abcXXXabc") → 1
    codingbat.string_3.countTriple("xxxabyyyycd") → 3
    codingbat.string_3.countTriple("a") → 0
     */

    public int countTriple(String str) {
        int triple = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                if (i < str.length() - 2 && str.charAt(i + 1) == str.charAt(i + 2)) {
                    triple++;
                }
            }
        }
        return triple;
    }

}
