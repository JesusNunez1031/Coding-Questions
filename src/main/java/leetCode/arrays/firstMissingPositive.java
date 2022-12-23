package leetCode.arrays;

import java.util.HashSet;
import java.util.Set;

public class firstMissingPositive {
    /*
    Given an unsorted integer array nums, find the smallest missing positive integer.

    Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?

    Example 1:
    Input: nums = [1,2,0]
    Output: 3

    Example 2:
    Input: nums = [3,4,-1,1]
    Output: 2

    Example 3:
    Input: nums = [7,8,9,11,12]
    Output: 1

    Constraints:
    0 <= nums.length <= 300
    -2^31 <= nums[i] <= 2^31 - 1
     */
    //TC/S:O(n)
    private int firstMissingPositiveBrute(int[] nums) {
        Set<Integer> set = new HashSet<>();

        //add all the values in nums to the set
        for (int num : nums) {
            set.add(num);
        }

        //the max positive integer we can have in the array is n, where n is the length of the array
        int upper_bound = nums.length;
        //smallest positive integer is 1 since 0 is neither + or -
        int smallest = 1;

        //increment smallest if its value is in the set, otherwise, the first smallest is the upper_bound
        while (smallest <= upper_bound) {
            if (set.contains(smallest)) {
                smallest++;
            } else {
                return smallest;
            }
        }
        return smallest;
    }

    //TC/S: O(n) and constant space
    private int firstMissingPositive(int[] nums) {
        int n = nums.length;
        /*
            we only care about positive values in the range of [1, n + 1] so we get rid of any
            of values that are outside the range by turning them to 1
        */
        boolean contains_one = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                contains_one = true;
            }
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        //if nums does not contain 1, we directly return 1 since that the smallest positive possible value
        if (!contains_one) {
            return 1;
        }

        /*
            use the values as indexes and mark the index they correspond to as negative so we know they've been visited
            values are 1 indexed so we subtract 1 to not get out of bounds issues
        */
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        /*
            the first value int nums that is not negative will be the smallest positive missing value
            +1 since indexes are zero based and we need values from [1 - n + 1]
        */
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        //the smallest missing value is n + 1
        return n + 1;
    }
}
