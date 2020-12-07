import java.util.Arrays;

public class numberOfLongestIncreasingSubsequence {
    /*
    Given an integer array nums, return the number of longest increasing subsequences.
    Notice that the sequence has to be strictly increasing.

    Example 1:
    Input: nums = [1,3,5,4,7]
    Output: 2
    Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

    Example 2:
    Input: nums = [2,2,2,2,2]
    Output: 5
    Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.

    Constraints:
        1 <= nums.length <= 2000
        -10^6 <= nums[i] <= 10^6
     */
    /*
                                             Pseudocode : Dynamic Programming
       1. Similar to when trying to find the length of Longest Increasing Subsequence, we also keep track of the the longest
          subsequence here paired with an array "count" that holds the number of times we find a subsequence of "longest"
          length
       2. Initialize two arrays, "Length" to hold the value of the longest subsequence at each that can be made, and "count"
          to hold the number of subsequence of length "longest" that end at each index of nums.
            - both arrays should be initialized to 1 since by default, a single value has a max increasing subsequence of
              1
       3. we iterate "i" through all values in nums for each value "j" in nums and check if i is larger than the value at
          j. If it is, we update the "longest" length of i to + 1 to that in j, since we found another value to increase the
          length of the longest subsequence
       4. if the value at i is greater than that of j, but the length of the subsequence at i is greater than j by just 1,
          we know we've found a new subsequence of "longest" length so we add to the count of i whatever was previously
          found at j
            - Make sure to update the "longest" length found so far
       5. To get the final result, we search through the length array for all indexes that hold the "longest" value and
          add to the result whatever value is at the "count" of the index since count holds all the longest subsequences
          that end at each index
     */
    //TC: O(n^2) and O(n) space
    private static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (nums.length <= 1) {
            return n;
        }
        int[] length = new int[n];  //list to hold the length of the longest subsequence that can be made
        int[] count = new int[n];   //will hold how many longest subsequences end at each index
        /*
            by default, all values alone have a max increasing subsequence of 1 so we initialize all values to 1 and improve
            the values as we iterate through the list
         */
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        int longest = 1;    //variable to hold the length of the longest Subsequence

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                /*
                    if the current value at i is greater than a predecessor and the length of the longest subsequence
                    at j is >= than that of i, we need to update the longest subsequence length of i and change the
                    number of longest subsequence that end at i to those at j since the new longest subsequence now ends
                    at i

                    otherwise, if the longest subsequence of i is greater than that of j by 1, we now have 2 longest subsequences
                    of the same length so we update the count of the index of the largest subsequence to reflect that.
                    Therefore, to get the final result of all sequences, we search through the array of lengths, and
                    every time we encounter an index with "longest" value, we add the count of that index to the result
                 */
                if (nums[i] > nums[j]) {
                    if (length[j] >= length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[i] == length[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            //update the longest length if any
            longest = Math.max(longest, length[i]);
        }
        //for every value in length that holds the longest subsequence value, we add the count of the its index to the result
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (length[i] == longest) {
                result += count[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        System.out.println(findNumberOfLIS(nums));
    }
}
