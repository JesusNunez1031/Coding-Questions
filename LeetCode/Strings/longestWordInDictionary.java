public class longestWordInDictionary {
    static class Trie {
        static class TrieNode {
            String word;            //to compare longest paths, we store the entry as a value at the last node
            public int R = 26;     //alphabet size
            TrieNode[] children = new TrieNode[R];
        }

        TrieNode root;
        String word;

        public Trie() {
            root = new TrieNode();
            word = "";
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

        public String longestEntry() {
            String[] longest_word = new String[1];
            longest_word[0] = "";
            search(root, longest_word);
            return longest_word[0];
        }

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
                } else if (node.word.length() == longest_word[0].length() && node.word.compareTo(longest_word[0]) < 0) {
                    longest_word[0] = node.word;
                }
            }

            //search through all available paths in the trie
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
