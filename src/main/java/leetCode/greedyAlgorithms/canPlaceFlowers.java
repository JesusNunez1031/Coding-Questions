package leetCode.greedyAlgorithms;

public class canPlaceFlowers {
    /*
    You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
    Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer
    n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

    Example 1:
    Input: flowerbed = [1,0,0,0,1], n = 1
    Output: true

    Example 2:
    Input: flowerbed = [1,0,0,0,1], n = 2
    Output: false

    Constraints:
        1 <= flowerbed.length <= 2 * 10^4
        flowerbed[i] is 0 or 1.
        There are no two adjacent flowers in flowerbed.
        0 <= n <= flowerbed.length
     */
    private boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            return n - 1 == 0;
        }

        for (int i = 0; i < flowerbed.length; i++) {

            //when we encounter an empty pot, we need to check if its a valid place to plant
            if (flowerbed[i] == 0) {
                //if we are at the start, check if the next pot is not plotted
                if (i == 0 && flowerbed[i + 1] != 1) {
                    flowerbed[i] = 1;
                    n--;
                    //if we are at the end, check if the pot before us is not plotted
                } else if (i == flowerbed.length - 1 && flowerbed[flowerbed.length - 2] != 1) {
                    flowerbed[i] = 1;
                    n--;
                    //otherwise, at any instance in the array, check if we have no adjacent plots
                } else if (i > 1 && flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            //if we have no flowers to plant, we return true
            if (n == 0) {
                return true;
            }
        }
        return false;
    }
}
