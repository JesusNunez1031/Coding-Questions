import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class duplicateEncoder {
    /*
    The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if
    that character appears only once in the original string, or ")" if that character appears more than once in the
    original string. Ignore capitalization when determining if a character is a duplicate.

    Examples
    "din"      =>  "((("
    "recede"   =>  "()()()"
    "Success"  =>  ")())())"
    "(( @"     =>  "))(("

    Notes:
        Assertion messages may be unclear about what they display in some languages. If you read "...It Should encode
        XXX", the "XXX" is the expected result, not the input!
     */
    //TC/S:O(n)
    static String encode(String word) {
        if (word.length() == 0) {
            return "";
        }
        word = word.toLowerCase();
        int[] freq = new int[256];
        //add the frequency of each character of word in to chars array
        for (char c : word.toCharArray()) {
            freq[c]++;
        }

        StringBuilder encode = new StringBuilder();

        //append "(" if freq[c] < 2 or ")" if freq[c] > 1
        for (char c : word.toCharArray()) {
            if (freq[c] == 1) {
                encode.append("(");
            } else {
                encode.append(")");
            }
        }
        return encode.toString();
    }

    //TC:O(n^2) and O(1) space
    static String encodeEz(String word) {
        if (word.length() == 0) {
            return "";
        }
        word = word.toLowerCase();

        StringBuilder encode = new StringBuilder();
        //append "(" if freq[c] < 2 or ")" if freq[c] > 1
        for (char c : word.toCharArray()) {
            //if the first index of c is also its last, there's only one character c
            if(word.indexOf(c) == word.lastIndexOf(c)) {
                encode.append("(");
            } else {
                encode.append(")");
            }
        }
        return encode.toString();
    }
    @Test
    public void test() {
        assertEquals(")()())()(()()(",
                duplicateEncoder.encode("Prespecialized"));
        assertEquals("))))())))",duplicateEncoder.encode("   ()(   "));
    }
}
