import java.util.HashSet;
import java.util.Set;

public class CheckIfSentenceIsPangram {
    /*
    A pangram is a sentence where every letter of the English alphabet appears at least once.

    Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false
    otherwise.

    Example 1:
    Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
    Output: true
    Explanation: sentence contains at least one of every letter of the English alphabet.

    Example 2:
    Input: sentence = "leetcode"
    Output: false

    Constraints:
        1 <= sentence.length <= 1000
        sentence consists of lowercase English letters.
     */
    //TC: O(n)
    public boolean checkIfPangram(String sentence) {
        //a string of length less than the alphabet cant have every letter
        if (sentence.length() < 26) {
            return false;
        }

        /*
            Rather than iterating through each character in sentence, go through each character in the alphabet checking
            if it exists in the sentence
         */
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (char c : alphabet.toCharArray()) {
            //return false if a letter in the alphabet is not in the sentence
            if (sentence.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    //TC/SC: O(n)
    public boolean checkIfPangramHS(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }

        Set<Character> set = new HashSet<>();

        //store each character in a set, if the set reaches a size of 26, we know the sentence has every letter in the alphabet
        for (char c : sentence.toCharArray()) {
            set.add(c);

            if (set.size() == 26) {
                return true;
            }
        }
        return false;
    }
}
