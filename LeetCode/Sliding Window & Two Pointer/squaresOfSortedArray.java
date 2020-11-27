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
        int[] squares = new int[a.length];

        //pointer to the first and last value in the array
        int i = 0, j = a.length - 1;

        //elements are added from the rear
        int z = a.length - 1;

        while (i <= j) {
            /*
                since the array can have negative values, we check if the first lowest value squared is greater than the
                last value in the array, if so we add the first value to the end of the new array, otherwise we add the
                last value squared
             */
            if (a[i] * a[i] > a[j] * a[j]) {
                squares[z] = a[i] * a[i];
                i++;
            } else {
                squares[z] = a[j] * a[j];
                j--;
            }
            z--;
        }
        return squares;
    }
}
