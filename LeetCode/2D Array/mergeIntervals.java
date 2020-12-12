import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals {
    /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

    Example 1:
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

    Example 2:
    Input: intervals = [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.


    Constraints:
        1 <= intervals.length <= 10^4
        intervals[i].length == 2
        0 <= starti <= endi <= 10^4
     */
    //TC: O(n log n) since we sort the intervals and space is O(n)
    public static int[][] merge(int[][] intervals) {
        //if there is only one interval, we have no intervals to merge
        if (intervals.length == 1) {
            return intervals;
        }
        //sort the intervals in order of their start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();   //make an arraylist of arrays to hold the intervals

        //add the first interval to the list so we can reference the last interval at every current interval
        list.add(intervals[0]);

        /*
            for every interval, compare the start time to the end time of the previous interval
            if the start time is less than or equal to the end time of the previous interval, make the
            end time of the previous interval the max end time of the current interval or the previous
        */
        int j = 0;  //pointer to refer to the previous interval since not all intervals will be added
        for (int i = 1; i < intervals.length; i++) {
            int start_time = intervals[i][0];
            int[] prev_interval = list.get(j);
            if (start_time <= prev_interval[1]) {
                prev_interval[1] = Math.max(prev_interval[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
                j++;
            }
        }

        //convert the list to a matrix
        int[][] merged = new int[list.size()][];
        for (int i = 0; i < merged.length; i++) {
            merged[i] = list.get(i);
        }

        return merged;
    }

    public static void main(String[] args) {
        //int[][] intervals = {{1, 3}, {2, 6}, {5, 10}, {9, 18}};
        int[][] intervals = {{0, 4}, {1, 4}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
