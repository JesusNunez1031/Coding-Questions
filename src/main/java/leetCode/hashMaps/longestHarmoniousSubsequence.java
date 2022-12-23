package leetCode.hashMaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class longestHarmoniousSubsequence {
    /*
    We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
    Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
    A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without
    changing the order of the remaining elements.

    Example 1:
    Input: nums = [1,3,2,2,5,2,3,7]
    Output: 5
    Explanation: The longest harmonious subsequence is [3,2,2,2,3].

    Example 2:
    Input: nums = [1,2,3,4]
    Output: 2

    Example 3:
    Input: nums = [1,1,1,1]
    Output: 0

    Constraints:
        1 <= nums.length <= 2 * 10^4
        -109 <= nums[i] <= 10^9
     */

    //TC: O(n log n) since we sort the nums array
    public int findLHS(int[] nums) {
        //pointer to the start and end of the nums subarray
        int left = 0, right = 1;
        int longest = 0;

        //sort the array so that all values are in ascending order
        Arrays.sort(nums);

        while (right < nums.length) {
            //calculate the difference of the max value at right to the smallest value at left
            int diff = nums[right] - nums[left];

            /*
                if the difference between the max and the min in the subarray == 1, update the longest subsequence length the
                current length of the subsequence or the current longest
            */
            if (diff == 1) {
                longest = Math.max(longest, right - left + 1);
            }

            //expand the subarray if the difference is 1 or less, otherwise update the start to a new value
            if (diff <= 1) {
                right++;
            } else {
                left++;
            }
        }
        return longest;
    }

    //TC/S: O(n) since we use a map to store all numbers in nums
    public int findLHSEz(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        //place every number in nums into the map with the number of times it occurs as the value
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int longest = 0;

        /*
            for every value in nums, check if the num + 1 is in the map, if it is, the, the longest Harmonious
            sequence will be the count of num + count of num + 1
        */
        for (int num : nums) {
            if (map.containsKey(num + 1)) {
                longest = Math.max(longest, map.get(num) + map.get(num + 1));
            }
        }
        return longest;
    }
}
