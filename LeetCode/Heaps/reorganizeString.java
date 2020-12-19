import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class reorganizeString {
    /*
    Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
    If possible, output any possible result.  If not possible, return the empty string.

    Example 1:
    Input: S = "aab"
    Output: "aba"

    Example 2:
    Input: S = "aaab"
    Output: ""

    Note:
        S will consist of lowercase letters and have length in range [1, 500].
     */
    //TC: O(n log A) where n is the length of s and A is the size of alphabet and O(A) space
    private String reorganizeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        //add the frequency of each character into a HM
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            /*
                if the frequency of a character is greater than half the length of the string, there will not be enough
                remaining characters to reorganize s with
             */
            if (map.containsKey(c) && map.get(c) > (s.length() + 1) / 2) {
                return "";
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //add all the characters into the max heap ordered by their frequency
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        heap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();

        /*
            append characters to the resulting string by the top two most frequent characters, we only loop while we
            have at least 2 characters in the heap, we will break out when only one character remains in the heap
         */
        while (heap.size() >= 2) {
            char first = heap.remove();
            char second = heap.remove();

            sb.append(first).append(second);

            //reduce the count of each of the characters by 1 in the map
            map.put(first, map.get(first) - 1);
            map.put(second, map.get(second) - 1);

            //we add the character back to the heap only if its frequency count is greater than 0
            if (map.get(first) > 0) {
                heap.add(first);
            }
            if (map.get(second) > 0) {
                heap.add(second);
            }
        }

        /*
            if the heap is not empty, check if the remaining character has a count less than 2, otherwise return the
            empty string since we have no more characters to alternate it with
         */
        if (!heap.isEmpty()) {
            char c = heap.remove();
            if (map.get(c) == 1) {
                sb.append(c);
            } else {
                return "";
            }
        }
        return sb.toString();
    }
}
