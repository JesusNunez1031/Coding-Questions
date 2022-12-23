package leetCode.dynamicProgramming;

import java.util.Arrays;

public class russianDollEnvelopes {
    /*
    You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of
    an envelope.

    One envelope can fit into another if and only if both the width and height of one envelope is greater than the width
    and height of the other envelope.

    Return the maximum number of envelopes can you Russian doll (i.e., put one inside the other).

    Note: You cannot rotate an envelope.

    Example 1:
    Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
    Output: 3
    Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

    Example 2:
    Input: envelopes = [[1,1],[1,1],[1,1]]
    Output: 1

    Constraints:
        1 <= envelopes.length <= 5000
        envelopes[i].length == 2
        1 <= wi, hi <= 10^4
     */
    //TC: O(n log n) and O(n) space used for the dp array [similar to LIS problem]
    public int maxEnvelopes(int[][] envelopes) {
        //sort the envelopes by width, if the width is the same, then sort by height so larger height comes first
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] dp = new int[envelopes.length]; //array of envelope heights
        int maxLen = 0; //holds the number of envelopes used

        for (int[] envelope : envelopes) {
            /*
                search for where in dp array is the position of the height of the ith envelope, if the current ith height
                does not exist in the dp array we add it only if its greater than the previous heights. If the current
                envelopes index matches the current maxLen, then a new envelope has been used and we increase the length
             */
            int index = binarySearch(dp, 0, maxLen, envelope[1]);

            dp[index] = envelope[1];

            //when the index and maxLen are the same, the number of used envelopes has increased
            if (index == maxLen) {
                maxLen++;
            }
        }
        return maxLen;
    }

    //Returns the index where the target would belong in the array from 0 to "right"
    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else {
                if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return left;
    }
}
