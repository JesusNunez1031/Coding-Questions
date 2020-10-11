import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    /*
        Given a string s, find the length of the longest substring without repeating characters.

        Ex:
            Input: s = "abcabcbb"
            Output: 3
            Explanation: The answer is "abc", with the length of 3.

        Sliding window problem where we have two pointers and slide one right while we keep one behind. If we encounter a duplicate character,
        then we remove it from our set and slide our other pointer right by one so as more unique characters show up, the window expands

        O(n) time space O(min(n, m)) n being the length of the string and m being the size of alphabet
    */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0, ans = 0;

        HashSet<Character> set = new HashSet<>();

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                //Compare current max with the size of set since it holds all the unique characters
                ans = Math.max(ans, set.size());
            } else {
                //If the current character is not unique, we remove it from the set and move left window pointer by 1 to the right giving us our new unique substring
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
