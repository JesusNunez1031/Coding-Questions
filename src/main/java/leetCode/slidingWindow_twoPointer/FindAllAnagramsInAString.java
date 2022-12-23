package leetCode.slidingWindow_twoPointer;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    /*
    Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer
    in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
    the original letters exactly once.

    Example 1:
    Input: s = "cbaebabacd", p = "abc"
    Output: [0,6]
    Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".

    Example 2:
    Input: s = "abab", p = "ab"
    Output: [0,1,2]
    Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".

    Constraints:
        1 <= s.length, p.length <= 3 * 104
        s and p consist of lowercase English letters.
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexes = new ArrayList<>();

        int[] freq = new int[26]; // frequency array of all characters in p
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int len = p.length(); // number of characters in p

        while (right < s.length()) {
            /*
                decrease the len by one if the current characters' frequency is not yet 0 after reducing it by 1 and
                continue to expand the window
             */
            if (freq[s.charAt(right++) - 'a']-- >= 1) {
                len--; // once less character
            }

            /*
                when len == 0, the current windows' characters match the characters in p, i.e. make an anagram so add
                the start to the indexes array
             */
            if (len == 0) {
                indexes.add(left);
            }

            /*
                if the current window is larger than p, reduce it from the left and add the count of the frequency of
                the character back to the frequency array as well as increase the len to reflect that we need more characters
             */
            if (right - left == p.length() && freq[s.charAt(left++) - 'a']++ >= 0) {
                len++;
            }
        }
        return indexes;
    }
}
