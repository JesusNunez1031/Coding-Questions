public class combinationSumIV {
    /*
    Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

    Example:
    nums = [1, 2, 3]
    target = 4

    The possible combination ways are:
    (1, 1, 1, 1)
    (1, 1, 2)
    (1, 2, 1)
    (1, 3)
    (2, 1, 1)
    (2, 2)
    (3, 1)
    Note that different sequences are counted as different combinations.

    Example 2:
    Input: nums = [9], target = 3
    Output: 0

    Constraints:
        1 <= nums.length <= 200
        1 <= nums[i] <= 1000
        All the elements of nums are unique.
        1 <= target <= 1000

     Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation
                we need to add to the question to allow negative numbers?
     */
    /*
        TC: O(n * m) for every number "n" in the range of target, we check the list of "m" nums for values less than it
            to get the number of solutions
        Follow up: The use of negative numbers opens up the chance of an infinite loop since there can be infinite number
                   of ways to sum up to a target, e.g. if target == 5 and nums = [5, -5], we can always make target by
                   using 5, and an infinite number of combinations of (5,-5), so (5, (-5,5)). To allow negatives and an
                   infinite loop, we must add limitations to the number of times numbers in "nums" can be used.
     */
    public int combinationSum4(int[] nums, int target) {
        //dp array holds all the number of ways to sum up to ith value including target using values in nums
        int[] dp = new int[target + 1];

        //there is one way of making zero by having no values
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                /*
                    for every number "n" in the range of target, we add all the different ways that we can make "n" using
                    the given numbers in "nums"
                    Ex: given the nums [1, 2, 3, 4] and target = 5
                    1. 0 its takes no values to make zero so it has 1 way                                               ==> dp [1, 0, 0, 0, 0, 0]
                    2. 1 can only be made using one 1 found in nums so we set its value to 1                            ==> dp [1, 1, 0, 0, 0, 0]
                    3. 2 can be made by using two 1's or just one 2 so its value is 2, we get this value by adding up
                       all the solutions of its previous values we've calculated                                        ==> dp [1, 1, 2, 0, 0, 0]
                    4. 3 has four ways, we get this value by adding up the solutions of all values less than it         ==> dp [1, 1, 2, 4, 0, 0]
                    5. 4 has 8 ways to be made, again we sum up all solutions of values less than it in nums to get the
                    solution to get its solution                                                                        ==> dp [1, 1, 2, 4, 8, 0]
                    6. Finally, the number of ways to make up the target value of 5, is the sum of all the solutions of
                    values less than it in nums                                                                         ==> dp [1, 1, 2, 4, 8, 15]

                    int short, the number of ways to make ith value is the solution to the number of ways to make up all
                    previous values summed. We only add to dp[i] if the ith value is >= to num since there is no way to
                    sum up to ith value using a larger value than ith value.
                 */
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
