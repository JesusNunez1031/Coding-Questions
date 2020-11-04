import java.util.HashMap;
import java.util.Map;

public class firstUniqueCharacterInString {

    //Method 1 using a hashmap takes O(n) time, however, given a large string, this can take alot of time since we add all characters to the map
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    //Faster approach using just an array to hold the number of times a character shows up in a string
    public int firstUniqCharNoMap(String s) {
        //Set size to 26, the length of the alphabet
        int[] chars = new int[26];

        //Iterate through the string and increase the number of times a character shows up in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c - 'a']++;
        }

        //Return the index of the first character in s that has its count set to 1
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
//    public int firstUniqChar(String s) {
//        int[] freq = new int[128];
//        for(int c : s.toCharArray()) {
//            freq[c]++;
//        }
//
//        for(int i = 0; i < s.length();i++){
//            int c = s.charAt(i);
//            if(freq[c] == 1) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
