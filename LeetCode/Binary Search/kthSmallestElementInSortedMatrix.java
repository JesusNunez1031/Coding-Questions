import java.util.PriorityQueue;

public class kthSmallestElementInSortedMatrix {
    /*
    Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
    Note that it is the kth smallest element in the sorted order, not the kth distinct element.

    Example:
    matrix = [
       [ 1,  5,  9],
       [10, 11, 13],
       [12, 13, 15]
    ],
    k = 8,
    return 13.

    Note:
        You may assume k is always valid, 1 ≤ k ≤ n2.
     */
    public int kthSmallest(int[][] matrix, int k) {
        //make a maxheap, the kth smallest will be at the top of the heap if we remove from heap after its size is larger than k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int[] row : matrix) {
            for (int val : row) {
                minHeap.add(val);

                if (minHeap.size() > k) {
                    minHeap.remove();
                }
            }
        }
        return minHeap.remove();
    }
}
