package leetCode.trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class shortEncodingOfWords {
    //TC: O(n log n) and O(n) space, where n is the length of the words array
    public int minimumLengthEncoding(String[] words) {
        if (words.length == 0) {
            return 0;
        }

        /*
            sort the words in descending order so all longer words are at the start, we do this because the longer words
            are the most likely to be in the encoded string while the smaller words are likely to be in the longer words,
            e.g. "me#" is in "time#"
        */
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        StringBuilder encoded = new StringBuilder();

        for (String word : words) {
            //only append the "word#" if the encoded string does not already have it
            if (encoded.indexOf(word + "#") == -1) { //!encoded.toString().contains(word + "#")
                encoded.append(word).append("#");
            }
        }
        //see the encoded string
        //System.out.println(encoded.toString());
        return encoded.length();
    }

    //TC: O(n^2) and O(n) space were n is the length of words
    public int minimumLengthEncodingSet(String[] words) {
        //use a set to get rid of all duplicate words in the array
        Set<String> set = new HashSet<>(Arrays.asList(words));

        /*
            for each word in the array, look in the set for a substring of the word and remove it, we start at 1 since
            starting at 0 would remove the word itself
        */
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }

        //the final length of the encoded string will be the length of all words + 1 for each unique word to account for "#"
        int encoded_length = 0;

        for (String word : set) {
            encoded_length += word.length() + 1;
        }

        return encoded_length;
    }

    class TrieNode {
        TrieNode[] children = null;
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
            root.children = new TrieNode[26];
        }

        /*
            Method adds "word" to the trie and returns the words length + 1 if a new branch was made, else it
            returns the number of nodes made
        */
        public int insert(String word) {
            TrieNode iter = root;
            //flag to signal if a new branch was made
            boolean newBranch = false;

            int nodes = 0;

            //being adding characters from the end of the word
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                boolean newLevel = false; //flag to indicate if a new node was added

                //if a new node needs to be added, we make a new level
                if (iter.children == null) {
                    newLevel = true;
                    iter.children = new TrieNode[26]; //make the new node for c
                }

                //initialize the new node for c if its not present
                if (iter.children[c - 'a'] == null) {
                    //if the c exists in the trie, then we are branching out to make a new word
                    if (!newLevel) {
                        newBranch = true;
                    }
                    iter.children[c - 'a'] = new TrieNode();
                    nodes++;
                }

                iter = iter.children[c - 'a'];
            }

            //if we made a new branch then we need the length of the word + 1, otherwise we just return the nodes made
            return newBranch ? word.length() + 1 : nodes;
        }
    }

    //TC: O(n) and O(n) space where n is the length of words
    public int minimumLengthEncodingTrie(String[] words) {
        Trie trie = new Trie();
        int encoded_length = 0;
        for (String word : words) {
            encoded_length += trie.insert(word);
        }
        return encoded_length;
    }
}
