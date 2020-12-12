import java.util.ArrayList;
import java.util.List;

public class intervalListIntersection {
    /*
    Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
    Return the intersection of these two interval lists.

    (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The
    intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a
    closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

    Example 1:
    A   ____          ________________       __________________________________    __________
    B     ____________          ____________          _____________________________          ___________
    ans   __          |         ______                __________________________   |         |
        0           4           8           12           16           20           24        25        26

    Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
    Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

    Note:
        0 <= A.length < 1000
        0 <= B.length < 1000
        0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
     */

    //TC:O(n) and O(n) space used
    private int[][] intervalIntersection(int[][] A, int[][] B) {
        //if either A or B are empty, there are no intervals to compare to
        if (A.length == 0 || B.length == 0) {
            return new int[][]{};
        }
        List<int[]> list = new ArrayList<>(); //list to hold all intersecting pointers

        //Note: Intervals are in sorted order so there is no need to sort them

        int i = 0;    //pointer to A
        int j = 0;    //pointer to B

        while (i < A.length && j < B.length) {
            //Start and end times for the respective intervals in A and B
            int start_time_a = A[i][0];
            int end_time_a = A[i][1];

            int start_time_b = B[j][0];
            int end_time_b = B[j][1];

            /*
               An intersection occurs when intervals overlap, so we check for an intersection
                Ex: i is the start and j is the end
                    Ai___________Aj
                             |   | ← intersection
                           Bi|___|______Bj

                an overlap is detected when Ai <= Bj and if Aj >= Bi
            */
            if (start_time_a <= end_time_b && end_time_a >= start_time_b) {

                //The intersecting interval values will be, start = max(Ai, Bi) and the end = min(Aj, Bj)
                list.add(new int[]{Math.max(start_time_a, start_time_b), Math.min(end_time_a, end_time_b)});
            }

            //The interval with the higher span will remain and the lesser will have its pointer increased
            if (end_time_a > end_time_b) {
                j++;
            } else {
                i++;
            }
        }

        //convert the list to a matrix
        int[][] intervals = new int[list.size()][];
        for (int k = 0; k < intervals.length; k++) {
            intervals[k] = list.get(k);
        }

        return intervals;
    }
}
