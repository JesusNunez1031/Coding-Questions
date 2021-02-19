public class arithmeticSlices {
    /*
    A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

    For example, these are arithmetic sequences:
    1, 3, 5, 7, 9
    7, 7, 7, 7
    3, -1, -5, -9

    The following sequence is not arithmetic.
    1, 1, 2, 5, 7

    A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

    A slice (P, Q) of the array A is called arithmetic if the sequence:
    A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

    The function should return the number of arithmetic slices in the array A.

    Example:
    A = [1, 2, 3, 4]
    return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
     */
    //TC/S: O(n) and O(n) since we use a dp array
    public int numberOfArithmeticSlices(int[] A) {
        //an arithmetic slice must be of size 3 anything less cant be valid
        if (A.length < 3) {
            return 0;
        }
        int[] dp = new int[A.length];
        int slices = 0;

        /*
            observe a section of length 3 at all times while traversing array A and check if the  difference between all
            values in the slice are the same, if so the slice is arithmetic so the number of arithmetic slices up to i
            is the sum of slices up to [i - 1] +1 to include the current slice
        */
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                slices += dp[i];
            }
        }
        return slices;
    }

    //TC: O(n) and constant space
    public int numberOfArithmeticSlicesEz(int[] A) {
        if(A.length < 3) {
            return 0;
        }

        int slices = 0;
        int dp = 0;

        /*
            Same a previous method except rather than use a dp array, we simply add 1 to dp at every arithmetic slice and
            reset it when a slice it not arithmetic
         */
        for(int i = 2; i < A.length;i++) {
            if(A[i] - A[i-1] == A[i - 1] - A[i - 2]) {
                dp += 1;
                slices += dp;
            } else {
                dp = 0;
            }
        }
        return slices;
    }
}
