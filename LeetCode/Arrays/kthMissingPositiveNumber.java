import java.util.HashSet;
import java.util.Set;

public class kthMissingPositiveNumber {
    /*
    Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
    Find the kth positive integer that is missing from this array.

    Example 1:
    Input: arr = [2,3,4,7,11], k = 5
    Output: 9
    Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

    Example 2:
    Input: arr = [1,2,3,4], k = 2
    Output: 6
    Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

    Constraints:
        1 <= arr.length <= 1000
        1 <= arr[i] <= 1000
        1 <= k <= 1000
        arr[i] < arr[j] for 1 <= i < j <= arr.length
     */
    //TC: O(n) and O(n) space
    public int findKthPositive(int[] arr, int k) {
        int missing = 0;
        Set<Integer> set = new HashSet<>();
        //add all values in arr to the map
        for (int val : arr) {
            set.add(val);
        }

        //go through all possible values in the array and check which value is not present
        for (int i = 1; i < 1001; i++) {
            //if the set does not contain i, we increase the missing counter
            if (!set.contains(i)) {
                missing++;
            }

            //when missing == k, we have the kth missing value
            if (missing == k) {
                return i;
            }
        }

        /*
            if the missing value is beyond the range of 1000, we calculate the kth missing value by
            subtracting the number of values missing in the range of 1000 and add k to get the kth missing
        */
        return (1000 - missing) + k;
    }

    //TC/S: O(n) and constant space used
    private int findKthPositiveC(int[] arr, int k) {
        int missing = 0;
        int i = 0;
        int j = 1;

        while (i < arr.length) {
            /*
                increase j and missing counter until the current value arr[i] == j, if missing == k, then we return
                the jth value, otherwise we move on to the next value in arr
            */
            if (arr[i] != j) {
                missing++;
                if (missing == k) {
                    return j;
                }
            } else {
                i++;
            }
            j++;
        }

        //if the end of the array is reached, the kth missing value will be the last value in arr + k
        return arr.length + k;
    }

    //search through values in the array, if they are less than k, we increase k until the current value is greater than k
    private int findKthPositiveEZ(int[] arr, int k) {
        for (int value : arr) {
            if (value <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }
}
