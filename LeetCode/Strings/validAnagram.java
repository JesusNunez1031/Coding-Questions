public class validAnagram {
    /*
    Given two strings s and t , write a function to determine if t is an anagram of s.

    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:
    Input: s = "rat", t = "car"
    Output: false

    Note:
    You may assume the string contains only lowercase alphabets.
    Follow up:
        What if the inputs contain unicode characters? How would you adapt your solution to such case?
     */
    //TC: O(n) and O(n) space since we store all of s characters into an array
    public static boolean isAnagram(String s, String t) {
        //if the lengths of s and t don't match, there is no way the pair can be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[128];

        //store the frequency of each character of s into an array, convert character c to int
        for (int c : s.toCharArray()) {
            freq[c]++;
        }

        /*
            if any character j in t has a higher frequency than that of s, e.g. freq[j] == 0 for a character j, the
            strings are not anagrams
         */
        for (int j : t.toCharArray()) {
            if (freq[j] == 0) {
                return false;
            } else {
                freq[j]--;
            }
        }
        return true;
    }
}
