package leetCode.slidingWindow_twoPointer;

import java.util.*;

public class ThreeSum {
    /*
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
    triplets in the array which gives the sum of zero.

    Notice that the solution set must not contain duplicate triplets.

    Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]

    Example 2:
    Input: nums = []
    Output: []

    Example 3:
    Input: nums = [0]
    Output: []

    Constraints:
        0 <= nums.length <= 3000
        -10^5 <= nums[i] <= 10^5
     */
    //TC: O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        //list of lists to store lists of values that sum up to 0
        List<List<Integer>> t_sum = new LinkedList<>();

        //check for a valid array
        if (nums.length < 3) {
            return t_sum;
        }
        //sort values to avoid looking for a sum of 0 for the same ith value
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //if we are at the first value or if nums[i] has not been seen, we call twoSum
            if (i == 0 || nums[i] != nums[i - 1]) {
                //Pass the current value nums[i], the search range from [i + 1, n - 1], nums, and the list
                twoSum(nums[i], i + 1, nums.length - 1, nums, t_sum);
            }
        }
        return t_sum;
    }

    /*
        Method takes in a value and searches all values to its right int range of [left, right] and checks if there are
        two other values that summed up to the current value add up to target
     */
    private void twoSum(int current_value, int left, int right, int[] nums, List<List<Integer>> t_sum) {
        while (left < right) {
            int sum = current_value + nums[left] + nums[right];
            //if the sum of 3 values adds up to target, 0 add them as a list to t_sum
            if (sum == 0) {
                t_sum.add(Arrays.asList(current_value, nums[left], nums[right]));
                //skip any duplicate values from both left and right sides
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
            }
            //move right if the sum of values is low or left if its high
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

    //TC: O(n^2), however this method is slow since we don't check duplicate values and convert a set to an Array List resulting in extra work
    public List<List<Integer>> threeSumBad(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();

        if (nums.length < 3) {
            return new ArrayList<>(list);
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1, sum;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(list);
    }
}
