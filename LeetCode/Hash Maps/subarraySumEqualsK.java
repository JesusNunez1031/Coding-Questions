import java.util.HashMap;
import java.util.Map;

public class subarraySumEqualsK {
    /*
    Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

    Example 1:
    Input: nums = [1,1,1], k = 2
    Output: 2

    Example 2:
    Input: nums = [1,2,3], k = 3
    Output: 2

    Constraints:
        1 <= nums.length <= 2 * 10^4
        -1000 <= nums[i] <= 1000
        -107 <= k <= 10^7
     */

    //TC/S: O(n) and O(n) space due the use of a map to store subarray sums
    private int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        //add the sum of 0 to the map since no values add up to 0
        map.put(0, 1);

        int subarrays = 0, sum = 0;

        for (int num : nums) {
            sum += num;

            /*
            We can calculate that by using the equation Sum[i,j] = Sum[0,j] - Sum[0,i-1]

            Sum[0,j] represent our current sum

            Sum[0,i-1] represent some sum that we calculated in the past.

            As we iterate through the array we calculate Sum[0,j] and also add it to a map, because it will become
            the Sum[0, i-1] of our future values.

            Then if we want to see if our current sum can make a subarray that equals K, we can check our map to see if
            there exists a sum that equals: Sum[0,j] - K. If there is, that must mean there must be atleast one subarray
            from index i to j that equals K.
            */
            if (map.containsKey(sum - k)) {
                subarrays += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return subarrays;
    }
}
