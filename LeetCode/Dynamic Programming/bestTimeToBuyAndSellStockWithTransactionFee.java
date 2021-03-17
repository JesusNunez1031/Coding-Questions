public class bestTimeToBuyAndSellStockWithTransactionFee {
    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee
    representing a transaction fee.

    Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the
    transaction fee for each transaction.
    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

    Example 1:
    Input: prices = [1,3,2,8,4,9], fee = 2
    Output: 8
    Explanation: The maximum profit can be achieved by:
    - Buying at prices[0] = 1
    - Selling at prices[3] = 8
    - Buying at prices[4] = 4
    - Selling at prices[5] = 9
    The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

    Example 2:
    Input: prices = [1,3,7,5,10,3], fee = 3
    Output: 6

    Constraints:
        1 < prices.length <= 5 * 10^4
        0 < prices[i], fee < 5 * 10^4
     */
    //TC: O(n) and O(n) space due to the use of a dp array
    public static int maxProfit(int[] prices, int fee) {
        //if there is one stock or less, we cant make any transactions
        if (prices.length <= 1) {
            return 0;
        }

        /*
            dp array to hold all our transactions, 2 columns for each ith day, the first column is if we don't want to
            have a stock on the ith day, dp[i][0].
            If we don't want to have a stock we do one of two things that yields the most,
                1. sell the stock today
                    dp[i][0] = dp[i - 1][1] + prices[i]
                   since dp[i-1][1] holds -prices[i] - fee, adding prices[i] to it reflects selling
                2. Do nothing since the stock was sold at a different day
                    dp[i][0] = dp[i - 1][0]
                if selling a stock on this day yields more than selling on a previous day, we sell, otherwise the value
                today remains the value from a previous sell

            the other column is if we have a stock, dp[i][1], and we do one of two things that yields the most,
                1. We buy a new stock on the given day
                    dp[i][1] = dp[i][0] - prices[i] - fee
                2. Or we just hold a stock we have previously bought
                    dp[i][1] = dp[i-1][1]
                if buying a stock on this day yields more than just holding, we sell, otherwise we just hold
        */
        int[][] dp = new int[prices.length][2];

        //day 0 we have 0 if no stocks are bought
        dp[0][0] = 0;

        //we've bought a stock on the first day and apply the fee, -prices to reflect we've purchased the first stock
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < prices.length; i++) {
            //we don't want to have a stock today so we either sell a stock today, or sold at a previous day
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);

            //we want to have a stock today so we either buy a new stock, or just hold a previous stock
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i] - fee, dp[i - 1][1]);
        }

        //we return dp[n - 1][0] because on this day we don't want to be holding any stocks
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }
}
