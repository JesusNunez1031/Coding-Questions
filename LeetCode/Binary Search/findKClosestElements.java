import java.util.ArrayList;
import java.util.List;

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
    //TC: O(log n + k)
    private static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        int left = 0;
        int right = arr.length - k; //we only want to look at a window of size k

        //use binary search to find the starting index of the window of k values closest to x
        while (left < right) {
            int mid = left + (right - left) / 2;

            /*
                if the distance at arr[mid] to x is greater than the distance at the last value of the window, we want
                to move the start of the window to mid + 1 since its a smaller distance to x, otherwise, we narrow the
                search by making the right to mid
             */
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //the start of the window is at left when the search ends so we add left + k values from the array to the list
        for (int i = left; i < left + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        System.out.println(findClosestElements(arr, k, x).toString());
    }
}
