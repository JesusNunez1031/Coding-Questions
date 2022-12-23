package leetCode.sorting;

public class sortArrayByParity {
    /*
        Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
        You may return any answer array that satisfies this condition.

        Example 1:

        Input: [3,1,2,4]
        Output: [2,4,3,1]
        The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
     */
    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int start = 0;
        for (int k : A) {
            if (k % 2 == 0) {
                ans[start++] = k;
            }
        }

        for (int j : A) {
            if (j % 2 != 0) {
                ans[start++] = j;
            }
        }
        return ans;
    }
}
