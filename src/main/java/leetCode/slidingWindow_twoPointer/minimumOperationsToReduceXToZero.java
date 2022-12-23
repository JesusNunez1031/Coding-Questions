package leetCode.slidingWindow_twoPointer;

public class minimumOperationsToReduceXToZero {
    /*
    You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the
    rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future
    operations.

    Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.

    Example 1:
    Input: nums = [1,1,4,2,3], x = 5
    Output: 2
    Explanation: The optimal solution is to remove the last two elements to reduce x to zero.

    Example 2:
    Input: nums = [5,6,7,8,9], x = 4
    Output: -1

    Example 3:
    Input: nums = [3,2,20,1,1,3], x = 10
    Output: 5
    Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in
    total) to reduce x to zero.


    Constraints:
        1 <= nums.length <= 10^5
        1 <= nums[i] <= 10^4
        1 <= x <= 10^9
     */
    //TC: O(n)
    private static int minOperations(int[] nums, int x) {
        //make a new target by subtracting x, we then add all values in nums to target
        int target = -x;

        for (int num : nums) {
            target += num;
        }

        //if the target == 0, all values in nums are needed to sum up to x
        if (target == 0) {
            return nums.length;
        }

        //if the target is less than 0, no number combination exists to make x
        if (target < 0) {
            return -1;
        }

        //start end end pointers for nums subarray
        int left = 0, right = 0;

        //sum holds the running sum of the subarray
        int operations = -1, sum = 0;

        while (right < nums.length) {
            //add the current value to the sum
            sum += nums[right];

            //if the sum > target, reduce it by also reducing the start of the subarray
            while (sum > target) {
                sum -= nums[left++];
            }

            //if the sum == target, we take the max of the current needed operations or the current length of the subarray window
            if (sum == target) {
                operations = Math.max(operations, right - left + 1);
            }
            right++;
        }

        /*
            if operations is no longer -1, there is a solution which is nums.length - max subarray needed to find the target
            this will yield the length of the rest of the array that is actually needed to find x.
         */
        return operations != -1 ? nums.length - operations : -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 20, 1, 1, 3};
        System.out.println(minOperations(arr, 10));
    }
}
