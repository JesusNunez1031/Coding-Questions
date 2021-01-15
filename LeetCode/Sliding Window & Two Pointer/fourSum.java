import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class fourSum {
    /*
    Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that
    a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

    Notice that the solution set must not contain duplicate quadruplets.

    Example 1:
    Input: nums = [1,0,-1,0,-2,2], target = 0
    Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    Example 2:
    Input: nums = [], target = 0
    Output: []

    Constraints:
        0 <= nums.length <= 200
        -10^9 <= nums[i] <= 10^9
        -10^9 <= target <= 10^9
     */
    //TC: O(n^3)
    private List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> set = new LinkedList<>();

        if (nums.length < 4) {
            return set;
        }

        //sort nums so we can skip duplicates
        Arrays.sort(nums);

        //go through each value in nums and look for 3 other values that can sum up to the target, skipping already seen values
        for (int i = 0; i < nums.length - 3; i++) {
            //skip duplicate values
            if (i == 0 || nums[i] != nums[i - 1]) {
                threeSum(nums[i], i + 1, nums, target, set);
            }
        }
        return set;
    }

    /*
        Method replicates 3Sum, where for every value we call twoSum to find 3 values summed plus the initial value from
        fourSum, equal target
     */
    private void threeSum(int curr_value, int left, int[] nums, int target, List<List<Integer>> set) {
        for (int i = left; i < nums.length - 2; i++) {
            //skip duplicates
            if (i == left || nums[i] != nums[i - 1]) {
                //pass the first value from fourSum and current value in nums[i] and look for 2 other values to sum to target
                twoSum(curr_value, nums[i], i + 1, nums.length - 1, nums, target, set);
            }
        }
    }

    private void twoSum(int start_val, int second_val, int left, int right, int[] nums, int target, List<List<Integer>> set) {
        while (left < right) {
            int sum = start_val + second_val + nums[left] + nums[right];

            //if the sum of the 4 values == target, add the numbers as a list to the set of values that sum to target
            if (sum == target) {
                set.add(List.of(start_val, second_val, nums[left], nums[right]));
                //skip duplicate values
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
