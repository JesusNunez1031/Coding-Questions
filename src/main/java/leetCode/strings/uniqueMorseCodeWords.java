package leetCode.strings;

import java.util.HashSet;
import java.util.Set;

public class uniqueMorseCodeWords {
    /*
    International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes,
    as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

    For convenience, the full table for the 26 letters of the English alphabet is given below:
    [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]

    Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For
    example, "cab" can be written as "-.-..--...", (which is the concatenation "-.-." + ".-" + "-..."). We'll call
    such a concatenation, the transformation of a word.

    Return the number of different transformations among all words we have.

    Example:
    Input: words = ["gin", "zen", "gig", "msg"]
    Output: 2
    Explanation:
    The transformation of each word is:
            "gin" -> "--...-."
            "zen" -> "--...-."
            "gig" -> "--...--."
            "msg" -> "--...--."

    There are 2 different transformations, "--...-." and "--...--.".

     */
    //letters of the alphabet as morse code translated
    static String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> translated = new HashSet<>();

        for(String word : words) {
            StringBuilder code = new StringBuilder();

            for(char c : word.toCharArray()) {
                code.append(MORSE[c - 'a']);
            }
            translated.add(code.toString());
        }
        return translated.size();
    }

    //random method to translate a word to morse code
    private static String convertWordToMorse(String word) {
        word = word.toLowerCase();
        StringBuilder coded = new StringBuilder();

        for(char c : word.toCharArray()) {
            coded.append(MORSE[c - 'a']).append(" ");
        }
        return coded.toString();
    }

    public static void main(String[] args) {
        String word = "quantum";
        System.out.printf("%s translated to morse code: %s", word, convertWordToMorse(word));
    }
}
