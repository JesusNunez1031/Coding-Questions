import java.util.Arrays;

public class shortestUnsortedContinousSubarray {
    /*
    Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending
    order, then the whole array will be sorted in ascending order.

    Return the shortest such subarray and output its length.

    Example 1:
    Input: nums = [2,6,4,8,10,9,15]
    Output: 5
    Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

    Example 2:
    Input: nums = [1,2,3,4]
    Output: 0

    Example 3:
    Input: nums = [1]
    Output: 0

    Constraints:
        1 <= nums.length <= 10^4
        -10^5 <= nums[i] <= 10^5

    Follow up: Can you solve it in O(n) time complexity?
     */
    //TC: O(n log n) since we sort clone of nums and O(n) space used since we clone nums array
    public int findUnsortedSubarray(int[] nums) {
        int[] clone = nums.clone();
        //sort the clone array so we can look for the indexes where there is a mismatch
        Arrays.sort(clone);

        //start and end are the start and ending indexes of the unsorted subarray
        int start = 0, end = nums.length - 1;

        //from left to right, look for the first index where there is a mismatch
        for (; start < nums.length; start++) {
            if (nums[start] != clone[start]) {
                break;
            }
        }

        //if start is at the end of the array, that means that the array is already in sorted order
        if (start == nums.length) {
            return 0;
        }

        //from right to left, again look for the first mismatch
        for (; end >= 0; end--) {
            if (nums[end] != clone[end]) {
                break;
            }
        }

        //the length of end - start + 1 is the continuous subarray where values were changed after sorted
        return end - start + 1;
    }

    //TC: O(n) and constant space
    public int findUnsortedSubarrayEz(int[] nums) {
        /*
            search the array for decreasing sequences and update the min. Then look for increasing sequences from the end
            to start and update the max. These two values will be the flag values from a subarray that is sorted. To find
            the actual subarray, we then look for the first occurrence where a value in nums is larger than min and from
            the end we search for the first value that is less than the max. the subarray from these values will be
            shortest unsorted continuous subarray

            EX:
                [2,6,4,8,10,9,15]
                min = 4  | max = 10
                then we look from left to right for the first value larger than min which is 6, start = 1
                then we look from right to left for the first value less than max which is 9, end = 5
                shortest subarray ==> [6,4,8,10,9] or (5 - 1) + 1
        */
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        //look for decreasing sequences that will give us the min value
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                min = Math.min(min, nums[i]);
            }
        }

        //look for increasing sequences to get the max value
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                max = Math.max(max, nums[i]);
            }
        }

        //if the array is in sorted order, there will be no decreasing or increasing sequences from opposite sides so min and max will be unchanged
        if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
            return 0;
        }

        int start = 0, end = nums.length - 1;

        //from left to right, look for the first value that is larger than the min
        for (; start < nums.length; start++) {
            if (nums[start] > min) {
                break;
            }
        }

        //from right to left, look for the first value that is less than the max value
        for (; end >= 0; end--) {
            if (nums[end] < max) {
                break;
            }
        }

        //the length of the shortest subarray will be end - start + 1
        return end - start + 1;
    }
}
