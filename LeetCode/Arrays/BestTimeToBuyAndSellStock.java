public class BestTimeToBuyAndSellStock {

    /*
    Say you have an array for which the ith element is the price of a given stock on day i.
    If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    Note that you cannot sell a stock before you buy one.

    Example 1:

    Input: [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
                 Not 7-1 = 6, as selling price needs to be larger than buying price.
     */

    public static int maxProfit(int[] prices) {
        int min_val = Integer.MAX_VALUE;
        int max_profit = 0;

        for (int price : prices) {
            /*Get the smallest value possible as we iterate through array, if the array happens to be in descending order, there is no way to get a max_profit,
              since we would always sell for a loss
             */
            if (price < min_val) {
                min_val = price;
                //If the current value is - our current min_val is greater than the current max profit, make that subtraction our new max
            } else if (price - min_val > max_profit) {
                max_profit = price - min_val;
            }
        }
        return max_profit;
    }
}
