package leetCode.slidingWindow_twoPointer;

public class TrappingRainWater {
    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
    it can trap after raining.

    Example 1:
   3|_
   2|_                                      |
   1|_                  |                   |    |       |
   0|_________|_________|____|_________|____|____|___|___|___|
         0    1    0    2    1    0    1    3    2   1   2   1
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (| bars) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this
    case, 6 units of rain water (blue section) are being trapped.

    Example 2:
    Input: height = [4,2,0,3,2,5]
    Output: 9

    Constraints:
        n == height.length
        0 <= n <= 3 * 10^4
        0 <= height[i] <= 10^5
     */
    //TC: O(n) and O(1) space
    public int trap(int[] height) {
        int n = height.length;
        // at least 3 bars are needed to trap water, otherwise the water would just run off
        if (n < 3) {
            return 0;
        }

        // keep track of the largest values from the left and right, they will be updated as heights are traversed. The first and last bars are used as the max since they cannot trap water
        int maxLeft = height[0];
        int maxRight = height[n - 1];

        int trappedWater = 0;

        // start at the bars that will allow for water to be trapped second bar and second to last bar
        int left = 1;
        int right = n - 2;

        while (left <= right) {
            // if at the current bar, the largest bar at the left is lower, this will serve as the upper bound for trapped water
            if (maxLeft < maxRight) {
                // update the maxLeft if the current bar is larger
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    /*
                        if the current bar is shorter than the largest left, then the amount of trapped water at this
                        bar is the difference between the largest bar at the left and the current bar's height, this is
                        the gap where water is stored
                     */
                    trappedWater += maxLeft - height[left];
                }
                left++; //move to next bar
            }
            // the largest bar is at the left hence we use the smaller height, the right bar
            else {
                // update the maxRight if the current bar is larger
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    trappedWater += maxRight - height[right];
                }
                right--; //move to the next bar
            }
        }
        return trappedWater;
    }
}
