import java.util.Arrays;

public class minNumberOfArrowsToBurstBalloons {
    /*
    There are some spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and
    end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates
    of start and end of the diameter suffice. The start is always smaller than the end.

    An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend
    bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An
    arrow once shot keeps traveling up infinitely.

    Given an array points where points[i] = [xstart, xend], return the minimum number of arrows that must be shot to
    burst all balloons.

    Example 1:
    Input: points = [[10,16],[2,8],[1,6],[7,12]]
    Output: 2
    Explanation: One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another
    arrow at x = 11 (bursting the other two balloons).

    Example 2:
    Input: points = [[1,2],[3,4],[5,6],[7,8]]
    Output: 4

    Example 3:
    Input: points = [[1,2],[2,3],[3,4],[4,5]]
    Output: 2

    Example 4:
    Input: points = [[1,2]]
    Output: 1

    Example 5:
    Input: points = [[2,3],[2,3]]
    Output: 1

    Constraints:
        0 <= points.length <= 10^4
        points[i].length == 2
        -2^31 <= x_start < x_end <= 2^31 - 1
     */
    //TC: O(n log n) since we sort the points, constant space used
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        int arrows = 1; //at least one arrow will be shot if there are > 0 balloons

        //sort balloons by the value of the end
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int position_of_arrow = points[0][1]; //arrow fires from the end to cover max distance

        for (int i = 1; i < points.length; i++) {
            /*
                if the current balloons start is less than the current firing position of the arrow, we don't have to
                change positions since the balloons overlap and the position from where the arrow will be fired will also
                burst the current balloon.
                otherwise, if the start is greater than the position, we need another arrow to burst the new balloon
                so we increase the arrow count and move the new firing position to the end of current balloon

                Ex:
                    1__________6  7____________12
                       2_______6           10______________16
                i = 1: the initial arrow position is at 6 for the balloon 1,6, the current balloon is 2,6 and its
                x_start, 2, is less than 6 so we know we can burst the balloon shooting from 6

                i = 2: the next balloons start is greater than the firing position so we need to a new position and this
                implies we also need a new arrow so we set the new position to 12 and the number of arrows to fire increases

                i = 3: the start of the current balloon is 10 which is less than 12 which means we can pop the current
                balloon shooting from 12 so no new arrows needed.
            */
            if (points[i][0] > position_of_arrow) {
                position_of_arrow = points[i][1];
                arrows++;
            }
        }
        return arrows;
    }
}
