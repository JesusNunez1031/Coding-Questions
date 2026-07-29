package leetCode.strings;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    /*
        Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

        Example 1:
        Input: words = ["bella","label","roller"]
        Output: ["e","l","l"]

        Example 2:
        Input: words = ["cool","lock","cook"]
        Output: ["c","o"]

        Constraints:
            1 <= words.length <= 100
            1 <= words[i].length <= 100
            words[i] consists of lowercase English letters.
     */
    // TC: O(n)
    public List<String> commonChars(String[] words) {
        int[] freq = getFreq(words[0]); // generate the core frequency array from the first word

        // update count by intersecting each word with freq array
        for (int i = 1; i < words.length; i++) {
            freq = intersect(freq, getFreq(words[i]));
        }

        List<String> commonChars = new ArrayList<>();
        // for each remaining character count, append the character to the result list since these are
        // the characters that appeared in every word
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                char a = (char) ('a' + i);
                String s = String.valueOf(a);
                while (freq[i] > 0) {
                    commonChars.add(s);
                    freq[i]--;
                }
            }
        }
        return commonChars;
    }

    // compares a and b and returns the intersection of the two frequency arrays
    private int[] intersect(int[] a, int[] b) {
        int[] inter = new int[26];
        for (int i = 0; i < 26; i++) {
            inter[i] = Math.min(a[i], b[i]);
        }
        return inter;
    }

    // returns a frequency array for s
    private int[] getFreq(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
