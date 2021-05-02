public class longestWordInDictionary {
    /*
    Given a list of strings words representing an English Dictionary, find the longest word in words that can be built
    one character at a time by other words in words. If there is more than one possible answer, return the longest word
    with the smallest lexicographical order.
    If there is no answer, return the empty string.

    Example 1:
    Input:
    words = ["w","wo","wor","worl", "world"]
    Output: "world"
    Explanation:
    The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

    Example 2:
    Input:
    words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
    Output: "apple"
    Explanation:
    Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

    Note:
        All the strings in the input will only contain lowercase letters.
        The length of words will be in the range [1, 1000].
        The length of words[i] will be in the range [1, 30].
     */
    static class Trie {
        static class TrieNode {
            String word;            //to compare longest paths, we store the word entry as a value at the last node
            public int R = 26;     //alphabet size
            TrieNode[] children = new TrieNode[R];
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        //adds a new entry to the trie
        public void insert(String entry) {
            TrieNode node = root;
            for (int i = 0; i < entry.length(); i++) {
                char c = entry.charAt(i);

                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }

                node = node.children[c - 'a'];
            }

            //mark the last node with the entry
            node.word = entry;
        }

        //Method returns the longest entry in the trie that can be made from all the current entries
        public String longestEntry() {
            String[] longest_word = new String[1];
            longest_word[0] = "";
            search(root, longest_word);
            return longest_word[0];
        }

        /*
            Method searches through the trie for nodes with values, since the node values hold the word entry, we compare
            the current node word to the longest word found and if its length is larger or if its length is equal but
            has a lower lexicographical order, we update the longest word [DFS]
         */
        private void search(TrieNode node, String[] longest_word) {
            //if the node is not in the trie, return
            if (node == null) {
                return;
            }

            //if the node has a value, check to see if it can be the longest word
            if (node.word != null) {
                //if the length of the current word in a path is larger than the longest_word, make it the new longest
                if (node.word.length() > longest_word[0].length()) {
                    longest_word[0] = node.word;
                    /*
                        if the current word and the current longest are equal length and the current word is of lesser
                        lexicographical order, make it the new longest
                     */
                } else if (node.word.length() == longest_word[0].length() && node.word.compareTo(longest_word[0]) < 1) {
                    longest_word[0] = node.word;
                }
            }

            //search through all available paths in the trie for the given node
            for (TrieNode child : node.children) {
                //only call method if the current child it an entry
                if (child != null && child.word != null) {
                    search(child, longest_word);
                }
            }
        }
    }
    /*
        TC: Adding words to the trie, O(m) where m is the length of the word, searching for the longest word, O(∑n) where
        n is the length of words[i].
        Space used is the construction of the trie which is also O(∑n)
     */
    public String longestWord(String[] words) {
        if (words.length == 0) {
            return "";
        }

        //initialize trie
        Trie trie = new Trie();

        //add all words in array to the trie
        for (String word : words) {
            trie.insert(word);
        }
        return trie.longestEntry();
    }
}
