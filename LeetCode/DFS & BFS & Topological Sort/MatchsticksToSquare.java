import java.util.Arrays;

public class MatchsticksToSquare {
    /*
    You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use
    all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick
    must be used exactly one time.

    Return true if you can make this square and false otherwise.

    Example 1:
    --->--->
    I      |
    I      |
    --->--->
    Input: matchsticks = [1,1,2,2,2]
    Output: true
    Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.

    Example 2:
    Input: matchsticks = [3,3,3,3,4]
    Output: false
    Explanation: You cannot find a way to form a square with all the matchsticks.

    Constraints:
        1 <= matchsticks.length <= 15
        0 <= matchsticks[i] <= 10^9
     */
    //TC: O(4 ^ n) where n is the number of matchsticks available, all possible combinations are checked
    public boolean makesquare(int[] matchsticks) {
        //check if there are at least 4 possible sides
        if (matchsticks.length < 4) {
            return false;
        }

        //calculate the perimeter of the square
        int perimeter = 0;
        for (int stick : matchsticks) {
            perimeter += stick;
        }

        //a square cant be made if the perimeter cant be divided evenly into 4 parts
        if (perimeter % 4 != 0) {
            return false;
        }

        //each side must be 1/4 of the perimeter
        int side = perimeter / 4;

        //array of 4 sides, if a square can be made, using matchsticks, each side will be reduced to 0
        int[] sides = {side, side, side, side};

        //sort the matchsticks so the use of matchsticks is uniform
        Arrays.sort(matchsticks);

        //start the search from the largest stick
        return formSquare(matchsticks, matchsticks.length - 1, sides);
    }

    private boolean formSquare(int[] matchsticks, int i, int[] sides) {
        //once all matchsticks have been used a square has been made
        if (i < 0) {
            return true;
        }

        /*
            loop through all the 4 possible sides and reduce each side by matchsticks[i] if the the matchsticks' value
            is not larger than the sides[i] value
        */
        for (int j = 0; j < 4; j++) {
            //reduce the side by the current match stick if using it does not reduce the side below 0
            if (sides[j] - matchsticks[i] >= 0) {
                sides[j] -= matchsticks[i];

                //call the method again using the next matchstick
                if (formSquare(matchsticks, i - 1, sides)) {
                    return true;
                }
                //backtrack
                sides[j] += matchsticks[i];
            }
        }
        //square cant be made
        return false;
    }
}
