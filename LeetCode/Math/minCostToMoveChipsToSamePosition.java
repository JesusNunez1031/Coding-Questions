public class minCostToMoveChipsToSamePosition {
    /*
    We have n chips, where the position of the ith chip is position[i].
    We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:

        position[i] + 2 or position[i] - 2 with cost = 0.
        position[i] + 1 or position[i] - 1 with cost = 1.
        Return the minimum cost needed to move all the chips to the same position.

    Example 1:
    Input: position = [1,2,3]
    Output: 1
    Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
    Second step: Move the chip at position 2 to position 1 with cost = 1.
    Total cost is 1.

    Example 2:
    Input: position = [2,2,2,3,3]
    Output: 2
    Explanation: We can move the two chips at poistion 3 to position 2. Each move has cost = 1. The total cost = 2.

    Example 3:
    Input: position = [1,1000000000]
    Output: 1
     */
    public int minCostToMoveChips(int[] position) {
        int oddParity = 0, evenParity = 0;

        //parity changes increases cost only if we go from a negative to positive parity and vise versa

        //count the number of chips in odd and even parities
        for (int i : position) {
            if (i % 2 == 0) {
                evenParity++;
            } else {
                oddParity++;
            }
        }

        //if the parities are all odd or even, there is no cost to move chips
        if (evenParity == position.length || oddParity == position.length) {
            return 0;
        }

        //otherwise we return the min number of parity since we want to move the chips with lower parity to those with higher parity since it will cost less
        return Math.min(evenParity, oddParity);
    }
}
