package leetCode.math;

public class nextGreaterElementII {
    /*
    Given a circular array (the next element of the last element is the first element of the array), print the Next
    Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order
    next in the array, which means you could search circularly to find its next greater number. If it doesn't exist,
     output -1 for this number.

    Example 1:
    Input: [1,2,1]
    Output: [2,-1,2]
    Explanation: The first 1's next greater number is 2;
    The number 2 can't find next greater number;
    The second 1's next greater number needs to search circularly, which is also 2.

    Note: The length of given array won't exceed 10000.
     */

    //TC: O(n^2) and constant space used since the returned array does not count as space used
    private int[] nextGreaterElements(int[] nums) {
        int[] next = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            //increase the index to point to the next value from i circularly so if we are at the end, the next will be the first index
            int index = (i + 1) % nums.length;
            boolean found = false;
            //loop through all values in nums until we get the value we started with
            while (index != i) {
                if (nums[index] > nums[i]) {
                    next[i] = nums[index];
                    found = true;
                    break;
                }
                index = (index + 1) % nums.length;
            }
            //if there was no next greatest, set the index for the current value to -1
            if (!found) {
                next[i] = -1;
            }
        }
        return next;
    }
}
