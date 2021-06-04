import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    /*
    Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts where
    horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly,
    verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.

    Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the
    arrays horizontalCuts and verticalCuts. Since the answer can be a huge number, return this modulo 10^9 + 7.

    Example 1:
             0  1  2  3  4
         0 |    |     |
         1 |____|_____|___
         2 |____|_____|___
         3 |    |  X  |
         4 |____|_____|___
         5 |    |     |
    Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
    Output: 4
    Explanation: The figure above represents the given rectangular cake. The lines are the horizontal and vertical cuts.
    After you cut the cake, the X piece of cake has the maximum area.

    Example 2:
                1  2  3  4
         1 |____|_________
         2 |    |    X
         3 |____|_________
         4 |    |    Y
         5 |    |
    Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
    Output: 6
    Explanation: The figure above represents the given rectangular cake. The lines are the horizontal and vertical cuts.
    After you cut the cake, the X and Y pieces of cake have the maximum area.

    Example 3:
    Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
    Output: 9

    Constraints:
        2 <= h, w <= 10^9
        1 <= horizontalCuts.length < min(h, 10^5)
        1 <= verticalCuts.length < min(w, 10^5)
        1 <= horizontalCuts[i] < h
        1 <= verticalCuts[i] < w
        It is guaranteed that all elements in horizontalCuts are distinct.
        It is guaranteed that all elements in verticalCuts are distinct.
     */
    //TC: O(n log n) + O(m log m) where n is the length of the horizontalCuts and m is the length of the verticalCuts
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        /*
            sort both the cut arrays, this will allow us to find the width between every cut
            which can be used to compare with previous larger area's
        */
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        /*
            all that we have to do is find the largest height between two horizontal cuts and the largest
            width between two vertical cuts. Once we have these values, we multiply them and guarantee the
            max area since the largest gaps will definitely be in the largest area
        */

        int n = horizontalCuts.length, m = verticalCuts.length;

        /*
            compare the first two cuts using 0 and h - last cut, this avoids skipping a large first cut, e.g.
            if h = 5 and the hCuts = [3, 4], by not calculating 3-0 we skip over the largest gap in the horizontal cuts
            and get a max height of 1 which is not correct.

            the same applies if the largest gap is at the end, e.g. if h = 5 and hCuts = [1, 2], by not calculating
            5 - 2, we get a maxHeight of 1 when it should have been 3
         */
        int maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);

        //iterate through the each of the cuts, find the width between two cuts and compare it to the current maxHeight
        for (int i = 1; i < n; i++) {
            int horizontalWidth = horizontalCuts[i] - horizontalCuts[i - 1];
            maxHeight = Math.max(maxHeight, horizontalWidth);
        }

        //compare the first two cuts 0, and w - the last cut, same as we did for horizontal cuts
        int maxWidth = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);
        for (int i = 1; i < m; i++) {
            int verticalWidth = verticalCuts[i] - verticalCuts[i - 1];
            maxWidth = Math.max(maxWidth, verticalWidth);
        }

        //cast the result to long so as to not lose data
        long area = (long) maxHeight * maxWidth;

        //multiply area by 10^9 + 7 since might be large
        return (int) (area % ((1e9) + 7));
    }
}
