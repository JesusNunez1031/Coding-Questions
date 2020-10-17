public class validMountainArray {
    /*
        Given an array A of integers, return true if and only if it is a valid mountain array.

        Recall that A is a mountain array if and only if:
            A.length >= 3
            There exists some i with 0 < i < A.length - 1 such that:
            A[0] < A[1] < ... A[i-1] < A[i]
            A[i] > A[i+1] > ... > A[A.length - 1]

            Example 1:
            Input: [2,1]
            Output: false

            Example 2:
            Input: [3,5,5]
            Output: false

            Example 3:
            Input: [0,3,2,1]
            Output: true
     */

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int i = 0;

        //All values before the peek need be increasing, the moment we see a duplicate value we return false
        while (i < A.length - 1 && A[i] < A[i + 1]) {
            if (A[i] == A[i + 1]) {
                return false;
            }
            i++;
        }
        //if the given array is reverse, we check if i is still at 0 or if the array had no peak
        if (i == A.length - 1 || i == 0) {
            return false;
        }

        //the latter half of the array should be in decending order
        while (i < A.length - 1 && A[i] > A[i + 1]) {
            if (A[i] == A[i + 1]) {
                return false;
            }
            i++;
        }
        //if we made it to the end, i should be at the end so we make a check for that
        return i == A.length - 1;
    }
}
