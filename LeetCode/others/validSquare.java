import java.util.HashSet;
import java.util.Set;

public class validSquare {
    /*
    Given the coordinates of four points in 2D space, return whether the four points could construct a square.
    The coordinate (x,y) of a point is represented by an integer array with two integers.

    Example:
    Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
    Output: True

    Note:
       1. All the input integers are in the range [-10000, 10000].
       2. A valid square has four equal sides with positive length and four equal angles (90-degree angles).
       3. Input points have no order.
     */

    //TC: O(1) SC: O(1)
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();

        //check all possible combinations of points for a square
        if (!checkSquare(p1, p2, set) ||
                !checkSquare(p1, p3, set) ||
                !checkSquare(p1, p4, set) ||
                !checkSquare(p2, p3, set) ||
                !checkSquare(p2, p4, set) ||
                !checkSquare(p3, p4, set)) {
            return false;
        }

        //a square can only have two values, size of the diagonal, and sides
        return set.size() == 2;
    }

    public static boolean checkSquare(int[] a, int[] b, Set<Integer> set) {

        //if the two points equal each other, a square is not possible
        if (a[0] == b[0] && a[1] == b[1]) {
            return false;
        }

        //distance of x coordinate
        int dx = a[0] - b[0];

        //distance of y coordinate
        int dy = a[1] - b[1];

        //distance of the points [actual distance formula is Math.sqrt(dx^2 + dy^2), however using sqrt add complexity to the program]
        int dist = dx * dx + dy * dy;

        //add the distance to the set, only two distance will be in set at the end if points given make a valid square, length of sides and diagonals
        set.add(dist);

        return true;
    }

    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};

        System.out.println(validSquare(p1, p2, p3, p4));
    }
}
