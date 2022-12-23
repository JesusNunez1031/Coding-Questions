package leetCode.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class partitionEqualSubsetSum {
    /*
    Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two leetCode.backtracking.subsets such that the sum of elements in both leetCode.backtracking.subsets is equal.

    Example 1:
    Input: nums = [1,5,11,5]
    Output: true
    Explanation: The array can be partitioned as [1, 5, 5] and [11].

    Example 2:
    Input: nums = [1,2,3,5]
    Output: false
    Explanation: The array cannot be partitioned into equal sum leetCode.backtracking.subsets.

    Constraints:
        1 <= nums.length <= 200
        1 <= nums[i] <= 100
    */
    //TC: O(n * m) and O(m) space where m is the sum and n are the values in nums
    private static boolean canPartition(int[] nums) {
        //get the total sum of values in the array nums
        int sum = 0;
        for (int val : nums) {
            sum += val;
        }

        //if the sum is an odd value, there exits no partition in nums to find it
        if (sum % 2 != 0) {
            return false;
        }

        //set the sum to half its value, this will allow for the search if the other half in nums
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];

        //you can always have a sum of zero in any case
        dp[0] = true;

        for (int i : nums) {
            /*
                there exits a sum for j iff there exits a sum for either j or j - the current value i, the dp array
                will make the index of the number that can be made by summing up values in nums to true. In the end we
                check if the dp[sum] is true or false, if its true that means there is a subset in nums that sum up to
                half the total sum
             */
            for (int j = sum; j >= i; j--) {
                dp[j] = dp[j] | dp[j - i];
                //if dp[sum] is turned true, that means there are a set of values that sum up to it so we can return true
                if (dp[sum]) {
                    return true;
                }
            }
        }
        return dp[sum];
    }

    //TC: O(n) and O(n) space to store state of all possible partitions
    public boolean canPartitionHM(int[] nums) {
        //get the total sum of all numbers in nums, this will later help us determine if a partition is possible
        int total_sum = 0;

        for (int num : nums) {
            total_sum += num;
        }

        //if the sum is odd, there is no way for an equal partition
        if (total_sum % 2 != 0) {
            return false;
        }

        /*
            search through nums making all leetCode.backtracking.subsets through a running sum and check if the running sum * 2 == total_sum.
            We use a HashMap to store previously seen partitions and avoid extra work, i.e. Dynamic Programming
        */
        return possiblePartition(nums, 0, 0, total_sum, new HashMap<String, Boolean>());
    }

    private boolean possiblePartition(int[] nums, int index, int sum, int total_sum, Map<String, Boolean> map) {
        /*
            the current partition is where in nums we are parting values and the sum of the respective values, if the map
            contains this partition, we simply return the truth value for it
        */
        String current_partition = index + "" + sum;
        if (map.containsKey(current_partition)) {
            return map.get(current_partition);
        }

        //when we encounter a partition where its sum doubled is the total_sum, nums can be partitioned into two leetCode.backtracking.subsets of equal sum
        if (sum * 2 == total_sum) {
            return true;
        }

        //we don't care to add more to the sum if we exceeded half the total_sum with the current partition or if we've checked all values in nums
        if (sum > total_sum / 2 || index >= nums.length) {
            return false;
        }

        //for each partition, we can include nums[index] or not into the sum, we check both and store the result for the given partition into the map
        boolean foundPartition = possiblePartition(nums, index + 1, sum + nums[index], total_sum, map)
                || possiblePartition(nums, index + 1, sum, total_sum, map);

        //save the state of the current partition to the map so we avoid extra work
        map.put(current_partition, foundPartition);

        return foundPartition;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 1};
        System.out.println(canPartition(arr));
    }
}
