package leetCode.sorting;

public class sortColors {
    /*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color
    are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    Example 1:
    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]

    Example 2:
    Input: nums = [2,0,1]
    Output: [0,1,2]

    Example 3:
    Input: nums = [0]
    Output: [0]

    Example 4:
    Input: nums = [1]
    Output: [1]

    Constraints:
        n == nums.length
        1 <= n <= 300
        nums[i] is 0, 1, or 2.

    Follow up:
        Could you solve this problem without using the library's sort function?
        Could you come up with a one-pass algorithm using only O(1) constant space?
     */
    //TC/S: O(n) w/o used of sort library
    public void sortColorsEz(int[] nums) {
        //sort using count sort
        int[] count = new int[2 + 1];   //largest value in array is 2, +1 to avoid bounds issues

        //add the count of each color to the "count" array
        for (int color : nums) {
            count[color]++;
        }

        //ptr used to update values in nums
        int index = 0;

        //loop through all the possible colors and arrange them in order
        for (int i = 0; i < 3; i++) {
            //add a color while its count > 0
            while (count[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }

    //Dutch sorting algorithm TC: O(n) and constant space used
    private void sortColors(int[] nums) {
        /*
            3 pointers, left for 0's, mid for 1's, and right for 2's. All values of 0 will be at the start of the array,
            all values of 1 will be at the center of the array, and all values of 2 will be at the end of the array
        */
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

        //once mid is larger than right, the array will be sorted
        while (mid <= right) {
            //0's are swapped with the start pointer
            if (nums[mid] == 0) {
                /*
                    swap mid with left, and increase both pointers since we want mid to move to the next value, and the
                    current 0 is now at its proper location of nums[left]
                 */
                swap(nums, left, mid);
                left++;
                mid++;
            }
            //1's are meant to be in the center so just increase mid
            else if (nums[mid] == 1) {
                mid++;
            }
            //2's are meant to be at the end so swap them with the end pointer
            else if (nums[mid] == 2) {
                swap(nums, mid, right);
                //reduce the bound since a 2 is in its proper place of nums[right]
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
