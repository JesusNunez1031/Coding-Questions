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
    Therefore the output is 7.
     */
    //TC: O(n * m) for every number "n" in the range of target, we check the list of "m" nums for values less than it to get the number of solutions
    private static int combinationSum4(int[] nums, int target) {
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

                 */
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int target = 5;
        System.out.println(combinationSum4(nums, target));
    }
}
