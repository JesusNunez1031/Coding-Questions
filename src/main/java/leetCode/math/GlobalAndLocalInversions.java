package leetCode.math;

public class GlobalAndLocalInversions {
    /*
    We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.
    The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].
    The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].

    Return true if and only if the number of global inversions is equal to the number of local inversions.

    Example 1:
    Input: A = [1,0,2]
    Output: true
    Explanation: There is 1 global inversion, and 1 local inversion.

    Example 2:
    Input: A = [1,2,0]
    Output: false
    Explanation: There are 2 global inversions, and 1 local inversion.

    Note:
        A will be a permutation of [0, 1, ..., A.length - 1].
        A will have length in range [1, 5000].
        The time limit for this problem has been reduced.
     */
    public boolean isIdealPermutation(int[] A) {
        /*
            Global Inversions:
                the number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j]

            Local Inversions:
                the number of i with 0 <= i < N and A[i] > A[i + 1]

            0 can only be placed at the 0th index and 1st index only, anywhere else and we get more global than local,
            all other numbers can be placed at i or i-1 or i+1 index only, this can also be interpreted as the absolute
            difference between A[i], any number, and i, any index, is always < 1, i.e. either 0, or +1 or -1 which gives
            1 when absolute value is found.

            To check if the arrays global and local are the same, we just find if there is any difference of A[index] and
            index is greater than 1 or not
         */
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}
