package leetCode.binarySearch;

public class KthSmallestNumberInMultiplicationTable {
    /*
    Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat
    where mat[i][j] == i * j (1-indexed).

    Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.

    Example 1:
    [1][2][3]
    [2][4][6]
    [3][6][9]

    [1][2][2][3][{3}][4][6][6][9]
    Input: m = 3, n = 3, k = 5
    Output: 3
    Explanation: The 5th smallest number,{}, is 3.

    Example 2:
    [1][2][3]
    [2][4][6]

    [1][2][2][3][4][{6}]
    Input: m = 2, n = 3, k = 6
    Output: 6
    Explanation: The 6th smallest number is 6.

    Constraints:
        1 <= m, n <= 3 * 10^4
        1 <= k <= m * n
     */
    //TC: O(m * log(m * n))
    public static int findKthNumber(int m, int n, int k) {
        int left = 1; // one indexed
        int right = m * n; // last cell in the table

        while (left < right) {
            int mid = left + (right - left) / 2;

            // check if mid is large enough to be the kth value in the multiplication table
            if (isSmallest(mid, m, n, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isSmallest(int mid, int m, int n, int k) {
        int count = 0; // number of elements in table <= mid

        // calculate how many elements are in between mid and by dividing mid by each divisor in the range 1 to m
        for (int i = 1; i <= m; i++) {
            /*
                As i increases mid/i will decrease and by extension the count will also slowly increase, at the end of
                the row, we check of the count >= k which indicates how close we are to k
            */
            count += Math.min(mid / i, n);
        }
        return count >= k;
    }

    public static void main(String[] args) {
        findKthNumber(3, 3, 5);
    }
}
