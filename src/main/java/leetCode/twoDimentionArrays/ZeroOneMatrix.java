package leetCode.twoDimentionArrays;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    /*
    Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
    The distance between two adjacent cells is 1.

    Example 1:
    Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
    Output: [[0,0,0],[0,1,0],[0,0,0]]

    Example 2:
    Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
    Output: [[0,0,0],[0,1,0],[1,2,1]]

    Constraints:
        m == mat.length
        n == mat[i].length
        1 <= m, n <= 10^4
        1 <= m * n <= 10^4
        mat[i][j] is either 0 or 1.
        There is at least one 0 in mat.
     */

    //TC: O(m * n)
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] matrix = new int[m][n];

        //direction array, up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();

        /*
            all the cells that contain 0 will serve as the start to the BFS search. From here we search on all directions
            from the cell and increase the distance, or level, after each group of cells processed. This simulates
            calculating the distance from a 1 to a 0
        */
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    //mark all non-zero cells as -1, so we don't revisit already set cells from mat
                    matrix[i][j] = -1;
                }
            }
        }

        int steps = 1; // level of the BFS, i.e. distance from one point to another at a given step

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.remove();

                //search in all directions from the current cell
                for (int[] dir : directions) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    //check bounds, if the current cell is a 1 and has not been visited, i.e. == -1 set its distance from a 0
                    if (x <= m - 1 && y <= n - 1 && x >= 0 && y >= 0 && mat[x][y] == 1 && matrix[x][y] == -1) {
                        matrix[x][y] = steps;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            // increase level, or distance from the last seen 0
            steps++;
        }
        return matrix;
    }
}
