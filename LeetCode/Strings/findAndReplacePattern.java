import java.util.ArrayList;
import java.util.List;

public class findAndReplacePattern {
    /*
    Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the
    answer in any order.

    A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the
    pattern with p(x), we get the desired word.

    Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter,
    and no two letters map to the same letter.

    Example 1:
    Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
    Output: ["mee","aqq"]
    Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
    "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.

    Example 2:
    Input: words = ["a","b","c"], pattern = "a"
    Output: ["a","b","c"]

    Constraints:
        1 <= pattern.length <= 20
        1 <= words.length <= 50
        words[i].length == pattern.length
        pattern and words[i] are lowercase English letters.
     */
    //TC: O(n * l) where n is the number of words in array and l is the average length of a word in array
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean matches(String word, String pattern) {
        //all words in array are of pattern.length so no need to check for length

        /*
            arrays to hold the characters that map to a character of the opposing string, e.g. each character in word
            should map to only one character in the pattern and vice versa, i.e. wordToPattern[i] should equal some
            character in pattern, and patternToWord[i] should map to some character in word
         */
        char[] wordToPattern = new char[26];
        char[] patternToWord = new char[26];

        for (int i = 0; i < pattern.length(); i++) {
            char wordChar = word.charAt(i);
            char patternChar = pattern.charAt(i);

            //if the current ith character in word is not mapped to nothing, map it to the current char in pattern
            if (wordToPattern[wordChar - 'a'] == 0) {
                wordToPattern[wordChar - 'a'] = patternChar;
            }

            //if the current ith character in pattern isn't mapped to nothing, map it to the current char in word
            if (patternToWord[patternChar - 'a'] == 0) {
                patternToWord[patternChar - 'a'] = wordChar;
            }

            //if the mapping's of characters do not coincide, return false since the word characters don't match pattern or vice versa
            if (patternToWord[patternChar - 'a'] != wordChar || wordToPattern[wordChar - 'a'] != patternChar) {
                return false;
            }
        }
        return true;
    }
}
