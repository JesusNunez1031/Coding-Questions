import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nonOverlappingIntervals {
    /*
    Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the
    intervals non-overlapping.

    Example 1:
    Input: [[1,2],[2,3],[3,4],[1,3]]
    Output: 1
    Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.

    Example 2:
    Input: [[1,2],[1,2],[1,2]]
    Output: 2
    Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.

    Example 3:
    Input: [[1,2],[2,3]]
    Output: 0
    Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

    Note:
        You may assume the interval's end point is always bigger than its start point.
        Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
     */

    //TC/S: O(n) time and constant space used since we just use a reference to the previous non-overlapping intervals end time
    private int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        //sort intervals by their start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        //set the end time to the end time of the first interval in the array so we can compare the current interval with the previous
        int end_time = intervals[0][1];
        int deleted = 0;    //counter for number of intervals to delete

        for (int i = 1; i < intervals.length; i++) {
            /*
                if the current intervals start time is less than the end time of the previous, the current interval is
                overlapping with a previous interval so we want to delete it. Increment the "deleted" counter and update
                the end_time to the smallest value between the last interval or the current interval. We want the smallest
                end_time to reduce the amount of future overlaps.
            */
            if (intervals[i][0] < end_time) {
                deleted++;
                end_time = Math.min(end_time, intervals[i][1]);
            } else {
                //if there is no overlap between the current interval and the previous, then we update the end time to the current interval
                end_time = intervals[i][1];
            }
        }
        //return the number of deleted intervals
        return deleted;
    }

    //TC/S: O(n) time and space used in this approach, we used an extra list and only add the intervals that do not overlap
    private int eraseOverlapIntervalsS(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        //sort intervals by their start times and then by their end times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        List<int[]> list = new ArrayList<>();

        //add the first interval to the list so we can always compare the current interval with the previous
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            /*
                we only want to add the intervals that don't overlap, so we check if the end time of the previous interval
                is less than the start time of the current interval, if so we add it to the list of intervals
            */
            int prev_end_time = list.get(list.size() - 1)[1];
            if (prev_end_time <= intervals[i][0]) {
                list.add(intervals[i]);
            }
        }
        //the difference of the list to the intervals array gives us the number of deleted intervals
        return intervals.length - list.size();
    }
}
