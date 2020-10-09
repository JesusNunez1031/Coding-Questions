import java.util.HashMap;
import java.util.Map;

public class wordMultiple {
    /*
    Given an array of strings, return a Map<String, Boolean> where each different string is a key and its value is true if that string appears 2 or more times in the array.

    wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
    wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
    wordMultiple(["c", "c", "c", "c"]) → {"c": true}
     */

    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();

        for(String str : strings) {
            if(!map.containsKey(str)){
                map.put(str, false);
            }
            else {
                map.put(str, true);
            }
        }
        return map;
    }
}
