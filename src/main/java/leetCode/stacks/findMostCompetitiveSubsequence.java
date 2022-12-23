package leetCode.stacks;

import java.util.Stack;

public class findMostCompetitiveSubsequence {
    /*
    Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.

    An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.

    We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first position
    where a and b differ, subsequence a has a number less than the corresponding number in b. For example, [1,3,4] is
    more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.

    Example 1:
    Input: nums = [3,5,2,6], k = 2
    Output: [2,6]
    Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6] is the
    most competitive.

    Example 2:
    Input: nums = [2,4,3,3,5,4,9,6], k = 4
    Output: [2,3,3,4]

    Constraints:
        1 <= nums.length <= 10^5
        0 <= nums[i] <= 10^9
        1 <= k <= nums.length
     */
    //TC/S: O(n) and O(k) space where k is the size of the competitive sequence
    private int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            /*
                if nums[i] is more competitive than top of stack, remove values until nums[i] is most competitive, also
                check if there are still enough values remaining in the stack and the nums array to make a sequence of
                k length
             */
            while (!stack.isEmpty() && nums[i] < stack.peek() && stack.size() + nums.length - i > k) {
                stack.pop();
            }
            //add to the sequence the number of values are less than k
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }

        //remaining values in the stack are the most competitive sequence in reverse, add them to an array
        int i = k;
        int[] sequence = new int[k];
        while (!stack.isEmpty()) {
            sequence[--i] = stack.pop();
        }
        return sequence;
    }

    //TC/S: O(n) and O(1), a stack is simulated using a variable
    private int[] mostCompetitiveEz(int[] nums, int k) {
        int[] sequence = new int[k];

        //simulates pointing to the top of the stack
        int top = 0;

        for (int i = 0; i < nums.length; i++) {
            /*
                if nums[i] is more competitive than the value at the top, reduce the top until nums[i] is most competitive
                also check if there are still enough values remaining in the stack and the nums array to make a sequence
                of k length
             */
            while (top != 0 && nums[i] < sequence[top - 1] && top + nums.length - i > k) {
                top--;
            }
            // add to the sequence the number of values are less than k
            if (top < k) {
                sequence[top++] = nums[i];
            }
        }
        return sequence;
    }
}
