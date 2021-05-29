public class MaximumErasureValue {
    /*
    You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score
    you get by erasing the subarray is equal to the sum of its elements.

    Return the maximum score you can get by erasing exactly one subarray.

    An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to
    a[l],a[l+1],...,a[r] for some (l,r).

    Example 1:
    Input: nums = [4,2,4,5,6]
    Output: 17
    Explanation: The optimal subarray here is [2,4,5,6].

    Example 2:
    Input: nums = [5,2,1,2,5,2,1,2,5]
    Output: 8
    Explanation: The optimal subarray here is [5,2,1] or [1,2,5].

    Constraints:
        1 <= nums.length <= 10^5
        1 <= nums[i] <= 10^4
     */
    //TC: O(n) and O(10^4) space
    public int maximumUniqueSubarray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int j = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE; //largest sum of a valid subarray
        int[] freq = new int[(int) 1e4 + 1];

        for (int num : nums) {
            //increase the frequency of "num" and add its' value to the total sum
            freq[num]++;
            sum += num;

            /*
                if "num" is a duplicate, its frequency will be > 1, so we reduce the window from the left until the freq
                of the current value is 1 which should also leave the subarray with all unique values again.
             */
            while (freq[num] > 1) {
                freq[nums[j]]--;
                //reduce the sum from values on the left of the window
                sum -= nums[j++];
            }

            //update the maxSum
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
