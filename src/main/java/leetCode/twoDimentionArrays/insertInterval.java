package leetCode.twoDimentionArrays;

import java.util.ArrayList;
import java.util.List;

public class insertInterval {
    /*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    You may assume that the intervals were initially sorted according to their start times.

    Example 1:
    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]

    Example 2:
    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

    Example 3:
    Input: intervals = [], newInterval = [5,7]
    Output: [[5,7]]

    Example 4:
    Input: intervals = [[1,5]], newInterval = [2,3]
    Output: [[1,5]]

    Example 5:
    Input: intervals = [[1,5]], newInterval = [2,7]
    Output: [[1,7]]

    Constraints:
        0 <= intervals.length <= 10^4
        intervals[i].length == 2
        0 <= intervals[i][0] <= intervals[i][1] <= 10^5
        intervals is sorted by intervals[i][0] in ascending order.
        newInterval.length == 2
        0 <= newInterval[0] <= newInterval[1] <= 10^5
     */

    //TC: O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        //list to hold intervals
        List<int[]> list = new ArrayList<>();
        boolean merged = false; //flag to check if newInterval has been merged

        for (int[] interval : intervals) {
            if (!merged) {
                /*
                    if the newIntervals start time is greater than the end time of the current interval, we need to move
                    to the next interval
                 */
                if (newInterval[0] > interval[1]) {
                    list.add(interval);
                }
                /*
                    If the newIntervals end time is less than the start time of the current interval, the newInterval
                    belongs in between the previous interval and the current interval
                 */
                else if (newInterval[1] < interval[0]) {
                    list.add(newInterval);
                    merged = true;
                    list.add(interval);
                }
                /*
                    if we cant move to a next interval or merge yet, to avoid any merge conflicts, we update the start and
                    end times of the newInterval to make sure that if it lies in between an interval it gets changed
                 */
                else {
                    newInterval[0] = Math.min(newInterval[0], interval[0]);
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                }
            }
            //if the newInterval has already been added, just add remaining intervals
            else {
                list.add(interval);
            }
        }

        /*
            after going through all intervals, if the new interval has not been merged, then it must be larger than the
            last interval therefore we just add it to the end
         */
        if (!merged) {
            list.add(newInterval);
        }

        //turn the list into a matrix
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
