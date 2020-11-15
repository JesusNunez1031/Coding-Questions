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
        //there is no possible chance to make profit
        if(prices == null || prices.length <= 1) {
            return 0;
        }

        int cheapestStock = Integer.MAX_VALUE;
        int max_profit = 0;

        for (int price : prices) {
            /*Get the smallest value possible as we iterate through array, if the array happens to be in descending order, there is no way to get a max_profit,
              since we would always sell for a loss
             */
            if (price < cheapestStock) {
                cheapestStock = price;
                //If the current value is - our current cheapestStock is greater than the current max profit, make that subtraction our new max
            } else if (price - cheapestStock > max_profit) {
                max_profit = price - cheapestStock;
            }
        }
        return max_profit;
    }

//    public int maxProfit(int[] prices) {
//        //there is no possible chance to make profit
//        if(prices == null || prices.length <= 1) {
//            return 0;
//        }
//
//        int profit = 0;
//        int cheapest = Integer.MAX_VALUE; //variable to hold our cheapest stock price
//
//        for(int i = 0; i < prices.length - 1;i++) {
//            //if the current value is smaller than our current cheapest, we update it
//            if(prices[i] < cheapest) {
//                cheapest = prices[i];
//            }
//            //if there is a stock we can trade, the max of the current trade is compared with the current higest profit, if its higher, we update it
//            if(prices[i] < prices[i + 1]) {
//                profit = Math.max(profit, prices[i + 1] - cheapest);
//            }
//        }
//        return profit;
//    }
}
