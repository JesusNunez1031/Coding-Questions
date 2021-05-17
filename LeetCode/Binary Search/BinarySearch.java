public class BinarySearch {
    /*
    Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search
    target in nums. If target exists, then return its index, otherwise return -1.

    Example 1:
    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4

    Example 2:
    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: 2 does not exist in nums so return -1
     */

    //Recursive Time complexity -> O(logn) Space complexity -> O(logn)
    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
            //we've reached the end of the list, the item is not found return -1
        } else if (start >= end) {
            return -1;
        } else {
            /*
            if the item in the middle is greater than the target value, we search the upper half of the array.
            Otherwise we search the lower half

             */
            if (nums[mid] < target) {
                return binarySearch(nums, mid + 1, end, target);
            } else {
                return binarySearch(nums, start, mid, target);
            }
        }
    }

    //Iterative approach using constant space
    public static int searchIter(int[] nums, int target) {
        int left = 0;                   //pointer to the first item in the list
        int right = nums.length - 1;    //pointer to the last item in the list


        while(left <= right) {
            //calculate the center index of the list
            int mid = left + (right - left) / 2;

            //if the middle index is the target, return the index
            if(nums[mid] == target) {
                return mid;
            } else {
                //if the center value is less than the target, we want to move our left to mid + 1
                if(nums[mid] < target) {
                    left = mid + 1;
                } else {
                    //otherwise we want to move right to mid since the value is greater than the target
                    right = mid - 1;
                }
            }
        }
        return -1;  //target is not in the list
    }



    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};

        System.out.println(searchIter(arr, 2));
    }
}
