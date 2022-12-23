package leetCode.twoDimentionArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class wordSearchII {
    /*
    Given an m x n board of characters and a list of strings words, return all words on the board.

    Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
    vertically neighboring. The same letter cell may not be used more than once in a word.

    Example 1:
    Input: board = [["o","a","a","n"],
                    ["e","t","a","e"],
                    ["i","h","k","r"],
                    ["i","f","l","v"]], words = ["oath","pea","eat","rain"]
    Output: ["eat","oath"]

    Example 2:
    Input: board = [["a","b"],
                    ["c","d"]], words = ["abcb"]
    Output: []

    Constraints:
        m == board.length
        n == board[i].length
        1 <= m, n <= 12
        board[i][j] is a lowercase English letter.
        1 <= words.length <= 3 * 104
        1 <= words[i].length <= 10
        words[i] consists of lowercase English letters.
        All the strings of words are unique.
     */
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new TrieNode();
                }

                node = node.child[c - 'a'];
            }

            node.word = word;
        }

        public TrieNode getRoot() {
            return this.root;
        }
    }

    //TC: O((n*m) * (n*m))
    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0 || board == null || board.length == 0) {
            return Collections.emptyList();
        }

        List<String> foundWords = new ArrayList<>();
        Trie trie = new Trie();

        // populate Trie
        for (String word : words) {
            trie.insert(word);
        }

        // iterate through board and search for dictionary words
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                searchBoard(board, trie.getRoot(), i, j, foundWords);

                // stop the search if all words were found
                if (foundWords.size() == words.length) {
                    break;
                }
            }
        }
        return foundWords;
    }

    private void searchBoard(char[][] board, TrieNode root, int i, int j, List<String> foundWords) {
        /*
            check bounds and conditions, i.e. backtrack when we are on an already visited cell or the letter does not
            exist in the current trie path taken
         */
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '#' || root.child[board[i][j] - 'a'] == null) {
            return;
        }

        // move to the next letter in trie path
        root = root.child[board[i][j] - 'a'];

        // If the node has a word set, it's the end of a dictionary word added, so we want to add it to list
        if (root.word != null) {
            foundWords.add(root.word);
            root.word = null; // erase reference to avoid adding duplicates
        }

        // save reference of current letter and "delete" it, so it can't be re-used
        char letter = board[i][j];
        board[i][j] = '#';

        // search in all directions
        searchBoard(board, root, i - 1, j, foundWords); // up
        searchBoard(board, root, i + 1, j, foundWords); // down
        searchBoard(board, root, i, j + 1, foundWords); // right
        searchBoard(board, root, i, j - 1, foundWords); // left

        board[i][j] = letter; // reset letter
    }
}
