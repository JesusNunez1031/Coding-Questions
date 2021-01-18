import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
    /*
    Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d
    where a, b, c, and d are elements of nums, and a != b != c != d.

    Example 1:
    Input: nums = [2,3,4,6]
    Output: 8
    Explanation: There are 8 valid tuples:
    (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
    (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)

    Example 2:
    Input: nums = [1,2,4,5,10]
    Output: 16
    Explanation: There are 16 valid tuples:
    (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
    (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
    (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
    (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)

    Example 3:
    Input: nums = [2,3,4,6,8,12]
    Output: 40

    Example 4:
    Input: nums = [2,3,5,7]
    Output: 0

    Constraints:
        1 <= nums.length <= 1000
        1 <= nums[i] <= 104
        All elements in nums are distinct.
     */
    private int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int tuples = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                //calculate the product of nums[i] and nums[j]
                int product = nums[i] * nums[j];

                /*
                    if the product is not in the map, 0 will be added to the total count if it is, that means we now know there are
                    4 numbers whose products equal each other so we multiply 8 since there is 8 different ways to arrange the numbers
                */
                tuples += 8 * map.getOrDefault(product, 0);

                //increase the count of the product in the map
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        return tuples;
    }
}
