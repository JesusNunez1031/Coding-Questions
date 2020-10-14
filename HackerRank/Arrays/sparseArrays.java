import java.util.HashMap;

public class sparseArrays {
    static int[] matchingStrings(String[] strings, String[] queries) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            String key = strings[i];
            if (!(map.containsKey(key))) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String key = queries[i];
            if (map.containsKey(key)) {
                result[i] = map.get(key);
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
}
