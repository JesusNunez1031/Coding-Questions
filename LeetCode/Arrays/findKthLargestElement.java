import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class findKthLargestElement {
    /*
    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

    Example 1:
    Input: [3,2,1,5,6,4] and k = 2
    Output: 5

    Example 2:
    Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4
     */

    //RT is O(n log k) to build the heap and space is O(n) where n is the length of the array
    public static int findKthLargest(int[] nums, int k) {
        //Since we are using a minHeap, when we are done processing all values in array, the heap will have all the kth largest values, so the root
        //will be the kth largest value, everything after that will be larger than it so we return the root.
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
    public static int kthLargest(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        Random randy = new Random(0);

        while (left <= right) {
            int chosenPivotIndex = left + randy.nextInt(right - left + 1);      //pick a random pivot in the array
            int sortedIndexOfPivot = partition(arr, left, right, chosenPivotIndex);    //returns the final index of the pivot, final as in if the array was sorted, this is the index the pivot would be in

            /*
              if the sortedIndexOfPivot is equal to n - k, then we have found the kth largest value since if we
              assume a sorted array then arr[length of array - k] is the index of the kth largest value.
             */
            if (sortedIndexOfPivot == n - k) {
                return arr[sortedIndexOfPivot];
            }
            /*
                if the sortedIndexOfPivot is greater than n - k, then we overshot and need to go
                left so we reduce the right bound
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
        int pivotValue = arr[pivotIndex];
        int lesserItemsTailIndex = left;    //index of the last value smaller than the pivot

        /*
            since we don't want to modify the pivot value, we swap it with the value at the right
         */
        swap(arr, pivotIndex, right);

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, lesserItemsTailIndex);
                lesserItemsTailIndex++;
            }
        }

        /*
        the initial right value is now the tail of all the items less than the pivot, so we swap it with the pivot value
        and now the pivot value is in its sorted position
         */
        swap(arr, right, lesserItemsTailIndex);
        return lesserItemsTailIndex;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(kthLargest(arr, 2));

    }
}
