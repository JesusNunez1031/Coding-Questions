public class searchRotatedSortedArrayII {
    /*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

    You are given a target value to search. If found in the array return true, otherwise return false.

    Example 1:
    Input: nums = [2,5,6,0,0,1,2], target = 0
    Output: true

    Example 2:
    Input: nums = [2,5,6,0,0,1,2], target = 3
    Output: false

    Follow up:
        This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
        Would this affect the run-time complexity? How and why?
     */

    //TC: O(n) and O(1)
    private boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            //if one of the pointers is at the target, return true
            if (nums[left] == target || nums[right] == target) {
                return true;
            /*
                move left right if its less than the target and check if there are duplicates, if so move forward as well
                since the array is shifted, all values on the left will be in ascending order
             */
            } else if (nums[left] < target) {
                while (left < right && nums[left + 1] == nums[left]) {
                    left++;
                }
                left++;
            /*
                same applies to the right, if the value at right is greater than the target, move right left while
                there are no duplicates
                since the array is shifted, all values in the right will be in descending order
             */
            } else if (nums[right] > target) {
                while (left < right && nums[right - 1] == nums[right]) {
                    right--;
                }
                right--;
            //if left and right are equal break out and return false, the target was not found
            } else {
                break;
            }
        }
        return false;
    }
}
