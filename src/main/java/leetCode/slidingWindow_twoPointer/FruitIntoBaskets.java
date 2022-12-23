package leetCode.slidingWindow_twoPointer;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    /*
    In a row of trees, the i-th tree produces fruit with type tree[i].
    You start at any tree of your choice, then repeatedly perform the following steps:
        - Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
        - Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.

    Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step
    2, then back to step 1, then step 2, and so on until you stop.

    You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one
    type of fruit each.

    What is the total amount of fruit you can collect with this procedure?

    Example 1:
    Input: [1,2,1]
    Output: 3
    Explanation: We can collect [1,2,1].

    Example 2:
    Input: [0,1,2,2]
    Output: 3
    Explanation: We can collect [1,2,2].
    If we started at the first tree, we would only collect [0, 1].

    Example 3:
    Input: [1,2,3,2,2]
    Output: 4
    Explanation: We can collect [2,3,2,2].
    If we started at the first tree, we would only collect [1, 2].

    Example 4:
    Input: [3,3,3,1,2,1,1,2,3,3,4]
    Output: 5
    Explanation: We can collect [1,2,1,1,2].
    If we started at the first tree or the eighth tree, we would only collect 4 fruits.

    Note:
        1 <= tree.length <= 40000
        0 <= tree[i] < tree.length
     */
    //TC/S: O(n)
    public int totalFruit(int[] tree) {
        int maxFruits = 0;
        int j = 0; //window start i.e. [j, #, #, i]
        Map<Integer, Integer> fruitBaskets = new HashMap<>();

        //i is the end of the current window
        for (int i = 0; i < tree.length; i++) {
            //the current fruit at the end of the window
            int rightFruit = tree[i];

            //add the new or repeated occurrence of ith fruit into the map
            fruitBaskets.put(rightFruit, fruitBaskets.getOrDefault(rightFruit, 0) + 1);

            //reduce the number of fruits from the start basket until either the left or right baskets reach 0, essentially clearing one of the baskets
            while (fruitBaskets.size() > 2) {
                int leftFruit = tree[j];

                fruitBaskets.put(leftFruit, fruitBaskets.get(leftFruit) - 1);

                if (fruitBaskets.get(leftFruit) <= 0) {
                    fruitBaskets.remove(leftFruit);
                }
                //move start pointer to the right
                j++;
            }

            //update the max size of the window
            if (i - j + 1 > maxFruits) {
                maxFruits = i - j + 1;
            }
        }
        return maxFruits;
    }
}
