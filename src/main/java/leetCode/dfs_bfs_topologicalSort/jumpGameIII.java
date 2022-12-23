package leetCode.dfs_bfs_topologicalSort;

import java.util.LinkedList;
import java.util.Queue;

public class jumpGameIII {
    /*
    Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are
    at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

    Notice that you can not jump outside of the array at any time.

    Example 1:
    Input: arr = [4,2,3,0,3,1,2], start = 5
    Output: true
    Explanation:
    All possible ways to reach at index 3 with value 0 are:
    index 5 -> index 4 -> index 1 -> index 3
    index 5 -> index 6 -> index 4 -> index 1 -> index 3

    Example 2:
    Input: arr = [4,2,3,0,3,1,2], start = 0
    Output: true
    Explanation:
    One possible way to reach at index 3 with value 0 is:
    index 0 -> index 4 -> index 1 -> index 3

    Example 3:
    Input: arr = [3,0,2,1,2], start = 2
    Output: false
    Explanation: There is no way to reach at index 1 with value 0.

    Constraints:
        1 <= arr.length <= 5 * 10^4
        0 <= arr[i] < arr.length
        0 <= start < arr.length
     */
    public boolean canReach(int[] arr, int start) {
        //check if start is a valid index
        if (start > arr.length || start < 0) {
            return false;
        }
        /*
            perform a DFS search for 0 in the given array "arr". we search for a path left or right from the start index
         */
        return searchZero(arr, start);
    }

    private boolean searchZero(int[] arr, int i) {
        //check if we are out of bounds or if we've visited the value before
        if (i < 0 || i >= arr.length || arr[i] < 0) {
            return false;
        }

        //if we found a zero, return true
        if (arr[i] == 0) {
            return true;
        }

        //mark the current value as visited
        arr[i] = -arr[i];

        //search left and right, if either hits zero, return true
        boolean found = searchZero(arr, i + arr[i]) || searchZero(arr, i - arr[i]);

        //switch the values back to normal after used to not leave array modified
        arr[i] *= -1;

        return found;
    }

    //Same method using a BFS search
    private boolean canReachBFS(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();

            //check if the node is zero
            if(arr[node] == 0) {
                return true;
            }

            //if the value if the current index has been visited, we need to move on
            if(arr[node] < 0) {
                continue;
            }

            //check if we can move right and left by adding and subtracting the index and value at the index to the queue
            if(node + arr[node] < arr.length) {
                queue.add(node + arr[node]);
            }

            if(node - arr[node] >= 0) {
                queue.add(node - arr[node]);
            }

            //mark the value at the node as visited
            arr[node] = -arr[node];
        }
        return false;
    }
}
