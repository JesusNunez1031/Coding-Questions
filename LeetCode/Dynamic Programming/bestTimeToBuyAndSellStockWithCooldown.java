public class bestTimeToBuyAndSellStockWithCooldown {
    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell
    one share of the stock multiple times) with the following restrictions:

    After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
    Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

    Example 1:
    Input: prices = [1,2,3,0,2]
    Output: 3
    Explanation: transactions = [buy, sell, cooldown, buy, sell]

    Example 2:
    Input: prices = [1]
    Output: 0

    Constraints:
        1 <= prices.length <= 5000
        0 <= prices[i] <= 1000
     */
    //TC: O(n) and O(n) space since we store values into dp array
    public int maxProfit(int[] prices) {
        //not enough stocks to make transactions
        if (prices.length <= 1) {
            return 0;
        }

        //if there are only 2 stocks and we can buy low and sell high, return the profit
        if (prices.length == 2 && prices[1] > prices[0]) {
            return prices[1] - prices[0];
            //if we can only buy high and sell low, there can be no profit
        } else if (prices.length == 2 && prices[0] > prices[1]) {
            return 0;
        }

        /*
            the dp array holds 2 possibilities for every ith day,
            case 1: dp[i][0], we have no stock on ith day, the value at this day will be the max of,
                - Selling the stock held today
                    dp[i-1][1] + prices[i], +prices[i] since we gain the difference between the value of dp[i-1][1], which
                    should be -prices[i - 1] if we bought a stock
                - I am holding profit from previous transactions
                    dp[i-1][0]

            case 2: dp[i][1], we have a stock on the ith day, the value at this day will be the max of,
                - Buying a stock today
                    dp[i - 2][0] - prices[i], we do i - 2 due to the cooldown not letting us buy every day
                - We are holding a stock bought from a previous day
                    dp[i- 1][1]

        */
        int[][] dp = new int[prices.length][2];

        //day 1, i.e. i == 0
        dp[0][0] = 0;          //no stocks held today
        dp[0][1] = -prices[0]; //a stock was bought on the first day

        //day 2, i.e. i == 1
        //to not have a stock today we either sell the stock we are holding, or continue holding profit, e.g. cash
        dp[1][0] = Math.max(dp[0][1] + prices[1], dp[0][0]);
        //to have a stock today, we can either buy a stock today, or hold the stock bought from the first day
        dp[1][1] = Math.max(dp[0][0] - prices[1], dp[0][1]);

        for (int i = 2; i < prices.length; i++) {
            //to not have a stock today, either sell the stock we are holding, or we continue holding profit
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            //To have a stock today, either by the stock from 2 days ago since there is a cooldown, or we hold a previously bought stock
            dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);
        }
        //we only have profits when we are not holding any stocks so we return the value for the last day we don't hold stock
        return dp[prices.length - 1][0];
    }
}
