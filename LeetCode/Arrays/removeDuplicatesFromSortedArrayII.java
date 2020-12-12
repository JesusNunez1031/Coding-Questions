public class removeDuplicatesFromSortedArrayII {
    /*
    Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
    Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.

    Clarification:
    Confused why the returned value is an integer, but your answer is an array?
    Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller.

    Internally you can think of this:
    // nums is passed in by reference. (i.e., without making a copy)
    int len = removeDuplicates(nums);

    // any modification to nums in your function would be known by the caller.
    // using the length returned by your function, it prints the first len elements.
    for (int i = 0; i < len; i++) {
        print(nums[i]);
    }


    Example 1:
    Input: nums = [1,1,1,2,2,3]
    Output: 5, nums = [1,1,2,2,3]
    Explanation: Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3
    respectively. It doesn't matter what you leave beyond the returned length.

    Example 2:
    Input: nums = [0,0,1,1,1,1,2,3,3]
    Output: 7, nums = [0,0,1,1,2,3,3]
    Explanation: Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1,
    1, 2, 3 and 3 respectively. It doesn't matter what values are set beyond the returned length.

    Constraints:
        0 <= nums.length <= 3 * 104
        -10^4 <= nums[i] <= 10^4
        nums is sorted in ascending order.
     */
    private int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return nums.length;
        }
        /*
            since values have a max duplicate count of 2, we start at index 2 and check if the current element j in the
            array is equal to the value j - 2, if it is, that means we've found a 3rd duplicate so we move forward
            Ex:
                nums -> [1, 1, 1, 2, 2, 3]
                         ↑     ↑
                       j - 2   i
                nums[i] == nums[j], so we know that we need to move forward to 2

                end result = [1, 1, 2, 2, 3, 3]
                                          ↑ j = 5
                       all values beyond this point are ignored
         */
        int j = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
