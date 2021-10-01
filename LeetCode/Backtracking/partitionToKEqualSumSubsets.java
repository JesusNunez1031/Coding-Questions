public class partitionToKEqualSumSubsets {
    /*
    Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k
    non-empty subsets whose sums are all equal.

    Example 1:
    Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
    Output: True
    Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

    Note:
        1 <= k <= len(nums) <= 16.
        0 < nums[i] < 10000.
     */
    //TC: ~O(2^n) since we make all possible subsets of nums, O(n) space used due to the recursive stack
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //get the total sum of values, this will help determine of k subsets of equal sum are possible
        int total_sum = 0;
        for (int num : nums) {
            total_sum += num;
        }

        //if total_sum divided by k is not 0, we can't make k subsets since one or more subsets would have float values
        if (total_sum % k != 0) {
            return false;
        }

        //use backtracking to find all possible subsets and if k - 1 subsets are made, then k subsets of equal sum can be made
        return canPartition(nums, 0, 0, k, total_sum / k, new boolean[10000]);
    }

    private boolean canPartition(int[] nums, int index, int sum, int k, int bucket_sum, boolean[] used) {
        //when k == 1, we've made k - 1 buckets of total_sum / k, so the remaining values will also sum to bucket_sum
        if (k == 1) {
            return true;
        }
        //we don't want to continue adding to a bucket if the current sum of a bucket exceeds the required bucket_sum, total_sum / k
        if (sum > bucket_sum) {
            return false;
        }

        /*
            when the sum of a bucket == the target bucket_sum of total_sum / k, a bucket has been made, so we now have
            k - 1 buckets left to fill
        */
        if (sum == bucket_sum) {
            return canPartition(nums, 0, 0, k - 1, bucket_sum, used);
        }

        for (int i = index; i < nums.length; i++) {
            //if a value in nums hasn't been used, use it, mark it as used and move to the next index of i + 1
            if (!used[i]) {
                used[i] = true;
                if (canPartition(nums, i + 1, sum + nums[i], k, bucket_sum, used)) {
                    return true;
                }
                //un-mark nums[i] value as used when backtracking to reuse it in another bucket
                used[i] = false;
            }
        }
        //no equal partitions can be made
        return false;
    }
}
