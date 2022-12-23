package leetCode.binarySearch;

public class peakIndexInMountainArray {
    /*
    Let's call an array arr a mountain if the following properties hold:
        - arr.length >= 3

        - There exists some i with 0 < i < arr.length - 1 such that:
            - arr[0] < arr[1] < ... arr[i-1] < arr[i]
            - arr[i] > arr[i+1] > ... > arr[arr.length - 1]

    Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

    Example 1:
    Input: arr = [0,1,0]
    Output: 1

    Example 2:
    Input: arr = [0,2,1,0]
    Output: 1

    Example 3:
    Input: arr = [0,10,5,2]
    Output: 1

    Example 4:
    Input: arr = [3,4,5,1]
    Output: 2

    Example 5:
    Input: arr = [24,69,100,99,79,78,67,36,26,19]
    Output: 2

    Constraints:
        3 <= arr.length <= 104
        0 <= arr[i] <= 106
        arr is guaranteed to be a mountain array.

   Follow up: Finding the O(n) is straightforward, could you find an O(log(n)) solution?
     */
    //TC: O(log n)
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            /*
                if the value at mid is less than the value at plus one from mid, we move left to mid + 1 since the peak
                must be to the right, otherwise we move the right pointer to the left to narrow the search of the peak
             */
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                //right will sit at the peak since we stop moving it once arr[mid] is no longer < than mid + 1
                right = mid;
            }
        }
        /*
          the left will hold the peak index, when the right ptr finally sits in the peak, we will break out of the loop
          as soon as left reaches it
         */
        return left;
    }

    //TC: O(n), method searches for through the entire array arr for the highest peak
    public int peakIndexInMountainArrayEz(int[] arr) {
        if (arr.length < 3) {
            return -1;
        }
        int peak = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                peak = i;
            }
        }
        return peak;
    }

    public static void main(String[] args) {
//        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        int[] arr = {0, 1, 0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
