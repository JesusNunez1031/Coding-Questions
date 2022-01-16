public class MaximizeDistanceToClosestPerson {
    /*
    You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat,
    and seats[i] = 0 represents that the ith seat is empty (0-indexed).

    There is at least one empty seat, and at least one person sitting.
    Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
    Return that maximum distance to the closest person.

    Example 1:
    Input: seats = [1,0,0,0,1,0,1]
    Output: 2
    Explanation:
    If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
    If Alex sits in any other open seat, the closest person has distance 1.
    Thus, the maximum distance to the closest person is 2.

    Example 2:
    Input: seats = [1,0,0,0]
    Output: 3
    Explanation:
    If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
    This is the maximum distance possible, so the answer is 3.

    Example 3:
    Input: seats = [0,1]
    Output: 1

    Constraints:
        2 <= seats.length <= 2 * 10^4
        seats[i] is 0 or 1.
        At least one seat is empty.
        At least one seat is occupied.
     */
    //TC: O(n)
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0, previousPerson = -1;
        int n = seats.length;

        for (int i = 0; i < seats.length; i++) {
            /*
                when a person seated is encountered, we check if its the first person seen, if so the max distance is the
                number of seats we have passed up till now, otherwise, the max distance is the largest value between the current
                max and the distance between the current person and the last, /2 since we want to be right in between them
                otherwise we would be closer to one person
             */
            if (seats[i] == 1) {
                maxDistance = previousPerson < 0 ? i : Math.max(maxDistance, (i - previousPerson) / 2);
                previousPerson = i; // update the last seen persons position
            }
        }

        // check to see if sitting at the last seat yields a greater distance once we are done
        maxDistance = Math.max(maxDistance, n - 1 - previousPerson);

        return maxDistance;
    }
}
