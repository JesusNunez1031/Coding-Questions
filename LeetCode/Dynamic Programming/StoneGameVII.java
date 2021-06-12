import java.util.Arrays;

public class StoneGameVII {
    /*
    Alice and Bob take turns playing a game, with Alice starting first.

    There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone or the
    rightmost stone from the row and receive points equal to the sum of the remaining stones' values in the row. The
    winner is the one with the higher score when there are no stones left to remove.

    Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the score's
    difference. Alice's goal is to maximize the difference in the score.

    Given an array of integers stones where stones[i] represents the value of the ith stone from the left, return the
    difference in Alice and Bob's score if they both play optimally.

    Example 1:
    Input: stones = [5,3,1,4,2]
    Output: 6
    Explanation:
    - Alice removes 2 and gets 5 + 3 + 1 + 4 = 13 points. Alice = 13, Bob = 0, stones = [5,3,1,4].
    - Bob removes 5 and gets 3 + 1 + 4 = 8 points. Alice = 13, Bob = 8, stones = [3,1,4].
    - Alice removes 3 and gets 1 + 4 = 5 points. Alice = 18, Bob = 8, stones = [1,4].
    - Bob removes 1 and gets 4 points. Alice = 18, Bob = 12, stones = [4].
    - Alice removes 4 and gets 0 points. Alice = 18, Bob = 12, stones = [].
    The score difference is 18 - 12 = 6.

    Example 2:
    Input: stones = [7,90,5,1,100,10,10,2]
    Output: 122

    Constraints:
        n == stones.length
        2 <= n <= 1000
        1 <= stones[i] <= 1000
     */
    //TC: O(n ^ 2) since we check for all possible combinations of stone scores
    public int stoneGameVII(int[] stones) {
        //dp array used to check every array that can be formed by removing stones
        int[][] dp = new int[stones.length][stones.length];

        //mark all cells as unvisited
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int sum = 0;
        //get the total sum of values of stones
        for (int val : stones) {
            sum += val;
        }

        return dfs(0, stones.length - 1, dp, stones, sum);
    }

    private int dfs(int start, int end, int[][] dp, int[] stones, int total) {
        if (start > end) {
            return 0;
        }

        //if only two stones are in the array, return the larger of the two
        if (end - start == 1) {
            return Math.max(stones[start], stones[end]);
        }

        //check if we have calculated the stone sum of an index and return it, memoization
        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        /*
            the current max sum for an index for a combination of stones used will be the max value between the (total
            sum - taking a stone from the front - calculating the same for the rest of the array changing the total sum
            by subtracting the value of the front stone) and (the same as before but now taking stones from the end)
         */
        return dp[start][end] = Math.max(total - stones[start] - dfs(start + 1, end, dp, stones,
                total - stones[start]), total - stones[end] - dfs(start, end - 1, dp, stones, total - stones[end]));
    }

    //TC: O(n ^ 2) better than previous method since we don't have to recurse to find all possible combinations
    public static int stoneGameVIIEz(int[] stones) {
        //dp[j] = maximum value of score(current player) - score(other player) using stones[i..j]
        int[] dp = new int[stones.length];
        int n = stones.length;

        /*
            starting from the last stone, if the first player Alice removes stone[i],
                - score(Alice) increases by sum[i + 1...j] which also increases the score difference by the same amount
                - the game continues with the next player Bob, where dp[j] represents the score difference from the other
                  player's point of view so to use it we negate it, i.e. -dp[j]
                - the above also applies similarly to stones[j]
             so dp[j] = Math.max(sum of stones[i+1..j] - stones[i] - dp[j], sum - stones[j] - dp[j - 1]);
         */
        for (int i = n - 1; i >= 0; i--) {
            int sum = stones[i];
            for (int j = i + 1; j < n; j++) {
                sum += stones[j];
                dp[j] = Math.max(sum - stones[i] - dp[j], sum - stones[j] - dp[j - 1]);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] stones = {5, 3, 1, 4, 2};
        stoneGameVIIEz(stones);
    }
}
