package leetCode.dfs_bfs_topologicalSort;

import java.util.*;

public class jumpGameIV {
    /*
    Given an array of integers arr, you are initially positioned at the first index of the array.
    In one step you can jump from index i to index:

    i + 1 where: i + 1 < arr.length.
    i - 1 where: i - 1 >= 0.
    j where: arr[i] == arr[j] and i != j.
    Return the minimum number of steps to reach the last index of the array.

    Notice that you can not jump outside of the array at any time.

    Example 1:
    Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
    Output: 3
    Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

    Example 2:
    Input: arr = [7]
    Output: 0
    Explanation: Start index is the last index. You don't need to jump.

    Example 3:
    Input: arr = [7,6,9,6,9,6,9,7]
    Output: 1
    Explanation: You can jump directly from index 0 to index 7 which is last index of the array.

    Example 4:
    Input: arr = [6,1,9]
    Output: 2

    Example 5:
    Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
    Output: 3

    Constraints:
        1 <= arr.length <= 5 * 10^4
        -10^8 <= arr[i] <= 10^8
     */
    //TC/S: O(n)
    private int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        //map to hold the values in the array and the indexes where they are located in
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            /*
                method checks if arr[i] exists in the map, if so, we add the current index to the list of indexes where
                arr[i] is present, otherwise we make a new entry for arr[i]
            */
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }

        //Queue to hold the indexes j we can jump to starting from 0
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);   //add the first index into the queue
        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int j = queue.remove(); //the current index

                //jump to j + 1
                if (j + 1 < n && map.containsKey(arr[j + 1])) {
                    if (j + 1 == n - 1) {
                        return steps;
                    }
                    queue.add(j + 1);
                }

                //jump to j - 1
                if (j - 1 >= 0 && map.containsKey(arr[j - 1])) {
                    queue.add(j - 1);
                }

                //jump to index k --> arr[j] == arr[k]
                if (map.containsKey(arr[j])) {
                    //search through the list of indexes where arr[j] is present
                    for (int k : map.get(arr[j])) {
                        if (k != j) {
                            //if one of the indexes is the last index, we've gotten to the end, otherwise we add the index to the queue
                            if (k == n - 1) {
                                return steps;
                            }
                            queue.add(k);
                        }
                    }
                }
                //remove the value of arr[j] from the map to avoid overlap
                map.remove(arr[j]);
            }
        }
        return steps;
    }
}
