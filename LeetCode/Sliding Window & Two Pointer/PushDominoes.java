public class PushDominoes {
    /*
    There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously
    push some of the dominoes either to the left or to the right.

    After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the
    dominoes falling to the right push their adjacent dominoes standing on the right.

    When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

    For the purposes of this question, we will consider that a falling domino expends no additional force to a falling
    or already fallen domino.

    You are given a string dominoes representing the initial state where:
       - dominoes[i] = 'L', if the ith domino has been pushed to the left,
       - dominoes[i] = 'R', if the ith domino has been pushed to the right, and
       - dominoes[i] = '.', if the ith domino has not been pushed.
    Return a string representing the final state.

    Example 1:
    Input: dominoes = "RR.L"
    Output: "RR.L"
    Explanation: The first domino expends no additional force on the second domino.

    Example 2:
    Input: dominoes = ".L.R...LR..L.."
    Output: "LL.RR.LLRRLL.."

    Constraints:
        n == dominoes.length
        1 <= n <= 105
        dominoes[i] is either 'L', 'R', or '.'.
     */

    //TC/SC: O(n)
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();

        int[] left = new int[n]; //check for dominoes going left, i.e. from the end of the array
        int nearestLeft = -1; //the index of the last domino going left
        for (int i = n - 1; i >= 0; i--) {
            char d = dominoes.charAt(i);

            //when a domino is going left, the current index becomes the new nearestLeft
            if (d == 'L') {
                nearestLeft = i;
            }
            //a domino going right would cancel any left momentum
            else if (d == 'R') {
                nearestLeft = -1;
            }

            left[i] = nearestLeft;
        }

        //perform the same operations but now for dominoes going right
        int[] right = new int[n]; //check for dominoes going right, i.e. from the start of the array
        int nearestRight = -1; //the index of the last domino going right
        for (int i = 0; i < n; i++) {
            char d = dominoes.charAt(i);

            //when a domino is going right, the current index becomes the new nearestLeft
            if (d == 'R') {
                nearestRight = i;
            }
            //a domino going left would cancel any right momentum
            else if (d == 'L') {
                nearestRight = -1;
            }

            right[i] = nearestRight;
        }

        char[] newDominoes = new char[n];

        for (int i = 0; i < n; i++) {

            //check if the domino was influenced by any left or right momentum
            if (dominoes.charAt(i) == '.') {
                nearestLeft = left[i];
                nearestRight = right[i];

                /*
                    calculate the difference in distance between the current index and the left and right indexes
                    this will help determine which momentum is stronger on the domino or if the domino at i
                    remains still, i.e. left and right have equal force on the domino

                    if an index has a value of -1, we use MAX_VALUE so if an index -1 and another is not, we don't
                    confuse -1 as being closer, using MAX_VALUE ensures we always have a larger index
                */
                int leftDiff = nearestLeft == -1 ? Integer.MAX_VALUE : Math.abs(nearestLeft - i);
                int rightDiff = nearestRight == -1 ? Integer.MAX_VALUE : Math.abs(nearestRight - i);

                //if both distance are equal, the domino is under equal force from left and right hence it remains still
                if (leftDiff == rightDiff) {
                    newDominoes[i] = '.';
                }
                //a lower leftDiff means the current ith domino has a stronger left momentum
                else if (leftDiff < rightDiff) {
                    newDominoes[i] = 'L';
                }
                //a lower rightDiff means the current ith domino has a stronger right momentum
                else {
                    newDominoes[i] = 'R';
                }
            }
            // L and R dominoes will remain unchanged
            else {
                newDominoes[i] = dominoes.charAt(i);
            }
        }
        return new String(newDominoes);
    }
}
