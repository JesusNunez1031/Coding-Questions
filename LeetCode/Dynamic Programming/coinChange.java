import java.util.Arrays;

public class coinChange {
    /*
    You are given coins of different denominations and a total amount of money amount. Write a function to compute the
    fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
    You may assume that you have an infinite number of each kind of coin.

    Example 1:
    Input: coins = [1,2,5], amount = 11
    Output: 3
    Explanation: 11 = 5 + 5 + 1

    Example 2:
    Input: coins = [2], amount = 3
    Output: -1

    Example 3:
    Input: coins = [1], amount = 0
    Output: 0

    Example 4:
    Input: coins = [1], amount = 1
    Output: 1

    Example 5:
    Input: coins = [1], amount = 2
    Output: 2

    Constraints:
        1 <= coins.length <= 12
        1 <= coins[i] <= 2^31 - 1
        0 <= amount <= 10^4
     */
    //TC: O(n * m) and O(n) space is used to store the sub-problems, where n is the amount and m is the number of given coins
    private static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);     //sort the coins array to ensure we don't compare coins of values larger than a target

        //0 indexed so we need to have amount + 1 indexes to access the index at amount
        int[] dp = new int[amount + 1];

        /*
            fill in all values with amount + 1, this is a flag, so if we cant make "amount" with given coins, we'll know
            since dp[amount] = amount + 1, so -1 will be returned
         */
        Arrays.fill(dp, amount + 1);

        //zeros ways to make up the value 0 with coins
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    /*
                        the problem to solve is what is the least number of coins we need to use to make the given amount,
                        to solve this, we solve that same problem for all values leading up to the amount, so that when
                        we get to the amount index, we would have solved all sub-problems and the solution is the best
                        solution for all indexes of [amount - coin] + 1 since we are adding one more coin

                        ex: given value of 4 and final target amount 11 and coins [1, 2, 5]
                            dp[i - coin] ==> dp[4 - 1] = dp[3], so we take the optimal solution for amount 3 which is 2,
                            one 1 coin and one 2 coin and compare it to the placeholder 12, 2 is smaller so optimal
                            solution for 4 becomes 3, we use one 2 coin and two 1 coins to make 4

                            then we come to coin 2, dp[4 - 2] = dp[2], optimal solution for 2 is 1, because we only use
                            one 2 coin, 2 is less than 3 since we directly use two 2 coins to make 4 so the new optimal
                            solution for 4 is 2 coins

                            coin 5 is larger in value than 4 so we break out of loop and move on to next amount of 5 and
                            repeat
                     */
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                } else {
                    /*
                        break out as soon as the value of the coin exceeds the value in i since there will be no ways to make
                        the value given coins larger than it
                    */
                    break;
                }
            }
        }
        //if the index at amount is unmodified from its placeholder value, then there are no ways to make change given the amount and coins
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}
