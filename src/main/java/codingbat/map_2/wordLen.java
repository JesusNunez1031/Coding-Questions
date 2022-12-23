package codingbat.map_2;

import java.util.HashMap;
import java.util.Map;

public class wordLen {
    /*
    Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, and the value is that string's length.

    codingbat.map_2.wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
    codingbat.map_2.wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
    codingbat.map_2.wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}
     */

    public Map<String, Integer> wordLen(String[] strings) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String string : strings) {
            if (!map.containsKey(string)) {
                map.put(string, string.length());
            }
        }
        return map;
    }
}
