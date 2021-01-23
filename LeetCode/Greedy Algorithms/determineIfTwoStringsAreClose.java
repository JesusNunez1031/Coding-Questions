import java.util.HashMap;
import java.util.Map;

public class determineIfTwoStringsAreClose {
    /*
    Two strings are considered close if you can attain one from the other using the following operations:
        - Operation 1: Swap any two existing characters.
            For example, abcde -> aecdb
        - Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
            For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)

    You can use the operations on either string as many times as necessary.

    Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

    Example 1:
    Input: word1 = "abc", word2 = "bca"
    Output: true
    Explanation: You can attain word2 from word1 in 2 operations.
    Apply Operation 1: "abc" -> "acb"
    Apply Operation 1: "acb" -> "bca"

    Example 2:
    Input: word1 = "a", word2 = "aa"
    Output: false
    Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.

    Example 3:
    Input: word1 = "cabbba", word2 = "abbccc"
    Output: true
    Explanation: You can attain word2 from word1 in 3 operations.
    Apply Operation 1: "cabbba" -> "caabbb"
    Apply Operation 2: "caabbb" -> "baaccc"
    Apply Operation 2: "baaccc" -> "abbccc"

    Example 4:
    Input: word1 = "cabbba", word2 = "aabbss"
    Output: false
    Explanation: It is impossible to attain word2 from word1, or vice versa, in any amount of operations.


    Constraints:
        1 <= word1.length, word2.length <= 10^5
        word1 and word2 contain only lowercase English letters.
     */
    //TC:O(n) and constant space since at most we only store 26 frequencies
    private boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        //frequency arrays for word1 and word2 letters
        int[] w1 = new int[26];
        int[] w2 = new int[26];

        //add frequency of each letter to respective frequency array
        for (char c : word1.toCharArray()) {
            w1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            w2[c - 'a']++;
        }

        //check if all the characters in word1 are present in word2
        for (int i = 0; i < 26; i++) {
            if (w1[i] == 0 && w2[i] != 0 || w1[i] != 0 && w2[i] == 0) {
                return false;
            }
        }

        //now that we know both words have the same letters, we need to compare the frequencies
        Map<Integer, Integer> map = new HashMap<>();

        //use the frequency of the letter as key and its value is how many times is shows up
        for (int freq : w1) {
            if (freq > 0) {
                map.put(freq, map.getOrDefault(freq, 0) + 1);
            }
        }

        /*
            look through the frequencies in word2, if the current frequency doesnt exists in the map, return false, otherwise,
            reduce its count by 1, when it reaches 0, remove the key from the map
         */
        for (int freq : w2) {
            if (freq > 0) {
                //if the freq of ith letter does not exits in the map, the words wont match
                if (!map.containsKey(freq)) {
                    return false;
                }

                map.put(freq, map.get(freq) - 1);
                if (map.get(freq) == 0) {
                    map.remove(freq);
                }
            }
        }
        //if the map is empty, all letters match from w1 and w2
        return map.size() == 0;
    }
    /*                  Alternate method to check that the frequencies are the same
        //now that we know both words have the same letters, we need to compare the frequencies
        //Sort the frequency arrays and retun whether or not they are the same
        Arrays.sort(w1);
        Arrays.sort(w2);

        return Arrays.equals(w1, w2);
     */
}
