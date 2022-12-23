package leetCode.binarySearch;

import java.util.Arrays;
import java.util.PriorityQueue;

public class thekWeakestRowsInMatrix {
    /*
    Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of
    the k weakest rows in the matrix ordered from the weakest to the strongest.
    A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or
    they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row,
    that is, always ones may appear first and then zeros.

    Example 1:
    Input: mat =
    [[1,1,0,0,0],
     [1,1,1,1,0],
     [1,0,0,0,0],
     [1,1,0,0,0],
     [1,1,1,1,1]],
    k = 3
    Output: [2,0,3]
    Explanation:
    The number of soldiers for each row is:
    row 0 -> 2
    row 1 -> 4
    row 2 -> 1
    row 3 -> 2
    row 4 -> 5
    Rows ordered from the weakest to the strongest are [2,0,3,1,4]

    Example 2:
    Input: mat =
    [[1,0,0,0],
     [1,1,1,1],
     [1,0,0,0],
     [1,0,0,0]],
    k = 2
    Output: [0,2]
    Explanation:
    The number of soldiers for each row is:
    row 0 -> 1
    row 1 -> 4
    row 2 -> 1
    row 3 -> 1
    Rows ordered from the weakest to the strongest are [0,2,3,1]

    Constraints:
        m == mat.length
        n == mat[i].length
        2 <= n, m <= 100
        1 <= k <= m
        matrix[i][j] is either 0 or 1.
     */
    //TC: O(n log n) since we sort the matrix
    public int[] kWeakestRows(int[][] mat, int k) {
        //2D matrix to hold the number of solders in a row and the index the row is at
        int[][] weakest = new int[mat.length][];
        int i = 0;


        for (int[] row : mat) {
            /*
                search method returns the index of the first civilian, so if there
                are only 2 solders, the first index of a civilian is 2
            */
            int solders = binarySearch(row);    //if there are no civilians, the number of soldiers is the length of the row
            weakest[i] = new int[]{solders, i};
            i++;
        }

        //sort weakest by the first value of soldiers
        Arrays.sort(weakest, (a, b) -> a[0] - b[0]);

        //add the first k indexes to the result array
        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            res[j] = weakest[j][1];
        }

        return res;
    }

    //Method using PriorityQueue to order the rows TC: O(n log n) and O(n) space used to store the rows into the queue
    public static int[] kWeakestRowsEz(int[][] mat, int k) {
        /*
            minheap stores the weakest row in mat at the root
            int[] = 0 -> num of soldiers 1 -> index of row
            a, b --> if the number of soldiers in the arrays are not equal, place the array with the least soldiers
                     at the top, otherwise, place the array with the lower value of the row at top
         */
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = 0; i < mat.length; i++) {
            //search method returns the index of the first civilian, so if there are only 2 solders, the first index of a civilian is 2
            int soldiers = binarySearch(mat[i]); //if there are no civilians, the number of soldiers is the length of the row
            queue.add(new int[]{soldiers, i});
        }

        int[] weakest = new int[k];
        int i = 0;

        //the top k rows in the queue hold the weakest rows
        while (k-- > 0) {
            weakest[i++] = queue.remove()[1];
        }
        return weakest;
    }

    //returns the index of the first civilian
    private static int binarySearch(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            //if the current value is a solder move right
            if (nums[mid] > 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        //int[][] mat = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int[][] mat = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}};
        System.out.println(Arrays.toString(kWeakestRowsEz(mat, 3)));
    }
}
