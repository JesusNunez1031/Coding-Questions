import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class isomorphicStrings {
    /*
    Given two strings s and t, determine if they are isomorphic.
    Two strings are isomorphic if the characters in s can be replaced to get t.
    All occurrences of a character must be replaced with another character while preserving the order of characters. No
    two characters may map to the same character but a character may map to itself.

    Example 1:
    Input: s = "egg", t = "add"
    Output: true

    Example 2:
    Input: s = "foo", t = "bar"
    Output: false

    Example 3:
    Input: s = "paper", t = "title"
    Output: true
        Note:
        You may assume both s and t have the same length.
     */
    //TC:O(n) time and space
    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        //Arrays to hold the indexes of each character in s and t
        int[] s_chars = new int[128];
        int[] t_chars = new int[128];

        /*
            Fill the arrays with an invalid index value of -1 to avoid false positives
            Ex: s = ab, t = aa
            if all values in the array are the default 0, then at the first iteration s_chars[a] = 0 & t_chars[a] = 0
            then when we get to b and a, both will be seen as having the same index since t_chars[b] = 0 by default which
            would return true when it should return false since we don't have a last seen index of b
         */

        Arrays.fill(s_chars, -1);
        Arrays.fill(t_chars, -1);

        /*
            For each character in s and t, we check the last index where the current character was seen, if the indexes
            don't match, that means the order of the characters is different therefore s and t are not isomorphic, otherwise
            we update the index of the current characters in their respective arrays
         */
        for (int i = 0; i < s.length(); i++) {
            char s_char = s.charAt(i);
            char t_char = t.charAt(i);

            if (s_chars[s_char] != t_chars[t_char]) {
                return false;
            }
            s_chars[s_char] = i;
            t_chars[t_char] = i;
        }
        return true;
    }

    //Hashmap solution saving the previous index of O(n) time and space used
    private boolean isIsomorphicMap(String s, String t) {

        Map<Character, Character> map = new HashMap<>();

        /*
            for every character s, we add the current character t[i] into the map as the value of s. If the map has t[i]
            and its not mapped to s[i], then we return false as the orders of the characters don't match. Also If the
            current character in s is in the map but its value isn't the character t[i], the order doesnt match so we
            return false
         */
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
            } else if (map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
