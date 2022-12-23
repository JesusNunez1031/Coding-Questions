package leetCode.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class pathWithMinEffort {
    /*
        TC: O(m * n log(m*n)) and space of O(m * n) since we store values in a 2-d effort array. Dijkstra's algorithm of
        shortest path with weighted edges is applied
     */
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        //effort array holds effort of each path
        int[][] effort = new int[m][n];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        /*
            PQ holds the minimum effort for a given cell in heights, e.g. distance, row, column -> int[], topmost array
            in heap has the smallest distance cell
         */
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        //add the start of traversal
        heap.add(new int[]{0, 0, 0});

        //direction array, right, left, down, up
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!heap.isEmpty()) {
            //process the top element in the heap
            int[] min = heap.remove();

            //distance(effort), row, and column of the current min
            int distance = min[0], row = min[1], column = min[2];

            //if the current effort of the path is larger than a previous path, move to the next path
            if (distance > effort[row][column]) {
                continue;
            }

            //when the last cell in heights is reached, return the smallest distance
            if (row == m - 1 && column == n - 1) {
                return distance;
            }

            //search all paths adjacent from "heights[row][column]"
            for (int[] d : dir) {
                int newRow = row + d[0];
                int newColumn = column + d[1];

                //check bounds
                if (newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n) {
                    int newDistance = Math.max(distance, Math.abs(heights[newRow][newColumn] - heights[row][column]));

                    /*
                        if the new distance calculated in a path cost less effort than the effort stored, update it and
                        add the new path to the heap
                     */
                    if (newDistance < effort[newRow][newColumn]) {
                        effort[newRow][newColumn] = newDistance;
                        heap.add(new int[]{newDistance, newRow, newColumn});
                    }
                }
            }
        }
        return 0;
    }
}
