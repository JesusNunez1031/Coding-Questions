package leetCode.slidingWindow_twoPointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class maxNumberOfKSumPairs {
    /*
    You are given an integer array nums and an integer k.
    In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
    Return the maximum number of operations you can perform on the array.

    Example 1:
    Input: nums = [1,2,3,4], k = 5
    Output: 2
    Explanation: Starting with nums = [1,2,3,4]:
    - Remove numbers 1 and 4, then nums = [2,3]
    - Remove numbers 2 and 3, then nums = []
    There are no more pairs that sum up to 5, hence a total of 2 operations.

    Example 2:
    Input: nums = [3,1,3,4,3], k = 6
    Output: 1
    Explanation: Starting with nums = [3,1,3,4,3]:
    - Remove the first two 3's, then nums = [1,4,3]
    There are no more pairs that sum up to 6, hence a total of 1 operation.

    Constraints:
        1 <= nums.length <= 10^5
        1 <= nums[i] <= 10^9
        1 <= k <= 10^9
     */
    //TC:O(n log n) and constant space
    public int maxOperations(int[] nums, int k) {
        //sort nums so that we have lowest values first and larger values at the end
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        int operations = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];

            //when we find a pair, simulate removing them from the array by adding 1 to operations and moving both pointers
            if (sum == k) {
                operations++;
                left++;
                right--;
            } else {
                //if the sum is less than k, we need a higher value so move left pointer right, otherwise, the sum is too large so move right pointer left
                if (sum < k) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return operations;
    }

    //TC: O(n) and O(n) space used to store values and their frequency in nums into a map
    public int maxOperationsHM(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        //add all the values in nums into the map, if a number already exists, increase its count
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int operations = 0;

        //iterate through the map and look for k - i in the map
        for (int i : map.keySet()) {
            if (map.containsKey(i) && map.containsKey(k - i)) {
                //check if i and k - i are distinct
                if (i != k - i) {
                    //we add the lower value of either i or k - i, since if i appears once but k - i twice, we cant remove 2 pairs, we can only remove one
                    operations += Math.min(map.get(i), map.get(k - i));

                    //set the values for i and k - i to 0 since we may encounter keys again
                    map.put(i, 0);
                    map.put(k - i, 0);
                } else {
                    //i and k - i is not distinct, take the pairs that can be made from i
                    operations += Math.floor(map.get(i) / 2);
                    map.put(i, 0);
                }
            }
        }
        return operations;
    }
}
