package leetCode.slidingWindow_twoPointer;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
        Given a string s, find the length of the longest substring without repeating characters.

        Example 1:
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.

        Example 2:
        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.

        Example 3:
        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

        Example 4:
        Input: s = ""
        Output: 0

        Constraints:
            0 <= s.length <= 5 * 104
            s consists of English letters, digits, symbols and spaces.

        Sliding window problem where we have two pointers and slide one right while we keep one behind. If we encounter
        a duplicate character, then we remove it from our set and slide our other pointer right by one so as more unique
        characters show up, the window expands

        TC/S: O(n) time space O(min(n, m)) n being the length of the string and m being the size of alphabet
    */
    private int lengthOfLongestSubstring(String s) {
        int n = s.length();
        //check for a valid string
        if (n == 0) {
            return 0;
        }
        //pointer to the start of the substring, "start", pointer to end of substring, "end", and variable to hold max length
        int start = 0, end = 0, longest = 0;

        //set to store substring of unique characters
        Set<Character> set = new HashSet<>();

        while (end < n) {
            //if the current character in s is not in the set, that means its not a repeated character
            if (!set.contains(s.charAt(end))) {
                //append the current character to the substring and increase the end pointer
                set.add(s.charAt(end++));

                //Compare current max with the size of set since it holds all the unique characters
                longest = Math.max(longest, set.size());
            } else {
                /*
                    if the current character is not unique, that means the character at the start is its duplicate since
                    we only add unique values, therefore we remove it from the substring and move start one step forward
                 */
                set.remove(s.charAt(start++));
            }
        }
        return longest;
    }

    //TC: O(n) and O(min(n, m)) n being the length of the string and m being the size of alphabet
    public int lengthOfLongestSubstringEz(String s) {
        int i = 0, j = 0; //window j: start | i: end
        int[] freq = new int[128];
        int longest = 0; //length of largest substring s with no repeating characters

        while (i < s.length()) {
            //add to the frequency of the new character at the end
            char c = s.charAt(i);
            freq[c]++;

            //reduce window if we've added a duplicate character to the sequence, i.e. current character count > 1
            while (freq[c] > 1) {
                freq[s.charAt(j++)]--;
            }

            //update longest if new window is larger in size
            if (longest < i - j + 1) {
                longest = i - j + 1;
            }

            //move to the next character
            i++;
        }
        return longest;
    }
}
