import java.util.*;

public class NumberOfMatchingSubsequences {
    /*
    Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

    A subsequence of a string is a new string generated from the original string with some characters (can be none)
    deleted without changing the relative order of the remaining characters.

    For example, "ace" is a subsequence of "abcde".

    Example 1:
    Input: s = "abcde", words = ["a","bb","acd","ace"]
    Output: 3
    Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".

    Example 2:
    Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
    Output: 2

    Constraints:
        1 <= s.length <= 5 * 10^4
        1 <= words.length <= 5000
        1 <= words[i].length <= 50
        s and words[i] consist of only lowercase English letters.
     */

    //TC: O(n * l^2) where n is the number of words and l is the average length of each word and the other l is the use of indexOf()
    public int numMatchingSubseq(String s, String[] words) {
        int subsequences = 0;

        //subs holds words that are subsequences of s, and notSubs holds words that are not
        //the sets are a form of memoization and help avoid checking duplicate words and avoiding O(n^3 x l) time complexity
        Set<String> subs = new HashSet<>();
        Set<String> notSubs = new HashSet<>();

        for (String word : words) {
            //check if the word has been seen before and was a subsequence
            if (subs.contains(word)) {
                subsequences++;
            }
            //check if the word has been seen before and was not a subsequence
            else if (notSubs.contains(word)) {
                continue;
            } else {
                /*
                    if neither sets have the word, check if the word is a subsequence, if it is add the word to the
                    subsequences set, otherwise add the word to the set of non subsequence words
                 */
                if (isSubsequence(word, s)) {
                    subsequences++;
                    subs.add(word);
                } else {
                    notSubs.add(word);
                }
            }
        }
        return subsequences;
    }

    private boolean isSubsequence(String word, String s) {
        //a subsequence cannot be of larger length than s
        if (word.length() > s.length()) {
            return false;
        }

        // index of the previous character in word and the range from where the current character can be looked for
        int prevIndex = 0;

        for (char c : word.toCharArray()) {
            /*
                search for the current character c in s after the index of the previous character c since a valid
                subsequence "word" has all the characters in s and each character comes after the previous
            */
            int index = s.indexOf(c, prevIndex);

            //return false if no character c exists in s
            if (index == -1) {
                return false;
            }

            //prevIndex becomes index + 1 to handle the case of duplicate characters in a sequence
            prevIndex = index + 1;
        }
        return true;
    }

    //TC: O(n * m) where n is the length of s and m is the average length of words in "words"
    public int numMatchingSubseqEz(String s, String[] words) {
        int subsequences = 0;

        //map holds each character in s as keys and a queue of all words that begin with key letter as the values
        Map<Character, Queue<String>> map = new HashMap<>();

        //add all the letters in s as keys into the map
        for (char c : s.toCharArray()) {
            map.putIfAbsent(c, new LinkedList<>());
        }

        //add the words to the list of their starting character
        for (String word : words) {
            char letter = word.charAt(0);
            //add the word to the letter key only if s contains the letter
            if (map.containsKey(letter)) {
                map.get(letter).add(word);
            }
        }

        for (char c : s.toCharArray()) {
            //get the list of words that start with character c
            Queue<String> cList = map.get(c);

            int size = cList.size();

            for (int i = 0; i < size; i++) {
                String word = cList.remove();

                /*
                    if removing the the first letter c from the current word leaves it with a length of 0
                    a subsequence was found since the word was reduced to 0 using all letters seen so far in s
                    in order
                */
                if (word.substring(1).length() == 0) {
                    subsequences++;
                } else {
                    //if the new word is not of length 0, add it to the new list for the new first letter key if the letter exists in s
                    char newKey = word.charAt(1);
                    if (map.containsKey(newKey)) {
                        map.get(newKey).add(word.substring(1));
                    }
                }
            }
        }
        return subsequences;
    }
}
