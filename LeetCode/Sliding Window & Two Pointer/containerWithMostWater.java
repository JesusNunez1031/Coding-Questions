public class containerWithMostWater {
    /*
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical
    lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together
    with the x-axis forms a container, such that the container contains the most water.
    Notice that you may not slant the container.

    Example 1:
    |
   8|_        _                        _
   7|_        |________________________|__________
   6|_        |    _                   |         |
   5|_        |    |         _         |         |
   4|_        |    |         |    _    |         |
   3|_        |    |         |    |    |    _    |
   2|_        |    |    _    |    |    |    |    |
   1|_   _    |    |    |    |    |    |    |    |
   0|____|____|____|____|____|____|____|____|____|_____
         1    8    6    2    5    4    8    3    7
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
    water ("______" section") the container can contain is 49.

    Example 2:
    Input: height = [1,1]
    Output: 1

    Example 3:
    Input: height = [4,3,2,1,4]
    Output: 16

    Example 4:
    Input: height = [1,2,1]
    Output: 2

    Constraints:
        n = height.length
        2 <= n <= 3 * 10^4
        0 <= height[i] <= 3 * 10^4
     */
    private static int maxArea(int[] height) {
        /*
            if the length of the height array is 2, we return the length of the shortest vertical line since that
            is the max bound of water
         */
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        int i = 0;
        int j = height.length - 1;
        int area = 0;

        while (i < j) {
            /*
                the area between i and j, is the minimum value of the vertical line of i and j * the distance between i and j
             */
            area = Math.max(area, Math.min(height[i], height[j]) * (j - i));

            /*
                if the value if rod i is greater then j, we move j in, otherwise we move i out
             */
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] water = {4, 3, 2, 1, 4};
        System.out.println(maxArea(water));
    }
}
