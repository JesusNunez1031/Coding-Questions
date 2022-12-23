package leetCode.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class binaryTreesWithFactors {
    /*
    Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

    We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's
    value should be equal to the product of the values of its children.

    Return the number of binary trees we can make. The answer may be too large so return the answer modulo 10^9 + 7.

    Example 1:
    Input: arr = [2,4]
    Output: 3
    Explanation: We can make these trees: [2], [4], [4, 2, 2]

    Example 2:
    Input: arr = [2,4,5,10]
    Output: 7
    Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].

    Constraints:
        1 <= arr.length <= 1000
        2 <= arr[i] <= 10^9
     */
    //TC: O(n^2)
    public int numFactoredBinaryTrees(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        //sort the values so we can check smallest factors first
        Arrays.sort(arr);

        //map to hold the number of ways we can make ith value in the array, key -> ith value, value -> # of factors
        Map<Integer, Long> map = new HashMap<>();

        //for each value in array, check how many values from the start factor into arr[i]
        for (int i = 0; i < arr.length; i++) {
            long count = 1;    //number of ways arr[i] can be factored
            //check if any value before ith value are factors of arr[i]
            for (int j = 0; j < i; j++) {
                /*
                    if arr[i] is divisible by arr[j] and the value arr[i] / arr[j] exists, add to the count of factors
                    all the factors of arr[j] and arr[i] / arr[j]
                 */
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    count += map.get(arr[j]) * map.get(arr[i] / arr[j]);
                }
            }
            //place arr[i] into the map with the number of factors it has
            map.put(arr[i], count);
        }

        //add up all the factors for each value in the map
        long total_count = 0;
        for (Long factors : map.values()) {
            total_count += factors;
        }

        //return the total count mod 10^9 + 7 since the value may be large
        return (int) (total_count % ((int) 1e9 + 7));
    }
}
