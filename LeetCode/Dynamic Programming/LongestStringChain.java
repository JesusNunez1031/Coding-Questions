import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    /*
    Given a list of words, each word consists of English lowercase letters.
    Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it
    equal to word2. For example, "abc" is a predecessor of "abac".

    A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of
    word_2, word_2 is a predecessor of word_3, and so on.

    Return the longest possible length of a word chain with words chosen from the given list of words.

    Example 1:
    Input: words = ["a","b","ba","bca","bda","bdca"]
    Output: 4
    Explanation: One of the longest word chain is "a","ba","bda","bdca".

    Example 2:
    Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
    Output: 5

    Constraints:
        1 <= words.length <= 1000
        1 <= words[i].length <= 16
        words[i] only consists of English lowercase letters.
     */
    //TC: O(n log n + n * l) nlogn to sort array of words, n words to traverse, and l characters to delete for each n words
    public int longestStrChain(String[] words) {
        if (words.length == 0) {
            return 0;
        }

        //sort words by length in ascending order
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        //map used to store the length of the longest chain that can be made for each word in array
        Map<String, Integer> memo = new HashMap<>();

        int longestChain = 0; //length of longest chain that can be made

        for (String word : words) {
            //add the word to the map with a chain link length of 1
            memo.put(word, 1);

            for (int i = 0; i < word.length(); i++) {
                /*
                    using StringBuilder, delete each character in "word" and check if the new string without charAt(i) has
                    been seen in a previous chain, if it has update the max chain for "word" to "word"'s link or the
                    new string "link"'s value + 1 to account for the deleted character
                */
                StringBuilder current = new StringBuilder(word);
                String link = current.deleteCharAt(i).toString(); //delete the ith character from "word"

                //check if "link" is in the map, if it is then update the max chain length for the current word
                if (memo.containsKey(link)) {
                    memo.put(word, Math.max(memo.get(word), memo.get(link) + 1));
                }

                //update the longest chain if a new longest length has been found
                if (memo.get(word) > longestChain) {
                    longestChain = memo.get(word);
                }
            }
        }
        return longestChain;
    }
}
