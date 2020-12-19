import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class sortCharactersByFrequency {
    /*
    Given a string, sort it in decreasing order based on the frequency of characters.

    Example 1:
    Input: "tree"
    Output: "eert"
    Explanation:
    'e' appears twice while 'r' and 't' both appear once.
    So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

    Example 2:
    Input: "cccaaa"
    Output: "cccaaa"
    Explanation:
    Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
    Note that "cacaca" is incorrect, as the same characters must be together.

    Example 3:
    Input: "Aabb"
    Output: "bbAa"
    Explanation:
    "bbaA" is also a valid answer, but "Aabb" is incorrect.
    Note that 'A' and 'a' are treated as two different characters.
     */

    /* O(n log n) solution using a HM and a Heap PQ and O(n) space
        O(N) to construct map
        O(c log c) to construct heap, where c is the number of distinct characters in s, worst case n==k
        meaning all the characters in s are unique hence O(c log c) [same applies to the removal]
     */
    public static String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();

        //get the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //Turn the PQ to a max heap
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b).compareTo(map.get(a)));

        //Add the characters to the max heap
        maxHeap.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char c = maxHeap.remove();
            int count = map.get(c);
            //Add the character the number of times it appears in string
            while (count-- != 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // O(s * n) where s is the number of unique characters in String s, worst case n^2 if all characters are unique
    public static String frequencySortEz(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        //char array to hold frequency of characters
        int[] freq = new int[128];

        //store the highest index value to avoid iteration of entire array if possible
        int maxIndex = -1;

        for (int c : s.toCharArray()) {
            if (c > maxIndex) {
                maxIndex = c;
            }
            freq[c]++;
        }

        while (sb.length() != s.length()) {
            //get the index of the character with the highest frequency
            int index = getMax(freq, maxIndex);

            //append the character the number of times it appears in the string
            while (freq[index]-- != 0) {
                sb.append((char) index);
            }
        }
        return sb.toString();
    }

    //Method the get the index with the highest value in the frequency array
    public static int getMax(int[] freq, int range) {
        int max = -1, index = 0;
        for (int i = 0; i <= range; i++) {
            if (freq[i] > max) {
                max = freq[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySort(s));

    }
}
