import java.util.Arrays;

public class ThreeSumClosest {
    /*
    Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to
    target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    Example 1:
    Input: nums = [-1,2,1,-4], target = 1
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

    Constraints:
        3 <= nums.length <= 10^3
        -10^3 <= nums[i] <= 10^3
        -10^4 <= target <= 10^4
     */
    //TC:O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        int closest = (int) 1e3; //largest possible value in nums

        //sort the array, so we can skip calculating sums for duplicate values
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //if the current value has not been seen
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;

                //2Sum to find sum of two values + current to see if their sums are closer to target than the current "closest"
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    //if the target sum was found, return it
                    if (sum == target) {
                        return sum;
                    }

                    //if the current sum is closer to the target than the current "closest", update the closest to the sum
                    if (Math.abs(target - sum) < Math.abs(target - closest)) {
                        //closestDiff = Math.abs(target - sum);
                        closest = sum;
                    }

                    /*
                        if the sum is less than the target, move "left" pointer right to use a larger value, else move
                        "right" pointer left to use smaller value
                     */
                    if (sum < target) {
                        left++;
                        //skip any duplicate values from left
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else {
                        right--;
                        //skip any duplicate values from right
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return closest;
    }
}
