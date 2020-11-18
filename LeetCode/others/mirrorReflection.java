public class mirrorReflection {
    /*
    There is a special square room with mirrors on each of the four walls.  Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.
    The square room has walls of length p, and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.

    Return the number of the receptor that the ray meets first.  (It is guaranteed that the ray will meet a receptor eventually.)


    Example 1:
    Input: p = 2, q = 1
    Output: 2
    Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.
    2_______________1
    |*              |       * indicate the start of the laser and where it bounced and ends.
    |               |
    |              *|
    |               |
    |*______________|
                     0
    Note:

    1 <= p <= 1000
    0 <= q <= p
     */

    //TC: O(log P) and constant space
    //extension * p = reflection * q;
    public int mirrorReflection(int p, int q) {
        int ext = q;
        int reflection = p;

        //we need either p or q to be odd to satisfy the condition of since its not possible for p and q to both be even
        while (ext % 2 == 0 && reflection % 2 == 0) {
            //divide by 2
            ext /= 2;
            reflection /= 2;
        }

        //fist case where if we extend the square to 2, the reflection will always hit 0
        if (ext % 2 == 0 && reflection % 2 != 0) {
            return 0;
        }

        //no extension is required so its odd and the reflection will hit two
        if (ext % 2 != 0 && reflection % 2 == 0) {
            return 2;
        }

        //the final case the reflection points to one instantly when both extension ans reflection are odd
        return 1;
    }
}
