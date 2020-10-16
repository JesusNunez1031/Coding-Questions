import java.util.HashMap;

public class twoStrings {
    /*
        Given two strings, determine if they share a common substring. A substring may be as small as one character.
        For example, the words "a", "and", "art" share the common substring a. The words "be" and "cat" do not share a substring.
     */

    static String twoStr(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        boolean flag = false;

        for (int i = 0; i < s1.length(); i++) {
            char let = s1.charAt(i);
            if (!(map.containsKey(let))) {
                map.put(let, 1);
            } else {
                map.put(let, map.get(let) + 1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char let = s2.charAt(i);
            if (map.containsKey(let)) {
                flag = true;
                break;
            }
        }
        return flag ? "YES" : "NO";
    }
}
