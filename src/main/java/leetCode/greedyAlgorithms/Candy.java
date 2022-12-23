package leetCode.greedyAlgorithms;

import java.util.Arrays;

public class Candy {
    /*
    There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    Return the minimum number of candies you need to have to distribute the candies to the children.

    Example 1:
    Input: ratings = [1,0,2]
    Output: 5
    Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

    Example 2:
    Input: ratings = [1,2,2]
    Output: 4
    Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
    The third child gets 1 candy because it satisfies the above two conditions.

    Constraints:
        n == ratings.length
        1 <= n <= 2 * 10^4
        0 <= ratings[i] <= 2 * 10^4
     */

    //TC/S: O(n)
    public int candy(int[] ratings) {
        //if there is only one child
        if (ratings.length <= 1) {
            return ratings.length;
        }

        int n = ratings.length;

        //array holds the number of candies each child gets
        int[] candies = new int[n];

        //all children get at least 1 candy by default
        Arrays.fill(candies, 1);

        //starting from the left, determine if a child gets more candy
        for (int i = 1; i < n; i++) {
            //a child with a higher rating than its left neighbor gets more candy than that neighbor
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        //starting from the right, determine if a child gets more candy
        for (int i = n - 2; i >= 0; i--) {
            //a child with a higher rating than its right neighbor gets more candy than that neighbor
            if (ratings[i] > ratings[i + 1]) {
                //determine the which neighbor yields more candy, left or right
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int candyNeeded = 0;

        //sum up all the candies needed
        for (int candy : candies) {
            candyNeeded += candy;
        }
        return candyNeeded;
    }
}
