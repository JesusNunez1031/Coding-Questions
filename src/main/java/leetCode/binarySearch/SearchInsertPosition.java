package leetCode.binarySearch;

public class SearchInsertPosition {
    /*
    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not,
    return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [1,3,5,6], target = 5
    Output: 2

    Example 2:
    Input: nums = [1,3,5,6], target = 2
    Output: 1

    Example 3:
    Input: nums = [1,3,5,6], target = 7
    Output: 4

    Example 4:
    Input: nums = [1,3,5,6], target = 0
    Output: 0

    Example 5:
    Input: nums = [1], target = 0
    Output: 0

    Constraints:
        1 <= nums.length <= 10^4
        -10^4 <= nums[i] <= 10^4
        nums contains distinct values sorted in ascending order.
        -10^4 <= target <= 10^4
     */
    //TC: O(log n)
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return left;
    }

    //TC: O(n)
    public int searchInsertN(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            } else {
                if (i == nums.length - 1) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
}
