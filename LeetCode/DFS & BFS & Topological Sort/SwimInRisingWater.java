import java.util.PriorityQueue;

public class SwimInRisingWater {
    /*
    On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

    Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another
    4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can
    swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

    You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

    Example 1:
    Input: [[0,2],[1,3]]
    Output: 3
    Explanation:
    At time 0, you are in grid location (0, 0).
    You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.

    You cannot reach point (1, 1) until time 3.
    When the depth of water is 3, we can swim anywhere inside the grid.

    Example 2:
    Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
    Output: 16
    Explanation:
     0  1  2  3  4
    24 23 22 21  5
    12 13 14 15 16
    11 17 18 19 20
    10  9  8  7  6
    The final route is marked in bold.
    We need to wait until time 16 so that (0, 0) and (4, 4) are connected.

    Note:
        1. 2 <= N <= 50.
        2. grid[i][j] is a permutation of [0, ..., N*N - 1].
     */

    //TC: O(n^2 * log n) n^2 in the case all cells are visited and log n time to build heap
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        //2d array of direction coordinates, i.e. down, up, right, left
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[n][n];

        int i = 0, j = 0;
        int time; //max time waited to get to the last cell in the gird

        //heap stores coordinates from grid sorted by the smallest time t of each cell
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[2] - b[2]));

        //add the start to the heap and mark cell as visited
        heap.add(new int[]{0, 0, grid[i][j]});
        visited[0][0] = true;

        while (!heap.isEmpty()) {
            int[] curr = heap.remove();

            //search all neighbors of the current cell
            for (int[] direction : directions) {
                i = curr[0] + direction[0];
                j = curr[1] + direction[1];

                //check for valid bounds and if the cell has not been visited
                if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j]) {
                    continue;
                }

                /*
                    mark the cell as visited, calculate the new time that has been waited to get to the new cell in case
                    more time was needed to be waited to get from current cell "curr" to the new cell [i][j] and add
                    the cell to the heap using the new time. if the final cell is reached return the time waited
                */
                visited[i][j] = true;
                time = Math.max(curr[2], grid[i][j]);
                heap.add(new int[]{i, j, time});

                //if the last cell has been reached, return the time
                if (i == n - 1 && j == n - 1) {
                    return time;
                }

            }
        }
        //cannot get to the last cell
        return -1;
    }

    //TC: O(n^2) for the DFS search of the grid and log n search using binary search so O(n^2) is the overall complexity and O(n^2) space
    public static int swimInWaterBS(int[][] grid) {
        int n = grid.length;
        /*
            the range of indexes in the grid lie between 0 - n * n
            Minimum: we need to wait at least grid[0][0] time to be at 0,0 even if further path towards target takes 0
                     additional time
            Maximum: since problem states that grid[i][j] is a permutation of [0, ..., N*N - 1], the time after which we
                     can go from any point A to point B is the highest value in the grid i.e. n*n-1
         */
        int left = 0;
        int right = n * n;

        /*
            we can preform binary search in an unsortted grid since we dont actually use the grid in the search, but rather
            the times that can be in the range [0-n*n - 1], i.e "mid" and use the boolean array "visited" to see the
            indexes that have already been seen
         */
        while (left < right) {
            int mid = left + (right - left) / 2;
            /*
                visited array for search in grid between range [left, right]
                If we can reach from point a(i,j) to b(k,l) in time T, then we can reach in time T+1 also.
                eg: if we are able to reach some point at 5th sec, then It can also be reached in 6,7,8... time as well.
             */
            boolean[][] visited = new boolean[n][n];

            /*
                if we cant get to the end using the current half of the grid, narrow the search to the upper half otherwise
                narrow the search to the bottom half
             */
            if (!swimToLast(grid, n, 0, 0, visited, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        /*
            since grid[i][j] is a permutation of [0, ..., N*N - 1], we can directly return the value of either left or right
            since they are both permutations and not actual indexes.
         */
        return right;
    }

    private static boolean swimToLast(int[][] grid, int n, int i, int j, boolean[][] visited, int time) {
        /*
            check bounds, if the current cell has been visited, and if current cell requires us to wait we need to wait
            until time is at that elevation hence we return false since we cant move there yet
         */
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] > time) {
            return false;
        }
        //mark the current cell as visited
        visited[i][j] = true;

        //return true if the last cell has been reached
        if (i == n - 1 && j == n - 1) {
            return true;
        }

        //search in all 4 directions down, up, right, and left for the next cell that we can move to
        return swimToLast(grid, n, i + 1, j, visited, time) ||
                swimToLast(grid, n, i - 1, j, visited, time) ||
                swimToLast(grid, n, i, j + 1, visited, time) ||
                swimToLast(grid, n, i, j - 1, visited, time);
    }
}
