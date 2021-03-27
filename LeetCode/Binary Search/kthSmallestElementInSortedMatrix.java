import java.util.PriorityQueue;

public class kthSmallestElementInSortedMatrix {
    /*
   Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest
   element in the matrix.

    Note that it is the kth smallest element in the sorted order, not the kth distinct element.

    Example 1:
    Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
    Output: 13
    Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

    Example 2:
    Input: matrix = [[-5]], k = 1
    Output: -5

    Constraints:
        n == matrix.length
        n == matrix[i].length
        1 <= n <= 300
        -10^9 <= matrix[i][j] <= -10^9
        All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
        1 <= k <= n^2
     */
    //TC: (n log(n^2)) and constant space used
    private static int kthSmallest(int[][] matrix, int k) {
        return findKthValue(matrix, k);
    }

    //Binary search the kth smallest value in the matrix
    private static int findKthValue(int[][] matrix, int k) {
        int n = matrix.length;

        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];

        while (min < max) {
            int mid = min + (max - min) / 2;

            //position is the index where the "mid" value is at in the matrix
            int position = findPosition(matrix, mid);

            //when position == k, min will be at k and max will be moved to mid thus min > max and break out of the loop
            if (position < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    //Method to return the integer position of the given target value in the matrix
    private static int findPosition(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        int pos = 0;

        /*
            loop through the matrix row by row starting from the last column in the row, if the value at matrix[i][j]
            is <= target, we move to the next row and update the position we want to return to the current position of j,
            if matrix[i][j] its greater, we reduce j by one since the target will be in the specific row
         */
        while (i < matrix.length && j >= 0) {
            /*
                if the current value matrix[i][j] is less then the target, we need to search further in the matrix so we
                increase i to the next row and move j to the last column of the new row i, the position is also moved to
                the current position in the row j
             */
            if (matrix[i][j] <= target) {
                pos += j + 1;
                i++;
            } else {
                //if the current value is less than the target, move j left in the row by one
                j--;
            }
        }
        return pos;
    }

    //TC: O(n^2) and O(n) space used due to the minHeap used
    private int kthSmallestHeap(int[][] matrix, int k) {
        //make a maxheap, the kth smallest will be at the top of the heap if we remove from heap after its size is larger than k
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int[] row : matrix) {
            for (int val : row) {
                maxHeap.add(val);

                if (maxHeap.size() > k) {
                    maxHeap.remove();
                }
            }
        }
        return maxHeap.remove();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {8, 9, 10}};
        int k = 8;
        System.out.println(findKthValue(matrix, k));
    }
}
