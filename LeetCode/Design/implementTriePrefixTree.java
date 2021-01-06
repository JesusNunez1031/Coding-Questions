public class implementTriePrefixTree {
    /*
    Implement a trie with insert, search, and startsWith methods.

    Example:
    Trie trie = new Trie();

    trie.insert("apple");
    trie.search("apple");   // returns true
    trie.search("app");     // returns false
    trie.startsWith("app"); // returns true
    trie.insert("app");
    trie.search("app");     // returns true

    Note:
        You may assume that all inputs are consist of lowercase letters a-z.
        All inputs are guaranteed to be non-empty strings.

        Time Complexities:
            Method      |       Complexity      |       Space used
            insert      |          O(m)         |           O(m)
            search      |          O(m)         |           O(1)
          startsWith    |          O(p)         |           O(1)

          where m is the length of inserted word and p is the length of prefix
     */

    /*
        TrieNode class lets us create objects that serve as nodes of letters in the trie, each node has an array of
        TrieNode children.
     */
    public static class TrieNode {
        //each node in the trie can have children and they are stored in an array of size 26, we assume only alphabet letters will be added to trie
        public TrieNode[] children = new TrieNode[26];
        //The last node of an inserted word will be marked with a unique value which signifies the end of a unique entry
        public Integer value;

        //default constructor
        public TrieNode() {

        }
    }

    static class Trie {
        private TrieNode root;  //root node in the trie
        private Integer value;  //value used to mark new entries

        /**
         * Initialize a trie with an empty root node
         */
        public Trie() {
            root = new TrieNode();
            value = 0;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;   //node used to traverse trie starting from root

            //search through the trie adding children to the root if the characters in the word don't exist
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                //if the current character in the word is not in the trie, make a new node for it
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }

                //traverse to the next node c in the trie
                node = node.children[c - 'a'];
            }
            //assign a value to the node of the last letter in "word", this is to mark it as an entry
            node.value = this.value++;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null) {
                return false;
            }

            TrieNode node = root; //node used to iterate through the trie starting from root

            //search through the trie for the word
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                //if the current letter c node does not exist in the trie return false, the word is not in the trie
                if (node.children[c - 'a'] == null) {
                    return false;
                }

                //move to the next child node
                node = node.children[c - 'a'];
            }
        /*
            if the word is in the trie, then its last letter node will have an assigned value, otherwise, if we
            end on a letter node with no value, this means the word does not exist since we only mark the last letter
            node of newly entered words with a unique value
        */
            return node.value != null;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root; //node used to iterate through the trie starting from root

            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);

                //if a character in prefix is not in the trie, return false
                if (node.children[c - 'a'] == null) {
                    return false;
                }

                //move to the next child node
                node = node.children[c - 'a'];
            }
            //if we traversed the trie using the prefix and all its characters are in the trie, we return true
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("she");
        trie.insert("sells");
        trie.insert("sea");
        trie.insert("shells");
        System.out.println(trie.search("she"));
        System.out.println(trie.startsWith("se"));
    }
}
