package leetCode.heaps;

import java.util.PriorityQueue;
import java.util.Random;

public class findKthLargestElement {
    /*
    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not
    the kth distinct element.

    Example 1:
    Input: [3,2,1,5,6,4] and k = 2
    Output: 5

    Example 2:
    Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4
     */

    //RT is O(n log k) to build the heap and space is O(n) where n is the length of the array
    private static int findKthLargest(int[] nums, int k) {
        /*
            Since we are using a minHeap, when we are done processing all values in array, the heap will have all the kth
            largest values, so the root will be the kth largest value, everything after that will be larger than it so
            we return the root.
        */
        //PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());  // turn a minheap to maxheap, reverse the order to get the kth smallest
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i : nums) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }

    //RT O(n) & O(n^2) worst time, O(1) space using quick-select algorithm
    private static int kthLargest(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        Random randy = new Random(0);

        while (left <= right) {
            int chosenPivotIndex = left + randy.nextInt(right - left + 1); //pick a random pivot in the array

            //returns the sorted index of the value at chosenPivotIndex, i.e. the index the value would be in if nums was sorted
            int sortedIndexOfPivot = partition(arr, left, right, chosenPivotIndex);
            /*
              if the sortedIndexOfPivot is equal to n - k, then we have found the kth largest value since if we assume a
              sorted array then arr[length of array - k] is the index of the kth largest value.
             */
            if (sortedIndexOfPivot == n - k) {
                return arr[sortedIndexOfPivot];
            }
            /*
                if the sortedIndexOfPivot is greater than n - k, then we overshot and need to go left so we reduce the
                right bound
             */
            else if (sortedIndexOfPivot > n - k) {
                right = sortedIndexOfPivot - 1;
            }
            //We undershot and need to move right, so we increase the left bound
            else {
                left = sortedIndexOfPivot + 1;
            }
        }
        return -1;
    }

    public static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];    //value of the random chosen index
        int tail_of_lesser_values = left;    //index of the last value smaller than the pivot

        //since we don't want to modify the position of the pivot value, we swap it with the value at the right
        swap(arr, pivotIndex, right);

        for (int i = left; i < right; i++) {
            /*
                if the current value is less than the initial pivot value, we need to swap it with the tail of the last
                value that was less than the pivot value so that its position is to the left of the pivotVal

                increase the tail by one so next time we find a new value less than pivotValue, we can swap it to this
                index, or if no other values are left to swap, the pivotIndex value can be placed in its sorted index,
                i.e. all values before it will be less than it
             */
            if (arr[i] < pivotValue) {
                swap(arr, i, tail_of_lesser_values);
                tail_of_lesser_values++;
            }
        }

        /*
            the position of the pivotIndex value is at the right, so to place the value in its sorted index, we swap it
            with the tail index which is the index +1 from the last smallest value less than pivotVal
         */
        swap(arr, right, tail_of_lesser_values);

        //return the sorted index of pivotValue
        return tail_of_lesser_values;
    }

    //Swaps values in nums
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(kthLargest(arr, 2));

    }
}
