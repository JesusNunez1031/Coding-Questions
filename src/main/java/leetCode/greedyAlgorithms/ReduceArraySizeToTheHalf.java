package leetCode.greedyAlgorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeToTheHalf {
    /*
    Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.

    Return the minimum size of the set so that at least half of the integers of the array are removed.

    Example 1:
    Input: arr = [3,3,3,3,5,5,5,2,2,7]
    Output: 2
    Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
    Possible sets of size 2 are {3,5},{3,2},{5,2}.
    Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.

    Example 2:
    Input: arr = [7,7,7,7,7,7]
    Output: 1
    Explanation: The only possible set you can choose is {7}. This will make the new array empty.

    Example 3:
    Input: arr = [1,9]
    Output: 1

    Example 4:
    Input: arr = [1000,1000,3,7]
    Output: 1

    Example 5:
    Input: arr = [1,2,3,4,5,6,7,8,9,10]
    Output: 5

    Constraints:
        1 <= arr.length <= 10^5
        arr.length is even.
        1 <= arr[i] <= 10^5
     */

    //TC: O(n * log n) where n is the number of values in arr
    public int minSetSize(int[] arr) {
        int n = arr.length;

        //organize the frequency of each value in arra into a map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //sort the values in arr in descending order by adding them to a max heap so the values with the highest frequency are on top
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        heap.addAll(map.entrySet());

        int minSize = 0; //number of unique values removed from arr to make the size half
        int currSize = n; // the size of the array

        /*
            for each value in the heap starting with the one with the highest frequency, remove its frequency from the
            size of the array, if the size of the array is less than half the original size, we cant remove no more values
            so we return minSize, otherwise, remove values while we still have a current size greater than half of arr
         */
        while (!heap.isEmpty() && currSize > n / 2) {
            currSize -= heap.remove().getValue();
            minSize++;
        }
        return minSize;
    }

    //TC: O(n * log n) where n is the number of values in arr using optimized space
    public int minSetSizeEz(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        //look for the largest value in arr, this will determine the size of the frequency array so we have an upperbound
        for(int num : arr) {
            if(num > max) {
                max = num;
            }
        }

        //calculate the frequency of each value in arr
        int[] freq = new int[max + 1];
        for (int num : arr) {
            freq[num]++;
        }

        //sort the frequency array
        Arrays.sort(freq);

        int minSize = 0; //number of unique values removed from arr to make the size half
        int currSize = n; // the size of the array

        //starting from the value with the highest frequency, remove values until the current size is < than n/2
        for(int i = max;i >= 0 && currSize > n / 2;i--) {
            /*
                if a value has a higher frequency than half the size of the array, we only need to remove this value to
                satisfy the conditions
             */
            if(freq[i] >= n / 2) {
                return 1;
            }
            //reduce the current size of the array by the removed value and increase the number of values removed
            currSize -= freq[i];
            minSize++;
        }
        return minSize;
    }
}
