import java.util.HashMap;
import java.util.Map;

public class findWordsThatCanBeFormedByCharacters {
    /*
        You are given an array of strings words and a string chars.
        A string is good if it can be formed by characters from chars (each character can only be used once).
        Return the sum of lengths of all good strings in words.

        Example 1:
        Input: words = ["cat","bt","hat","tree"], chars = "atach"
        Output: 6
        Explanation:
        The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

        Example 2:
        Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
        Output: 10
        Explanation:
        The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
     */
    public int countCharacters(String[] words, String chars) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int ans = 0;

        for (String word : words) {
            boolean valid = true;
            Map<Character, Integer> copy = new HashMap<>(map);

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);

                if (copy.containsKey(c) && copy.get(c) > 0) {
                    copy.put(c, copy.get(c) - 1);
                } else {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                ans += word.length();
            }
        }
        return ans;
    }
}
