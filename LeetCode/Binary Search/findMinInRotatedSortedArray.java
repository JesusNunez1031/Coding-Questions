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
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        //special case, the array is still sorted, then return the result directly
        if (nums[low] < nums[high]) {
            return nums[low];
        }

        while (low + 1 < high) {

            int mid = low + (high - low) / 2;
            //mid is at a sorted index, move right
            if (nums[mid] > nums[low]) {
                low = mid;
            } else {
                //move mid left since there can be a smaller value
                high = mid;
            }
        }
        //return the smallest value
        return Math.min(nums[low], nums[high]);
    }
}
