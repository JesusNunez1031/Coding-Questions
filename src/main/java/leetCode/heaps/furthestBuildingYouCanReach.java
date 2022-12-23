package leetCode.heaps;

import java.util.PriorityQueue;

public class furthestBuildingYouCanReach {
    /*
    You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.

    You start your journey from building 0 and move to the next building by possibly using bricks or ladders.

    While moving from building i to building i+1 (0-indexed),
        - If the current building's height is greater than or equal to the next building's height, you do not need a
          ladder or bricks.
        - If the current building's height is less than the next building's height, you can either use one ladder or
          (h[i+1] - h[i]) bricks.

    Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.

    Example 1:
                                         14
                                       |-----|
                                       |-----|  12
                                       |-----||-----|
                                       |-----||-----|
                                   9   |-----||-----|
                                |-----||-----||-----|
                     7          |-----||-----||-----|
                  |-----|   6   |-----||-----||-----|
                  |-----||-----||-----||-----||-----|
       4          |-----||-----||-----||-----||-----|
    |-----|       |-----||-----||-----||-----||-----|
    |-----|   2   |-----||-----||-----||-----||-----|
    |-----||-----||-----||-----||-----||-----||-----|
    |-----||-----||-----||-----||-----||-----||-----|
       0      1      2      3      4      5      6     <--- Building numbers
    Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
    Output: 4
    Explanation: Starting at building 0, you can follow these steps:
    - Go to building 1 without using ladders nor bricks since 4 >= 2.
    - Go to building 2 using 5 bricks. You must use either bricks or ladders because 2 < 7.
    - Go to building 3 without using ladders nor bricks since 7 >= 6.
    - Go to building 4 using your only ladder. You must use either bricks or ladders because 6 < 9.
    It is impossible to go beyond building 4 because you do not have any more bricks or ladders.

    Example 2:
    Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
    Output: 7

    Example 3:
    Input: heights = [14,3,19,3], bricks = 17, ladders = 0
    Output: 3

    Constraints:
        1 <= heights.length <= 105
        1 <= heights[i] <= 106
        0 <= bricks <= 109
        0 <= ladders <= heights.length
     */
    //TC: O(n log m) where n is the number of buildings and m is the number of ladders since it takes log n time to add to PQ
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;

        /*
            Priority Queue stores the heights for which ladders are used, when the queue's size exceeds the amount of
            ladders available for use, we remove the smallest height climbed "e" and try to make up this height "e" with
            bricks, if the height requires the use of more bricks than those available, i-1 position is the furthest
            we've made it since at every step we are checking one building ahead
        */
        PriorityQueue<Integer> heights_climbed = new PriorityQueue<>();
        int bricks_used = 0; //keeps track of bricks used so far

        //start at the second building so we can check how to get from first to second building
        for (int i = 1; i < n; i++) {
            /*
                difference in height between the current building and the previous, if negative we just jump, if its > 0,
                we check if we can actually be at ith building
            */
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                heights_climbed.offer(diff);

                //when we've run out of ladders, remove the smallest height from the PQ and replace the ladder use with bricks
                if (heights_climbed.size() > ladders) {
                    bricks_used += heights_climbed.remove();

                    /*
                        if at any step we use more bricks than those available, we cant actually be at ith building
                        hence ith - 1 is the furthest we can traverse
                     */
                    if (bricks_used > bricks) {
                        return i - 1;
                    }
                }
            }
        }
        //we've made it to the last to building
        return n - 1;
    }
}
