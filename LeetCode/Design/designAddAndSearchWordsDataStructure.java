public class designAddAndSearchWordsDataStructure {
    /*
    Design a data structure that supports adding new words and finding if a string matches any previously added string.

    Implement the WordDictionary class:
        - WordDictionary() Initializes the object.
        - void addWord(word) Adds word to the data structure, it can be matched later.
        - bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
          word may contain dots '.' where dots can be matched with any letter.

    Example:
    Input:
    ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
    [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
    Output:
    [null,null,null,null,false,true,true,true]

    Explanation:
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    wordDictionary.search("pad"); // return False
    wordDictionary.search("bad"); // return True
    wordDictionary.search(".ad"); // return True
    wordDictionary.search("b.."); // return True

    Constraints:
        1 <= word.length <= 500
        word in addWord consists lower-case English letters.
        word in search consist of  '.' or lower-case English letters.
        At most 50000 calls will be made to addWord and search.
     */

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */

    //Each letter in the dictionary can have an array of other letters as children since added words are branches in a trie
    public class TrieNode {
        public static final int R = 26;      //alphabet size
        public Integer value;
        public TrieNode[] children = new TrieNode[R];
    }

    class WordDictionary {
        TrieNode root;
        Integer val;

        //Initialize empty trie
        public WordDictionary() {
            root = new TrieNode();
            val = 0;
        }

        //Adds a word to the dictionary
        public void addWord(String word) {
            //node used to traverse the trie to add the letters of the word
            TrieNode iter = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                //if the current letter does not exist in the trie dictionary, make a new node for it
                if (iter.children[c - 'a'] == null) {
                    iter.children[c - 'a'] = new TrieNode();
                }

                //move to the next, or newly created node c
                iter = iter.children[c - 'a'];
            }

            //once a word is added, give the last node a value which marks the end of an entry
            iter.value = val++;
        }

        public boolean search(String word) {
            return match(root, new StringBuilder(), word);
        }

        private boolean match(TrieNode node, StringBuilder sb, String word) {
            //if the current character node does not exist in the trie
            if (node == null) {
                return false;
            }

            //if the created string matches the length of the word and the node has a value, word entry exists in the trie
            if (sb.length() == word.length() && node.value != null) {
                return true;
            }

            //we don't care for any entries greater in length than "word"
            if (sb.length() == word.length()) {
                return false;
            }

            //the next character in word
            char c = word.charAt(sb.length());

            if (c == '.') {
                //if c == ., it can be any character so we append all possible characters in the alphabet
                for (char ch = 0; ch < TrieNode.R; ch++) {
                    sb.append(ch);
                    if (match(node.children[ch], sb, word)) {
                        return true;
                    }
                    sb.setLength(sb.length() - 1);  //backtrack
                }
            } else {
                //if c != ., we append the character c to the current string sb
                sb.append(c);
                if (match(node.children[c - 'a'], sb, word)) {
                    return true;
                }
                sb.setLength(sb.length() - 1);  //backtrack
            }
            return false;
        }
    }
}
