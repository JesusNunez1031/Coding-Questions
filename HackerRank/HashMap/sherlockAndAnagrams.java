import java.util.Arrays;
import java.util.HashMap;

public class sherlockAndAnagrams {
    static int sherlockAndAnagrams(String s) {
        //HM to store all the anagrams
        HashMap<String, Integer> map = new HashMap<>();

        //Get all the anagrams of the string s, sort it so we can add them to map
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char[] c = s.substring(i, j + 1).toCharArray();
                Arrays.sort(c);
                String k = new String(c);

                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 1);
                }
            }
        }

        int anagramPairs = 0;
        //loop through keys in map and calculate anagram value using combination formula simplified which gives us the number of permutations of n objects
        for (String str : map.keySet()) {
            int val = map.get(str);
            anagramPairs += (val * (val - 1)) / 2;
        }

        return anagramPairs;
    }
}
