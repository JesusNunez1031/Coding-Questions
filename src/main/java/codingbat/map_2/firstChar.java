package codingbat.map_2;

import java.util.HashMap;
import java.util.Map;

public class firstChar {
    /*

    Given an array of non-empty strings, return a Map<String, String> with a key for every different first character seen,
    with the value of all the strings starting with that character appended together in the order they appear in the array.

    codingbat.map_2.firstChar(["salt", "tea", "soda", "toast"]) → {"s": "saltsoda", "t": "teatoast"}
    codingbat.map_2.firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) → {"a": "aaaAA", "b": "bb", "c": "cccCC", "d": "d"}
    codingbat.map_2.firstChar([]) → {}
     */

    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();

        for (String string : strings) {
            String key = string.substring(0,1);
            if (!map.containsKey(key)) {
                map.put(key, string);
            } else {
                map.put(key, map.get(key) + string);
            }
        }
        return map;
    }
}
