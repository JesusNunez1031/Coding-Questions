package leetCode.greedyAlgorithms;

public class StoneGame {
    /*
    Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile
    has a positive integer number of stones piles[i].

    The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.

    Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either
    the beginning or the end of the row.  This continues until there are no more piles left, at which point the person
    with the most stones wins.

    Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.

    Example 1:
    Input: piles = [5,3,4,5]
    Output: true
    Explanation:
    Alex starts first, and can only take the first 5 or the last 5.
    Say he takes the first 5, so that the row becomes [3, 4, 5].
    If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
    If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
    This demonstrated that taking the first 5 was a winning move for Alex, so we return true.

    Constraints:
        2 <= piles.length <= 500
        piles.length is even.
        1 <= piles[i] <= 500
        sum(piles) is odd.
     */
    //TC: O(n)
    public boolean stoneGame(int[] piles) {
        int i = 0;
        int j = piles.length - 1;
        int alex = 0;
        int lee = 0;

        /*
            The goal is to check if Alex will end up with a higher score than lee, since both players play optimally and
            Alex starts, every time Alex is going to choose a stone, he will pick the stone with the highest value which
            leaves Lee with the only option of the smaller stone. Hence, we repeat these actions for both players, if at
            any point Alex has a higher score than lee, we return true.
         */
        while (i < j) {
            alex += Math.max(piles[i], piles[j]);
            lee += Math.min(piles[i], piles[j]);
            i++;
            j--;

            if (alex > lee) {
                return true;
            }
        }

        //Notice how Alex will always win since he always starts
        return false;
    }
}
