package leetCode.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class findKClosestElements {
    /*
    Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result
    should also be sorted in ascending order.
        An integer a is closer to x than an integer b if:
            |a - x| < |b - x|, or
            |a - x| == |b - x| and a < b

    Example 1:
    Input: arr = [1,2,3,4,5], k = 4, x = 3
    Output: [1,2,3,4]

    Example 2:
    Input: arr = [1,2,3,4,5], k = 4, x = -1
    Output: [1,2,3,4]

    Constraints:
        1 <= k <= arr.length
        1 <= arr.length <= 10^4
        Absolute value of elements in the array and x will not exceed 10^4
     */

    //approach 1: TC: O(n log n + k log k) nlogn time to go through all values in arr and maintain a heap, and klogk to sort result
    public List<Integer> findClosestElementsPQ(int[] arr, int k, int x) {
        /*
            max heap of arrays where the 0: index 1: arr[i] 2: diff: |arr[i] - x|, if two values are equal, values are
            sorted by their index, otherwise sort by difference
         */
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[2] == a[2] ? b[0] - a[0] : b[2] - a[2]);

        for (int i = 0; i < arr.length; i++) {
            heap.add(new int[]{i, arr[i], Math.abs(arr[i] - x)});

            //when there are more than k items in the heap remove so only the closest k values remain
            if (heap.size() > k) {
                heap.remove();
            }
        }

        List<Integer> list = new ArrayList<>();

        //the only values left in the heap are those that are closest to k
        while (k > 0) {
            list.add(heap.remove()[1]);
            k--;
        }

        Collections.sort(list);
        return list;
    }

    //approach 2: O(n) using 2 pointers
    public List<Integer> findClosestElements2Ptr(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        /*
            observe a window of at least k items in arr, if the difference between the left and x is greater than the
            difference at the right, narrow the window from the left side, otherwise, narrow the search from the right
         */
        while (right - left >= k) {

            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        List<Integer> closest = new ArrayList<>();

        /*
            since we exit when the window of observed values is no longer k size, we have k values between left and
            right that are closest to x
         */
        for (int i = left; i <= right; i++) {
            closest.add(arr[i]);
        }
        return closest;
    }

    //TC: O(log n + k)
    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        int left = 0;
        int right = arr.length - k; //we only want to look at a window of size k

        //use binary search to find the starting index of the window of k values closest to x
        while (left < right) {
            int mid = left + (right - left) / 2;

            /*
                if the difference between the value at the start of the window is greater than the difference between
                x - the last value of the window, we want to move the start of the window to mid + 1 since its a smaller
                distance to x, otherwise, we narrow the search by making the right to mid
             */
            if (Math.abs(arr[mid] - x) > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        /*
            the start of the window is at left when the search ends so we add left + k values from the array to the list
            the order is guaranteed to be in ascending since arr is sorted
         */
        for (int i = left; i < left + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
