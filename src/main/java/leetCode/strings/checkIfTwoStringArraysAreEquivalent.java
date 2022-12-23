package leetCode.strings;

public class checkIfTwoStringArraysAreEquivalent {
    /*
    Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
    A string is represented by an array if the array elements concatenated in order forms the string.

    Example 1:
    Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
    Output: true
    Explanation:
    word1 represents string "ab" + "c" -> "abc"
    word2 represents string "a" + "bc" -> "abc"
    The strings are the same, so return true.

    Example 2:
    Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
    Output: false

    Example 3:
    Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
    Output: true

    Constraints:
        1 <= word1.length, word2.length <= 103
        1 <= word1[i].length, word2[i].length <= 103
        1 <= sum(word1[i].length), sum(word2[i].length) <= 103
        word1[i] and word2[i] consist of lowercase letters.
     */
    //TC/S: O(max(n, m)) where n is the length of word1 and m is the length of word2, and O(n) space since we construct the string
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        //make the first string from word1
        for (String word : word1) {
            s1.append(word);
        }

        //make the second string from word2
        for (String word : word2) {
            s2.append(word);
        }

        //compare the two string, if equal, the arrays represent the same string, if not the arrays are different strings
        return s1.toString().equals(s2.toString());
    }

    //TC/S: O(n) and O(1) space used since we use pointer variables rather than store the strings in the word arrays
    private boolean arrayStringsAreEqualS(String[] word1, String[] word2) {
        //indexes used to iterate through words in the word arrays
        int w1_index = 0, w2_index = 0;

        //indexes used to iterate through the characters in the word arrays
        int w1_char = 0, w2_char = 0;

        while (w1_index < word1.length && w2_index < word2.length) {
            //if the current characters observed ever don't match, the string arrays hold different strings
            if (word1[w1_index].charAt(w1_char) != word2[w2_index].charAt(w2_char)) {
                return false;
            }

            //move to the next character
            w1_char++;
            w2_char++;

            /*
                if the index used to traverse a word in either array reaches the length of the word, we move to the next
                word in the array and reset the word traversal index variable
            */
            if (w1_char == word1[w1_index].length()) {
                w1_char = 0;
                w1_index++;
            }

            if (w2_char == word2[w2_index].length()) {
                w2_char = 0;
                w2_index++;
            }
        }

        //if the array string match, both character traversal indexes will also match
        return w1_char == w2_char;
    }
}
