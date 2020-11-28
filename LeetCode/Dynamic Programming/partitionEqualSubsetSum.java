public class partitionEqualSubsetSum {
    /*
    Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

    Example 1:
    Input: nums = [1,5,11,5]
    Output: true
    Explanation: The array can be partitioned as [1, 5, 5] and [11].

    Example 2:
    Input: nums = [1,2,3,5]
    Output: false
    Explanation: The array cannot be partitioned into equal sum subsets.

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
                if(dp[sum]) {
                    return true;
                }
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 1};
        System.out.println(canPartition(arr));
    }
}
