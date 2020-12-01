import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
    /*
    Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
    of candidates where the chosen numbers sum to target. You may return the combinations in any order.
    The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
    frequency of at least one of the chosen numbers is different.

    It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

    Example 1:
    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
    Explanation:
    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
    7 is a candidate, and 7 = 7.
    These are the only two combinations.

    Example 2:
    Input: candidates = [2,3,5], target = 8
    Output: [[2,2,2,2],[2,3,3],[3,5]]

    Example 3:
    Input: candidates = [2], target = 1
    Output: []

    Example 4:
    Input: candidates = [1], target = 1
    Output: [[1]]

    Example 5:
    Input: candidates = [1], target = 2
    Output: [[1,1]]


    Constraints:
        1 <= candidates.length <= 30
        1 <= candidates[i] <= 200
        All elements of candidates are distinct.
        1 <= target <= 500
     */
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();

        findCombinations(candidates, combinations, new ArrayList<>(), 0, target, 0);
        return combinations;
    }

    /*
        Method exhausts all possible choices for combinations to get to the target sum
        Ex: given [2, 3, 7] target = 7
            1: 2 2 2 2
            2: 2 2 2 3
            3: 2 2 2 7
            4: 2 2 3   -> match
            5: 2 2 7
            6: 2 7
            7: 3 3 3
            8: 3 3 7
            9: 3, 7
            10: 7      -> match
            Note: some backtracks are ignored to remove redundant calls
            We first try adding 2 n times, then when we pass the target sum, we backtrack delete the last 2 and add the next
            value, 3, to the new running sum, that also passes the target sum so then we try the next number 7, that passes
            the target as well so we backtrack to the second to last value and repeat the previous steps, however, to avoid
            adding "duplicate" combinations, we also pass in the index we are at so as to avoid this, so when we are done
            with 2, we move on to all values from 3 on, 7 on, etc. Otherwise, apart from [2, 2, 3] we would also print
            [2, 3, 2] and [3, 2, 2] which although valid answers, are considered duplicates

            TC:  O(len(nums)^target) or O(N^M)
     */
    private static void findCombinations(int[] candidates, List<List<Integer>> combinations, List<Integer> runningSum, int sum, int target, int start) {
        //if the sum is greater than the target, we've chosen a bad value
        if (sum > target) {
            return;
        }
        //if the running sum equals the target, a combination of values was found
        if (sum == target) {
            combinations.add(new ArrayList<>(runningSum));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //only add values if the running sum is less than the target
            if (sum < target) {
                //add the current value at index to the running sum and also add it to the list in case this combination sums to target
                sum += candidates[i];
                runningSum.add(candidates[i]);
                //System.out.println(runningSum.toString());  //all possible combinations made
                findCombinations(candidates, combinations, runningSum, sum, target, i);
                sum -= candidates[i];
                runningSum.remove(runningSum.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}
