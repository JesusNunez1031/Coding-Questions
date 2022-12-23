package leetCode.slidingWindow_twoPointer;

import java.util.Collections;
import java.util.List;

public class longestWordInDictionaryThroughDeleting {
    /*
    Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting
    some characters of the given string. If there are more than one possible results, return the longest word with the
    smallest lexicographical order. If there is no possible result, return the empty string.
    Example 1:
    Input:
    s = "abpcplea", d = ["ale","apple","monkey","plea"]

    Output:
    "apple"
    Example 2:
    Input:
    s = "abpcplea", d = ["a","b","c"]

    Output:
    "a"
    Note:
    All the strings in the input will only contain lower-case letters.
    The size of the dictionary won't exceed 1,000.
    The length of all the strings in the input won't exceed 1,000.
     */
    //TC: O(nm + nm * log n) where n is the length of the list and m is the average length of each word in the list
    public String findLongestWord(String s, List<String> d) {
        //sort the dictionary so all words are in lexicographical order
        Collections.sort(d);
        String longest = "";

        /*
            for every word in the dictionary, check if the string is a subsequence of the string s, we'll know if it
            is if the word pointer, w_ptr, is the length of the current word
        */
        for (String word : d) {
            if (isSubsequence(s, word)) {
                //if the current word is a subsequence in S and its length is larger than the current longest, update longest
                if (word.length() > longest.length()) {
                    longest = word;
                }
            }
        }
        return longest;
    }

    //TC: O(n * m) where n is the length of dictionary and m is the average length if each word in the dictionary [No sorting]
    public String findLongestWordEz(String s, List<String> d) {
        String longest = "";
        /*
            for every word in the dictionary, check if the string is a subsequence of the string s, we'll know if it
            is if the word pointer, w_ptr, is the length of the current word
        */
        for (String word : d) {
            /*
                if the current word is a subsequence of S and its length is larger than the current longest or if the
                current word is of equal length to longest but lexicographically comes before longest, update longest
             */
            if (isSubsequence(s, word)) {
                if (word.length() > longest.length() || (word.length() == longest.length() && word.compareTo(longest) < 1)) {
                    longest = word;
                }
            }
        }
        return longest;
    }

    //Method returns true of "word" is a subsequence of s, false otherwise
    private boolean isSubsequence(String s, String word) {
        int s_ptr = 0, w_ptr = 0;
        while (w_ptr < word.length() && s_ptr < s.length()) {
            if (word.charAt(w_ptr) == s.charAt(s_ptr)) {
                w_ptr += 1;
                s_ptr += 1;
            } else {
                s_ptr++;
            }
        }
        return w_ptr == word.length();
    }
}
