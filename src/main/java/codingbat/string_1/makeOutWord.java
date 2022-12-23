package codingbat.string_1;

public class makeOutWord {
    /*
    Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting at index i and going up to but not including index j.

    codingbat.string_1.makeOutWord("<<>>", "Yay") → "<<Yay>>"
    codingbat.string_1.makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
    codingbat.string_1.makeOutWord("[[]]", "word") → "[[word]]"
     */
    public String makeOutWord(String out, String word) {
        String first = out.substring(0, 2);
        String last = out.substring(2, 4);
        return first + word + last;
    }
}
