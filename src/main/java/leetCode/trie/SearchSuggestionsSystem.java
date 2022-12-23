package leetCode.trie;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem {
    /*
    Given an array of strings products and a string searchWord. We want to design a system that suggests at most three
    product names from products after each character of searchWord is typed. Suggested products should have common prefix
    with the searchWord. If there are more than three products with a common prefix return the three lexicographically
    minimums products.

    Return list of lists of the suggested products after each character of searchWord is typed.

    Example 1:
    Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
    Output: [
    ["mobile","moneypot","monitor"],
    ["mobile","moneypot","monitor"],
    ["mouse","mousepad"],
    ["mouse","mousepad"],
    ["mouse","mousepad"]
    ]
    Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
    After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
    After typing mou, mous and mouse the system suggests ["mouse","mousepad"]

    Example 2:
    Input: products = ["havana"], searchWord = "havana"
    Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]

    Example 3:
    Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
    Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]

    Example 4:
    Input: products = ["havana"], searchWord = "tatiana"
    Output: [[],[],[],[],[],[],[]]

    Constraints:
        1 <= products.length <= 1000
        There are no repeated elements in products.
        1 <= Σ products[i].length <= 2 * 10^4
        All characters of products[i] are lower-case English letters.
        1 <= searchWord.length <= 1000
        All characters of searchWord are lower-case English letters.
     */
    static class Trie {
        static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            String value = null;
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        //adds "word" to the trie DS
        public void addWord(String word) {
            TrieNode iter = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new TrieNode();
                }

                iter = iter.children[c - 'a'];
            }
            iter.value = word;
        }

        //returns the last node of the entry
        public TrieNode getEntry(String entry) {
            TrieNode iter = root;

            for (int i = 0; i < entry.length(); i++) {
                char c = entry.charAt(i);

                if (iter.children[c - 'a'] == null) {
                    return null;
                }

                iter = iter.children[c - 'a'];
            }
            return iter;
        }

        //Returns a list of the 3 entries in the trie that are similar to the prefix passed
        public List<String> entriesWithPrefix(String prefix) {
            List<String> entries = new ArrayList<>();
            TrieNode node = getEntry(prefix); //set the node to the last node in prefix if it exists
            collectEntries(node, entries);

            return entries;
        }

        private void collectEntries(TrieNode node, List<String> entries) {
            //backtrack if the node for a new letter does not exit or if the list is of size 3
            if (node == null || entries.size() >= 3) {
                return;
            }
            //if a word ends at a current node, add it to the entries
            if (node.value != null) {
                entries.add(node.value);
            }

            //search through all the alphabet for a new word after the last prefix node
            for (char c = 'a'; c <= 'z'; c++) {
                //only move to the next node if the node for c - 'a' exists
                if (node.children[c - 'a'] != null) {
                    collectEntries(node.children[c - 'a'], entries);
                }
            }
        }
    }

    /*
        TC: O(n) to fill the trie where n is the number of words in products + O(len(prefix)) where it takes O(1) time to
        find all other words in trie using prefix since we only search through 26 letters, thus total Time Complexity is O(n)
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();

        //add all the words in products to the trie
        for (String word : products) {
            trie.addWord(word);
        }

        //List of Lists for all suggestions provided for every prefix in "searchWord"
        List<List<String>> suggestionHistory = new ArrayList<>();

        //search the trie for every prefix in "searchWord"
        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);

            suggestionHistory.add(trie.entriesWithPrefix(prefix));
        }

        return suggestionHistory;
    }
}
