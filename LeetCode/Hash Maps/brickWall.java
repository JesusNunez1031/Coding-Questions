import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class brickWall {
    /*
    There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the
    same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

    The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick
    in this row from left to right.

    If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how
    to draw the line to cross the least bricks and return the number of crossed bricks.

    You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously
    cross no bricks.

    Example:
    Input: [[1,2,2,1],
            [3,1,2],
            [1,3,2],
            [2,4],
            [3,1,2],
            [1,3,1,1]]
    Output: 2
    Explanation:              |
    [  1  ][     2     ][     2     ][  1   ]
    [        3         ][  1  ][     2      ]
    [  1  ][        3         ][     2      ]
    [     2     ][            4             ]
    [        3         ][  1  ][     2      ]
    [  1  ][        3         ][  1  ][  1  ]
                               |
               a line through here passes through 2 and 4 only

    Note:
        The width sum of bricks in different rows are the same and won't exceed INT_MAX.
        The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of
        bricks of the wall won't exceed 20,000.
     */
    //TC: O(n * m) where m is the number of rows, and n is the number of columns and O(n) space
    public int leastBricks(List<List<Integer>> wall) {
        //value holds the number of bricks not touching, i.e. edge through which the line can pass without hitting other bricks
        int untouched = 0;

        //map holds the brick number and number of times it shows up in the wall
        Map<Integer, Integer> map = new HashMap<>();

        /*
            The idea is to calculate and store all the edge indices in the wall and figure out which edge index is the
            most common, so rather than directly trying to find places where lines touch the fewest bricks, we just look
            for where each line touched the most edges, i.e. look for the max count of edges present in wall
         */
        for (List<Integer> row : wall) {
            int edge = 0; //used to calculate the prefix sum up to ith value

            /*
                -1 since we don't want to consider borders, otherwise the result would always be 0 since running a line
                down the last edge would pass through no bricks
             */
            for (int brick = 0; brick < row.size() - 1; brick++) {
                edge += row.get(brick); //add to the prefix sum

                //add the prefix sum of the current index to the map or increase its count
                map.put(edge, map.getOrDefault(edge, 0) + 1);

                /*
                    untouched is the brick with the highest edge count, hence we update it if an edge has increased in
                    count larger than the current untouched value
                 */
                untouched = Math.max(untouched, map.get(edge));
            }
        }

        /*
            untouched has the max number of edges touched by any line in the wall, hence by subtracting this value from
            the total number of rows, we get the number rows we can pass while hitting the min number of bricks
         */
        return wall.size() - untouched;
    }
}
