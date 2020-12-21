import java.util.*;

public class groupAnagrams {
    /*
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Example 1:
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    Example 2:
    Input: strs = [""]
    Output: [[""]]

    Example 3:
    Input: strs = ["a"]
    Output: [["a"]]

    Constraints:
        1 <= strs.length <= 10^4
        0 <= strs[i].length <= 100
        strs[i] consists of lower-case English letters.
     */
    /*
        TC: O(n * k log k) where n is the length of the strs array and k is the length of the largest string in strs, we
        sort every string in strs and that takes k log k time hence n * k log k
     */
    private List<List<String>> groupAnagrams(String[] strs) {
        //HashMap to hold the lists of similar anagrams, the key is the sorted anagram
        Map<String, List<String>> map = new HashMap<>();

        /*
            for every anagram in strs, sort it, check if the map contains its sorted version and if it does add the
            original anagram to the list of its sorted version
        */
        for (String str : strs) {
            //convert the str into a character arrays so we can sort it
            char[] str_array = str.toCharArray();
            Arrays.sort(str_array);
            //convert the character array back to a string
            String sorted_str = String.valueOf(str_array);

            //if the map does not contain the current anagram, make a new entry and list for it
            if (!map.containsKey(sorted_str)) {
                map.put(sorted_str, new ArrayList<>());
            }

            //add the original string to the sorted_str version in the map so all alike anagrams are together
            map.get(sorted_str).add(str);
        }

        //add all the lists of anagrams to the anagrams array
        return new ArrayList<>(map.values());
    }
}
