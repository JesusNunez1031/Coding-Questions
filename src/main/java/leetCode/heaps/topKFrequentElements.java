package leetCode.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequentElements {
    /*
    Given a non-empty array of integers, return the k most frequent elements.

    Example 1:
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]

    Example 2:
    Input: nums = [1], k = 1
    Output: [1]

    Note:
        You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
        Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
        It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
        You can return the answer in any order.
     */

    //TC: O(n log k) and O(n + k) space used for the map and PQ
    private int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        //minheap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        //add all the values in nums and their frequency to the map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        /*
            keep the top elements in the heap by removing elements once the size exceeds k, n log k time, the top most
            elements in the heap will be the values who's frequency is the smallest in nums
         */
        for (int val : map.keySet()) {
            heap.add(val);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.remove();
        }
        return result;
    }

    //TC:O(n log n)
    public int[] topKFrequentEz(int[] nums, int k) {
        //holds a key-value pair where the key is a num in nums and value is the frequency of num in nums
        Map<Integer, Integer> map = new HashMap<>();

        //maxHeap of map entries, the entries at the top are values with highest frequencies
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        //add the frequency of each value to the map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //add all the entries in the map to the heap, the top most entries in the heap will be the most frequent values
        heap.addAll(map.entrySet());

        //add the first k highest frequencies to the result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.remove().getKey();
        }
        return result;
    }
}
