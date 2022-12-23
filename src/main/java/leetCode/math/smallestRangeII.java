package leetCode.math;

import java.util.Arrays;

public class smallestRangeII {
    /*
    Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K, and add x to A[i] (only once).
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
    Output: 3
    Explanation: B = [4,6,3]

    Note:
        1 <= A.length <= 10000
        0 <= A[i] <= 10000
        0 <= K <= 10000
     */

    private int smallestRangeII(int[] A, int k) {
        int n = A.length;
        Arrays.sort(A);
        int res = A[n - 1] - A[0];

        /*
            since we can only choose x as -k or k, we sort the array and take the smallest gap for every two values in
            the array, the initial result is the difference between the first and last numbers in the array, then, we
            traverse the array, if the values get larger, the difference should reduce

            Ex:
                the highest B can be is the largest value in A - k so we compare it with A[i] + k at every step to see
                if it gives us a larger value

                the lowest B can be is the smallest value in A + k, so we also check the next value j, - k from i to see
                if this gives us a lower value for B

                at the end, we check if the difference of the current highest value B and lowest B gives is a lower value
                than the initial result maxA - minA

                [1, 3, 6] k = 3
                res = (6 - 1) = 5

                1. high = max(5, 4) = 5
                   low = min(4, 0)
                   res = 5
                2. high = max(5, 6)
                   low = min(4, 3)
                   res = 3
                         ↑
                    final result
         */
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            int high = Math.max(A[n - 1] - k, A[i] + k);
            int low = Math.min(A[0] + k, A[j] - k);
            res = Math.min(res, high - low);
        }
        return res;
    }
}
