import java.util.Stack;

public class asteroidCollision {
    /*
    We are given an array asteroids of integers representing asteroids in a row.

    For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning
    right, negative meaning left). Each asteroid moves at the same speed.

    Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If
    both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

    Example 1:
    Input: asteroids = [5,10,-5]
    Output: [5,10]
    Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.

    Example 2:
    Input: asteroids = [8,-8]
    Output: []
    Explanation: The 8 and -8 collide exploding each other.

    Example 3:
    Input: asteroids = [10,2,-5]
    Output: [10]
    Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

    Example 4:
    Input: asteroids = [-2,-1,1,2]
    Output: [-2,-1,1,2]
    Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction
    never meet, so no asteroids will meet each other.

    Constraints:
        1 <= asteroids <= 10^4
        -1000 <= asteroids[i] <= 1000
        asteroids[i] != 0
     */
    //TC/S: O(n)
    private int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            //if the current asteroid is positive, add it to the stack
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                /*
                    if the asteroid is negative, simulate collisions with the top asteroid as long as the top asteroid is
                    not negative. All asteroids less than the current asteroid are destroyed.
                */
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                /*
                    if all asteroids were destroyed or the top asteroid is negative, add the current asteroid to the
                    stack since we cant destroy asteroids with the same trajectory
                 */
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);

                    //asteroids of equal size destroy each other
                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
            }
        }

        //add the remaining asteroids that were not destroyed to resulting array
        int[] remaining_asteroids = new int[stack.size()];

        //stack holds the asteroids in reverse order so we add starting from the end
        for (int i = stack.size() - 1; i >= 0; i--) {
            remaining_asteroids[i] = stack.pop();
        }
        return remaining_asteroids;
    }
}
