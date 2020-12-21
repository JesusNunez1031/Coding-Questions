public class maximumSubarray {
    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
    Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

    Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

    Example 2:
    Input: nums = [1]
    Output: 1

    Example 3:
    Input: nums = [0]
    Output: 0

    Example 4:
    Input: nums = [-1]
    Output: -1

    Example 5:
    Input: nums = [-2147483647]
    Output: -2147483647

    Constraints:
        1 <= nums.length <= 2 * 104
        -231 <= nums[i] <= 231 - 1
     */

    //Kadane's Algorithm: TC - O(n) and O(1) space
    public int maxSubArray(int[] nums) {
        //set the max sum to the first value and the current sum to the max sum
        int max_sum = nums[0];
        int running_sum = max_sum;

        for (int i = 1; i < nums.length; i++) {
            /*
                running_sum is updated at every index, do we add the current value at nums[i] to it or do we start a new
                sub-array from nums[i] since its value is larger than the current running sum. the current sum is either
                the current value plus the running_sum if the integer is not a burden ergo extending the sub-array, or we
                start a new sub-array from the current value since its value is larger than the previous sub-array values
                summed
             */
            running_sum = Math.max(nums[i] + running_sum, nums[i]);

            //check if the max_sum has to be updated
            if(running_sum > max_sum) {
                max_sum = running_sum;
            }
        }
        return max_sum;
    }

    /*
    Kadane's Algorithm explained:
        We have 2 choices:
           currentSum + nums[i] (extend the previous subarray best whatever it was)
          1.) Let the item we are sitting at contribute to this best max we achieved
          ending at index i - 1)
        nums[i] (start and end at this index)
          2.) Just take the item we are sitting at's value.

        The max of these 2 choices will be the best answer to the Max Contiguous
        Subarray Sum we can achieve for subarrays ending at index i.

        Example:

        index     0  1   2  3   4  5  6   7  8
        Input: [ -2, 1, -3, 4, -1, 2, 1, -5, 4 ]
                 -2, 1, -2, 4,  3, 5, 6,  1, 5    'currentSum' at each point in the array

        The best subarrays we would take if we took them:
          ending at index 0: [ -2 ]                 (snippet from index 0 to index 0)
          ending at index 1: [ 1 ]                  (snippet from index 1 to index 1) [we just took the item at index 1]
          ending at index 2: [ 1, -3 ]              (snippet from index 1 to index 2)
          ending at index 3: [ 4 ]                  (snippet from index 3 to index 3) [we just took the item at index 3]
          ending at index 4: [ 4, -1 ]              (snippet from index 3 to index 4)
          ending at index 5: [ 4, -1, 2 ]           (snippet from index 3 to index 5)
          ending at index 6: [ 4, -1, 2, 1 ]        (snippet from index 3 to index 6)
          ending at index 7: [ 4, -1, 2, 1, -5 ]    (snippet from index 3 to index 7)
          ending at index 8: [ 4, -1, 2, 1, -5, 4 ] (snippet from index 3 to index 8)
     */
}
