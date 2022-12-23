package leetCode.arrays;

import java.util.*;

public class threeSum {
    /*
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
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
     */
    public List<List<Integer>> threeSum(int[] nums) {
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
