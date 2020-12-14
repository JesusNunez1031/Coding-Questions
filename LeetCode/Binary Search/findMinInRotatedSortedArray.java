public class findMinInRotatedSortedArray {
    /*
        Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
        (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

        Find the minimum element. You may assume no duplicate exists in the array.

        Example 1:
        Input: [3,4,5,1,2]
        Output: 1

        Example 2:
        Input: [4,5,6,7,0,1,2]
        Output: 0
     */
    private int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            /*
                if the current number at mid is greater than the value at the right of it, we need to move right since
                the rotated part is to the right, otherwise the rotated part is more to the left
            */
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        //left will be at the smallest index in the array after the search ends
        return nums[left];
    }
}
