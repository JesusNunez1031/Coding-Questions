import java.util.Arrays;

public class wiggleSubsequence {
    /*
    Given an integer array nums, return the length of the longest wiggle sequence.

    A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive
    and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two
    elements is trivially a wiggle sequence.

    - For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) are alternately
    positive and negative.
    - In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences, the first because its first two differences
    are positive and the second because its last difference is zero.
    A subsequence is obtained by deleting some elements (eventually, also zero) from the original sequence, leaving the
    remaining elements in their original order.

    Example 1:
    Input: nums = [1,7,4,9,2,5]
    Output: 6
    Explanation: The entire sequence is a wiggle sequence.

    Example 2:
    Input: nums = [1,17,5,10,13,15,10,5,16,8]
    Output: 7
    Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

    Example 3:
    Input: nums = [1,2,3,4,5,6,7,8,9]
    Output: 2

    Constraints:
        1 <= nums.length <= 1000
        0 <= nums[i] <= 1000

    Follow up: Could you solve this in O(n) time?
     */
    //TC: O(n^2) and O(n) space
    public static int wiggleMaxLength(int[] nums) {
        //any sequence less than 2 is the LWS longest wiggle sequence
        if (nums.length < 2) {
            return nums.length;
        }
        /*
            this problem is similar to LIS Longest increasing subsequence, so applying the same techniques,
            we use DP here and keep track of both increasing and decreasing subsequences.
            - increasing[i] refers to the LWS obtained so far assuming ith value is the last value of the wiggle
              subsequence ending with an increasing wiggle
            - decreasing[i] refers to the LWS obtained so far assuming ith value is the last value of the wiggle
              subsequence ending with a decreasing wiggle
        */
        int[] increasing = new int[nums.length];
        int[] decreasing = new int[nums.length];

        //1 is the default LWS
        Arrays.fill(increasing, 1);
        Arrays.fill(decreasing, 1);

        int LWS = 1;

        for (int i = 1; i < nums.length; i++) {
            /*
                increasing[i] will be updated every time we find a rising wiggle ending with ith value. To get the value,
                we need to consider the max out of all previous wiggle subsequences ending with a decreasing wiggle, i.e.,
                decreasing[j].

                decreasing[i] will be updated every time a falling wiggle ending with ith value is found. To get the value,
                we consider the max out of all previous wiggle subsequences ending with an increasing wiggle, i.e., increasing[j]
            */
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    increasing[i] = Math.max(increasing[i], 1 + decreasing[j]);
                } else if (nums[j] > nums[i]) {
                    decreasing[i] = Math.max(decreasing[i], 1 + increasing[j]);
                }
            }
            //update the LWS if there is a larger increasing or decreasing subsequence ending at ith value
            LWS = Math.max(LWS, Math.max(increasing[i], decreasing[i]));
        }
        return LWS;
    }

    //TC: O(n) and constant space, optimized DP approach
    public int wiggleMaxLengthOP(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        //we know the default LWS of both increasing and decreasing sequences is 1
        int inc = 1, dec = 1;
        for (int i = 1; i < nums.length; i++) {
            //if the sequence is increasing, increasing becomes the 1 + the current LWS decreasing, dec follows the same
            if (nums[i] > nums[i - 1]) {
                inc = dec + 1;
            }
            else if (nums[i] < nums[i - 1]) {
                dec = inc + 1;
            }
        }
        return Math.max(inc, dec);
    }

    //TC: O(n) and constant space, Greedy Approach
    public int wiggleMaxLengthGreedy(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        //prevDiff is the difference between first 2 value, this is will let us know if the previous subsequences were increasing or decreasing
        int prevDiff = nums[1] - nums[0];

        /*
            if the difference is greater or less than 0, we've found either an increasing or decreasing subsequence
            hence we can use both values, otherwise, if its 0, one of the values can only be used since by default
            any LWS is 1.
        */
        int LWS = prevDiff != 0 ? 2 : 1; //Longest wiggle subsequence

        /*
            for every subsequence after the first 2 values, if we have an increasing subsequence and the previous was
            decreasing, or if the current subsequence is decreasing and the previous was increasing, we add 1 to the LWS.
            Then we save the current subsequence since this will become the previous subsequence
        */
        for (int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];

            if ((diff > 0 && prevDiff <= 0) || (diff < 0 && prevDiff >= 0)) {
                LWS++;
                prevDiff = diff;
            }
        }
        return LWS;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        System.out.println(wiggleMaxLength(nums));
    }
}
