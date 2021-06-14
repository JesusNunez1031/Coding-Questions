import java.util.*;

public class PalindromePairs {
    /*
    Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the
    concatenation of the two words words[i] + words[j] is a palindrome.

    Example 1:
    Input: words = ["abcd","dcba","lls","s","sssll"]
    Output: [[0,1],[1,0],[3,2],[2,4]]
    Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

    Example 2:
    Input: words = ["bat","tab","cat"]
    Output: [[0,1],[1,0]]
    Explanation: The palindromes are ["battab","tabbat"]

    Example 3:
    Input: words = ["a",""]
    Output: [[0,1],[1,0]]

    Constraints:
        1 <= words.length <= 5000
        0 <= words[i].length <= 300
        words[i] consists of lower-case English letters.
     */
    //TC: O(n * k^2) where n is the number of words and k is the average length of words
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();

        //map of all words given and the index where they are present
        Map<String, Integer> map = new HashMap<>();

        //add all the words into the map with their respective indexes
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        //if there is an empty string in words, any word it gets matched with can be a palindrome pair if the other word is already a palindrome
        if (map.containsKey("")) {
            int emptyIndex = map.get("");

            //search for other words that are already palindromes and not the same index of ""
            for (int i = 0; i < words.length; i++) {
                if (i != emptyIndex && isPalindrome(words[i])) {
                    pairs.add(Arrays.asList(emptyIndex, i));
                    pairs.add(Arrays.asList(i, emptyIndex));
                }
            }
        }

        // search through the words and check if the reflection of a word exists
        for (int i = 0; i < words.length; i++) {
            String reflection = new StringBuilder(words[i]).reverse().toString();
            Integer refIndex = map.get(reflection);
            if (refIndex != null && refIndex != i) {
                pairs.add(Arrays.asList(i, refIndex));
            }
        }

        /*
            iterate through the rest of the words and for each word, check if there are palindrome substrings using the
            left and right division of the word
         */
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            for (int j = 1; j < curr.length(); j++) {
                String left = curr.substring(0, j);
                String right = curr.substring(j);
                if (isPalindrome(left)) {
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(reversedRight)) {
                        pairs.add(Arrays.asList(map.get(reversedRight), i));
                    }
                }
                if (isPalindrome(right)) {
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(reversedLeft)) {
                        pairs.add(Arrays.asList(i, map.get(reversedLeft)));
                    }
                }
            }
        }
        return pairs;
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    //****************************************************************************************************************//
    static class Trie {
        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            int index = -1;
            /*
                holds the indexes of the word that is the reverse of the current observed word
                e.g. given ["abcd", "dcba", "lls", "s", "sssll"]
                - if abcd has been added to the trie, its final node d, will have the index where the word is found which is
                  0 and a list will be made in d since it is a palindrome.

                - When dcba is added, a will have index of 1 and a list with value 1

                - when we search for a pair for dcba, abcd will be searched for since we start from the end of the string.
                  on the last character d, we will find a pair since d is a palindrome and since the index of node d is
                  not -1, this means a previous word ended in this character aswell indicating the reverse was found.
             */
            List<Integer> palindromes = null;
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word, int index) {
            TrieNode iter = root;
            int n = word.length();
            int i = 0;

            while (i < n) {
                //check if the substring from i to n - 1 in word is a palindrome
                if (isPalindrome(word, i, n - 1)) {
                    if (iter.palindromes == null) {
                        iter.palindromes = new ArrayList<>();
                    }
                    /*
                        if the substring is a palindrome, add the index of word to the list of palindromes for the
                        current node "iter".
                    */
                    iter.palindromes.add(index);
                }

                char ch = word.charAt(i);
                if (iter.children[ch - 'a'] == null) {
                    iter.children[ch - 'a'] = new TrieNode();
                }

                iter = iter.children[ch - 'a'];
                i++;
            }

            //set the index of the last character node to the index to indicate the words end
            iter.index = index;
        }

        public void find(String word, int index, List<List<Integer>> pairs) {
            TrieNode iter = root;
            int n = word.length();

            /*
                search the trie for the reverse of the current word, if the reverse exists, the index of iter will not
                be -1 and the substring from 0 to i will be a palindrome
             */
            for (int i = n - 1; i >= 0; i--) {
                if (iter.index != -1 && isPalindrome(word, 0, i)) {
                    pairs.add(Arrays.asList(iter.index, index));
                }

                //if the current character does not exit, there is no point in searching the rest of the word
                iter = iter.children[word.charAt(i) - 'a'];
                if (iter == null) {
                    return;
                }
            }

            /*
                if the last checked node iter has a list of palindromes, check the list of reversed words inside word
                that are palindromes and add them to the list
             */
            if (iter.palindromes != null) {
                for (Integer indx : iter.palindromes) {
                    pairs.add(Arrays.asList(indx, index));
                }
            }

            //if the complete reverse of word is present and its not at the same index of the current word, another pair was found
            if (iter.index != -1 && iter.index != index) {
                pairs.add(Arrays.asList(iter.index, index));
            }
        }

        private boolean isPalindrome(String word, int left, int right) {
            while (left < right && word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            }
            return left >= right;
        }
    }

    //TC: O(n * k^2) where k is the average length of words in array and n is the number of words in words
    public static List<List<Integer>> palindromePairsTrie(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();

        Trie trie = new Trie();

        for (int i = 0; i < words.length; i++) {
            trie.addWord(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            trie.find(words[i], i, pairs);
        }
        return pairs;
    }

    public static void main(String[] args) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        palindromePairsTrie(words);
    }
}
