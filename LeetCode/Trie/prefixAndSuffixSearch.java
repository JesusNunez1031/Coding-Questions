import java.util.ArrayList;
import java.util.List;

public class prefixAndSuffixSearch {
    /*
    Design a special dictionary which has some words and allows you to search the words in it by a prefix and a suffix.

    Implement the WordFilter class:
        - WordFilter(string[] words) Initializes the object with the words in the dictionary.
        - f(string prefix, string suffix) Returns the index of the word in the dictionary which has the prefix prefix
          and the suffix suffix. If there is more than one valid index, return the largest of them. If there is no such
          word in the dictionary, return -1.

    Example 1:
    Input
    ["WordFilter", "f"]
    [[["apple"]], ["a", "e"]]
    Output
    [null, 0]
    Explanation:
    WordFilter wordFilter = new WordFilter(["apple"]);
    wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = 'e".

    Constraints:
        1 <= words.length <= 15000
        1 <= words[i].length <= 10
        1 <= prefix.length, suffix.length <= 10
        words[i], prefix and suffix consist of lower-case English letters only.
        At most 15000 calls will be made to the function f.
     */

    class Trie {
        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            List<Integer> index = new ArrayList<>();
        }

        TrieNode root;
        boolean reversed; //flag indicates if we are making a trie from the reverse of all passed words

        //initialize a Trie of "words" entries
        public Trie(boolean isReversed) {
            root = new TrieNode();
            reversed = isReversed;
        }

        //adds word to Trie dictionary, the reverse of the word is added if reversed is true
        public void addWord(String word, int indx) {
            TrieNode iter = root;

            for (int i = 0; i < word.length(); i++) {
                char c = reversed ? word.charAt(word.length() - i - 1) : word.charAt(i);

                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new TrieNode();
                }

                iter = iter.children[c - 'a'];
                iter.index.add(indx);
            }
        }

        /*
            searches trie for a word that starts with the passed prefix/suffix word and returns the index array of all
            words that start with prefix or end with suffix

            if reversed flag is true, all words in the trie are reversed hence "word" will be a suffix so we search for
            a word starting from the last character in the suffix
            Ex: when searching for a word that ends with a prefix "word"

                since we built two tries, one made up of the original words, and another of the reverse of words, finding
                words that end with "word" is the same as finding words that start with "word" since all the suffix_trie
                words are in reverse

                e.g. words = [apple, ape, peeps]
                prefix_trie will have all the original words where each letter has an array of indexes and in that array
                the index of where each letter appears in ith word will be added, i.e. all letters in apple with have
                0 in the index array, then when "ape" is added, "a" "p" and "e" will also have index 1, etc.

                suffix_trie will have the reverse of all original words, [elppe, epa, speeps], so when we look for all
                words that end with suffix "e", the index array of e will be returned and the search will be treated as
                if searching for prefixes thanks to the reversal of words.

         */
        public List<Integer> startsWith(String word) {
            TrieNode iter = root;

            for (int i = 0; i < word.length(); i++) {
                char c = reversed ? word.charAt(word.length() - i - 1) : word.charAt(i);

                //return the empty list if a character in the suffix/prefix does not exist in the trie
                if (iter.children[c - 'a'] == null) {
                    return new ArrayList<>();
                }
                iter = iter.children[c - 'a'];
            }
            return iter.index;
        }
    }

    /**
     * Your WordFilter object will be instantiated and called as such:
     * WordFilter obj = new WordFilter(words);
     * int param_1 = obj.f(prefix,suffix);
     */
    /*
        TC of Trie: n * k where n is the number of words in array and k is the length of the largest word in the array
        TC of WordFilter: n * k, same as building Trie, and the f function is k + n where k is the length of suffix/prefix
                          due to startsWith method, and n is the largest count of the words in either sList or pList
     */

    class WordFilter {
        Trie prefix_trie; //trie made up of of all words in "words" array
        Trie suffix_trie; //trie made up of the reversed version of all words in "words" array

        public WordFilter(String[] words) {
            prefix_trie = new Trie(false);
            suffix_trie = new Trie(true);

            for (int i = 0; i < words.length; i++) {
                prefix_trie.addWord(words[i], i);
                suffix_trie.addWord(words[i], i);
            }
        }

        public int f(String prefix, String suffix) {
            //get the list of index of all words in the array that start with prefix and end with prefix
            List<Integer> pList = prefix_trie.startsWith(prefix);
            List<Integer> sList = suffix_trie.startsWith(suffix);

            /*
                search for the largest index where both lists coincide, i.e. the largest index of the the word that
                starts with and ends with prefix and suffix
             */
            int i = pList.size() - 1, j = sList.size() - 1;

            while (i >= 0 && j >= 0) {
                int a = pList.get(i);
                int b = sList.get(j);

                //if the indexes match return the index, guaranteed to be the largest search starts from the end
                if (a == b) {
                    return pList.get(i);
                } else {
                    //if prefix index is larger decrement its index, otherwise decrement the suffix index
                    if (pList.get(i) > sList.get(j)) {
                        i--;
                    } else {
                        j--;
                    }
                }
            }
            return -1;
        }
    }
}
