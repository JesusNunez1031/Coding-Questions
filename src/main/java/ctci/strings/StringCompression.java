package ctci.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringCompression {

    public static HashMap<Character, Integer> map = new HashMap<>();

    public static void strCompress(String str) {
        char[] letters = str.toCharArray();

        for(char i : letters) {
            Integer value = map.getOrDefault(i, 1);
            if(map.containsKey(i)){
                map.put(i, value++);
            }
            map.put(i, value);
        }
    }

    public static StringBuilder getCompressedString(HashMap<Character, Integer> map){
        StringBuilder str = new StringBuilder();
        Iterator it = map.entrySet().iterator();

        // iterate through the hashmap
        while(it.hasNext()) {
            // Focus on the values for the current index of the hashmap
            Map.Entry pair = (Map.Entry)it.next();
            //Create the final string
            str.append(pair.getKey()).append(pair.getValue());
            it.remove();
        }
        return str;
    }

    public static void main(String[] args) {
        strCompress("aabccccccaaa");
        System.out.print(getCompressedString(map));
    }
}
