package leetCode.heaps;

import java.util.PriorityQueue;

public class kClosestPointsToOrigin {
    /*
    We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
    (Here, the distance between two points on a plane is the Euclidean distance.)
    You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

    Example 1:
    Input: points = [[1,3],[-2,2]], K = 1
    Output: [[-2,2]]
    Explanation:
    The distance between (1, 3) and the origin is sqrt(10).
    The distance between (-2, 2) and the origin is sqrt(8).
    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
    We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

    Example 2:
    Input: points = [[3,3],[5,-1],[-2,4]], K = 2
    Output: [[3,3],[-2,4]]
    (The answer [[-2,4],[3,3]] would also be accepted.)

    Note:
        1 <= K <= points.length <= 10000
        -10000 < points[i][0] < 10000
        -10000 < points[i][1] < 10000
     */
    //TC: O(n log k) and O(n) space due to use of PQ. adding elements to PQ takes logn time and we do that for every point in points
    private int[][] kClosest(int[][] points, int k) {
        int[][] closest = new int[k][2];

        if (points.length == 0) {
            return closest;
        }

        //max heap, the points with largest distances will be at the top
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        for (int[] point : points) {
            //put the points and distances of all the points into the heap
            heap.add(new int[]{point[0], point[1], distance(point)});
            //when the heap size exceeds k, we remove the first point since we only want the lowest distances
            if (heap.size() > k) {
                heap.remove();
            }
        }

        //the only points in the heap will be the k closest points so we add them to the resulting array
        while (k-- > 0) {
            int[] current = heap.remove();
            closest[k][0] = current[0];
            closest[k][1] = current[1];
        }
        return closest;
    }

    //Method to calculate the distance of a point
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
