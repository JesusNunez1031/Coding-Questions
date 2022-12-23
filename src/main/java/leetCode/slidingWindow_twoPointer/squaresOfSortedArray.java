package leetCode.slidingWindow_twoPointer;

import java.util.Arrays;

public class squaresOfSortedArray {
    /*
    Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also
    in sorted non-decreasing order.

    Example 1:
    Input: [-4,-1,0,3,10]
    Output: [0,1,9,16,100]

    Example 2:
    Input: [-7,-3,2,3,11]
    Output: [4,9,9,49,121]

    Note:
        1 <= A.length <= 10000
        -10000 <= A[i] <= 10000
        A is sorted in non-decreasing order.
     */

    //TC: O(n) time and constant space, the returned array does not count as spaced used
    public int[] sortedSquares(int[] a) {
        if (a.length == 0) {
            return new int[]{};
        }
        int[] squares = new int[a.length];

        //pointer to the first and last values in the array
        int i = 0, j = a.length - 1;

        //pointer used to add elements to the rear of the array
        int z = a.length - 1;

        while (i <= j) {
            /*
                take the square of a[i] and a[j] and place the larger value at a[z] and increment or decrement the pointer
                of the larger value used
             */
            int s = a[i] * a[i];
            int e = a[j] * a[j];
            if (s > e) {
                squares[z] = s;
                i++;
            } else {
                squares[z] = e;
                j--;
            }
            z--;
        }
        return squares;
    }
}
