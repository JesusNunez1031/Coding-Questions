package leetCode.math;

public class smallestRangeI {
    /*
    Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
    After this process, we have some array B.
    Return the smallest possible difference between the maximum value of B and the minimum value of B.

    Example 1:
    Input: A = [1], K = 0
    Output: 0
    Explanation: B = [1]

    Example 2:
    Input: A = [0,10], K = 2
    Output: 6
    Explanation: B = [2,8]

    Example 3:
    Input: A = [1,3,6], K = 3
    Output: 0
    Explanation: B = [3,3,3] or B = [4,4,4]

    Note:
        1 <= A.length <= 10000
        0 <= A[i] <= 10000
        0 <= K <= 10000
     */
    private int smallestRangeI(int[] A, int k) {
        //Highest value in A can be 10000 and there are no negative values
        int max_A = -1;
        int min_A = 100001;

        /*
            find the max and min values in the array A, then we reduce the max by k and increase the min by k we reduce
            max by k and increase min by k since -k <= x <= k, max - k is the the lowest B can go and min + k is the
            highest B can go, the answer has to be >= 0 so if ((max_A - k) - (min_A + k)) < 0, we return 0
        */
        for (int val : A) {
            if (val > max_A) {
                max_A = val;
            }
            if (val < min_A) {
                min_A = val;
            }
        }
        return Math.max(0, ((max_A - k) - (min_A + k)));
    }
}
