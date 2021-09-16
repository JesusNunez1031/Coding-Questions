public class LongestTurbulentSubarray {
    /*
    Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

    A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

    More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
        - For i <= k < j:
            - arr[k] > arr[k + 1] when k is odd, and
            - arr[k] < arr[k + 1] when k is even.
        - Or, for i <= k < j:
            - arr[k] > arr[k + 1] when k is even, and
            - arr[k] < arr[k + 1] when k is odd.

    Example 1:
    Input: arr = [9,4,2,10,7,8,8,1,9]
    Output: 5
    Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]

    Example 2:
    Input: arr = [4,8,12,16]
    Output: 2

    Example 3:
    Input: arr = [100]
    Output: 1

    Constraints:
        1 <= arr.length <= 4 * 10^4
        0 <= arr[i] <= 10^9
     */
    //TC: O(n) where n is the length of arr
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }

        int maxSize = 1; // by default, we start flat

        int start = 0;
        int end;
        int n = arr.length;

        while (start + 1 < n) {
            //move to the next index if the current sequence is flat
            if (arr[start] == arr[start + 1]) {
                start++;
                continue;
            }
            // Search for turbulent sequences, i.e. mountains
            end = start + 1;
            while (end + 1 < n && isTurbulent(arr, end)) {
                end++;
            }

            maxSize = Math.max(maxSize, end - start + 1);
            start = end; // move the start pointer to the end of the current turbulent sequence
        }
        return maxSize;
    }

    // returns true if the current index is greater than its previous and next value or less than its previous and next value
    private boolean isTurbulent(int[] arr, int k) {
        return ((arr[k] > arr[k - 1] && arr[k] > arr[k + 1]) || (arr[k] < arr[k - 1] && arr[k] < arr[k + 1]));
    }
}
