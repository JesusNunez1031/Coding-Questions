import java.util.Arrays;

public class markAndToys {
    /*
        Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some.
        There are a number of different toys lying in front of him, tagged with their prices. Mark has only a certain amount to spend, and he wants to maximize the number of toys he buys with this money.

        Given a list of prices and an amount to spend, what is the maximum number of toys Mark can buy? For example, if prices = [1, 2, 3, 4] and Mark has k = 7 to spend, he can buy items [1, 2, 3] for 6,
        or [3, 4] for 7 units of currency. He would choose the first group of 3 items.
     */

    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int toys = 0;

        for (int price : prices) {
            if (price < k && k - price > 0) {
                k -= price;
                toys++;
            }
        }
        return toys;
    }
}
