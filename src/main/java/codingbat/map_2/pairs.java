package codingbat.map_2;

import java.util.HashMap;
import java.util.Map;

public class pairs {
    /*

    Given an array of non-empty strings, create and return a Map<String, String> as follows: for each string add its first character as a key with its last character as the value.

    codingbat.map_2.pairs(["code", "bug"]) → {"b": "g", "c": "e"}
    codingbat.map_2.pairs(["man", "moon", "main"]) → {"m": "n"}
    codingbat.map_2.pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
     */

    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();

        for (String string : strings) {
            map.put(string.substring(0, 1), string.substring(string.length() - 1));
        }
        return map;
    }
}
