import java.util.*;

public class vowelSpellchecker {
    /*
    Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.

    For a given query word, the spell checker handles two categories of spelling mistakes:
        - Capitalization: If the query matches a word in the wordlist (case-insensitive), then the query word is returned
          with the same case as the case in the wordlist.
            - Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
            - Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
            - Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
        - Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel
          individually, it matches a word in the wordlist (case-insensitive), then the query word is returned with the
          same case as the match in the wordlist.
            - Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
            - Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
            - Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)

    In addition, the spell checker operates under the following precedence rules:
        - When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
        - When the query matches a word up to capitalization, you should return the first such match in the wordlist.
        - When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
        - If the query has no matches in the wordlist, you should return the empty string.
    Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].

    Example 1:
    Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
    Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]

    Note:
        1 <= wordlist.length <= 5000
        1 <= queries.length <= 5000
        1 <= wordlist[i].length <= 7
        1 <= queries[i].length <= 7
        All strings in wordlist and queries consist only of english letters.
     */
    //TC: O(w + q) & O(w + q) where w are all the words in wordList and q are the queries
    public String[] spellchecker(String[] wordlist, String[] queries) {
        //contains the exact words from the wordlist so in the case a query is an exact match from the wordlist we just return the word from wordlist
        Set<String> set = new HashSet<>();

        //contains the version of the word that is not case sensitive, e.g. KiTe
        Map<String, String> caseInsensitive = new HashMap<>();

        //contains the version of the word with only constants, e.g. k*t*, vowels have been omitted
        Map<String, String> constants = new HashMap<>();

        //add the words from the wordlist to the data structures in their respective versions
        for (String word : wordlist) {
            set.add(word); //add the exact word to the set

            String wordLC = word.toLowerCase();
            caseInsensitive.putIfAbsent(wordLC, word);  //add case insensitive word to the case map
            constants.putIfAbsent(deleteVowels(wordLC), word);  //add the constant version of the word to the constant map
        }

        //String array to hold the spellchecked words
        String[] spellChecked = new String[queries.length];
        int i = 0;

        for (String query : queries) {
            //if the query is an exact match to a wordlist word
            if (set.contains(query)) {
                spellChecked[i] = query;
            }
            /*
                If the query matches a word in the wordlist (case-insensitive), then the query word is returned with the same
                case as the case in the wordlist.
             */
            else if (caseInsensitive.containsKey(query.toLowerCase())) {
                spellChecked[i] = caseInsensitive.get(query.toLowerCase());
            }
            /*
                If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel individually,
                it matches a word in the wordlist (case-insensitive), then the query word is returned with the same case
                as the match in the wordlist.
             */
            else if (constants.containsKey(deleteVowels(query.toLowerCase()))) {
                spellChecked[i] = constants.get(deleteVowels(query.toLowerCase()));
            }
            //query was not found
            else {
                spellChecked[i] = "";
            }
            i++;
        }
        return spellChecked;
    }

    //Returns a version of the "word" with vowels replaced by '*', e.g. kite -> k*t*
    private String deleteVowels(String word) {
        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append("*");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //returns true if c is a vowel, false otherwise
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
