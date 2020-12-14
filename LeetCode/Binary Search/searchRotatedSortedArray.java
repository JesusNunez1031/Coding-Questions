public class searchRotatedSortedArray {
    /*
    You are given an integer array nums sorted in ascending order, and an integer target.
    Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
    If target is found in the array return its index, otherwise, return -1.

    Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

    Example 2:
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1

    Example 3:
    Input: nums = [1], target = 0
    Output: -1

    Constraints:
        1 <= nums.length <= 5000
        -10^4 <= nums[i] <= 10^4
        All values of nums are unique.
        nums is guaranteed to be rotated at some pivot.
        -10^4 <= target <= 10^4
     */
    //TC: O(log n)
    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        //perform a search and break when the left is at the index of the smallest value int the array
        while (left < right) {
            int mid = left + (right - left) / 2;

            /*
            if the value at the center is greater than the last value, we want to move right so we set the left to
            mid + 1 since mid is in the reversed part, therefore the smaller value must be to the right
             */
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;    //otherwise, we want to move the right pointer to the left since the smallest value is to the left
            }
        }
        /*
            We now have the start of the rotated part of the array so we check for which side the we need to search for the target,
            if the target is in the range of the rotated part, we search in that segment, otherwise the start index of the rotated
            array becomes the upperbound of the regular search
        */
        int start = left;  //save the reference so we can use it in case we need to search the rotated array
        //reset pointers
        left = 0;
        right = nums.length - 1;


        if (target >= nums[start] && target <= nums[right]) {
            left = start;   //set the left index to the start
        } else {
            right = start;  //if the target is not in the range, we want to set the end of the search bound to start
        }

        //now that we have a sorted segment of the array, we can do a normal search
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
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, -10, -3, -1, 1, 2};
        int target = -10;
        System.out.println(search(arr, target));
    }
}
