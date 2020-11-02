import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class patternMatching {
    /*
    Given a set of strings words and a string pattern return a list of all of the strings in words that matches the pattern of the pattern string.

    Example 1:
    Input:
    words = ["aa", "bb"]
    pattern = "cc"
    Output: ["aa", "bb"]
    Explanation: Both strings repeat letters just as the pattern string does.

    Example 2:
    Input:
    words = ["aac", "bbc", "bcb", "yzy"]
    pattern = "ghg"
    Output: ["bcb", "yzy"]

    Example 3:
    Input:
    words = ["aa", "bb"]
    pattern = "zy"
    Output: []
     */

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();

        for (String str : words) {
            if (checkIfValid(str, pattern)) {
                list.add(str);
            }
        }
        return list;
    }

    public static boolean checkIfValid(String str, String pattern) {
        if (str.length() != pattern.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            char p = pattern.charAt(i);
            if (!map.containsKey(s)) {
                map.put(s, p);
            } else {
                if (map.get(s) != p) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"zrkr", "kxkx", "adcd", "topo"};
        String pattern = "baca";

        System.out.println(findAndReplacePattern(words, pattern).toString());
    }
}
