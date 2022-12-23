package leetCode.binarySearch;

public class findFirstAndLastPositionOfElement {
    /*
        Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
        If target is not found in the array, return [-1, -1].
        Follow up: Could you write an algorithm with O(log n) runtime complexity?

        Example 1:
        Input: nums = [5,7,7,8,8,10], target = 8
        Output: [3,4]

        Example 2:
        Input: nums = [5,7,7,8,8,10], target = 6
        Output: [-1,-1]

        Example 3:
        Input: nums = [], target = 0
        Output: [-1,-1]

        Constraints:
            0 <= nums.length <= 10^5
            -1069 <= nums[i] <= 10^9
            nums is a non-decreasing array.
            -10^9 <= target <= 10^9
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        //check for a valid array
        if (nums.length == 0) {
            return result;
        }

        int left = 0;
        int right = nums.length - 1;

        //look for the first occurrence of the target
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        //if the target could not be found on the first search, it must not exist
        if (nums[left] != target) {
            return result;
        }

        //set the first index of the target in the result array
        result[0] = left;

        /*
            if the target exists, we search from its first occurrence index down, we set the upper bound to the length
            of the array increase a second occurrence of the target does not exist, left will be the length of the array
            allowing us to subtract 1 to get the duplicate index from first occurrence
        */
        right = nums.length;

        //look for the last occurrence of target
        while (left < right) {
            int mid = left + (right - left) / 2;
            /*
                since we want the last occurrence, we want to move right every time we are at a value less or equal to the
                target, moving right when current indexes value is less than target is obvious, moving right when the
                current value == target is to skip duplicates, hence "left" will end at one index ahead of the last target occurrence
             */
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        /*
            since we skip duplicates, left must end at one index after the last occurrence of target hence the last index
            must be left - 1. In the case the target does not exist, left will result as 0, left - 1 will make it -1.
        */
        result[1] = left - 1;

        return result;
    }
}
