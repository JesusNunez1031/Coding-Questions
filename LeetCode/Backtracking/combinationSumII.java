import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSumII {
    /*
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
    Each number in candidates may only be used once in the combination.
    Note: The solution set must not contain duplicate combinations.

    Example 1:
    Input: candidates = [10,1,2,7,6,1,5], target = 8
    Output:
    [
    [1,1,6],
    [1,2,5],
    [1,7],
    [2,6]
    ]

    Example 2:
    Input: candidates = [2,5,2,1,2], target = 5
    Output:
    [
    [1,2,2],
    [5]
    ]

    Constraints:
        1 <= candidates.length <= 100
        1 <= candidates[i] <= 50
        1 <= target <= 30
     */
    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        //sort the array so duplicates are close and can be skipped
        Arrays.sort(candidates);

        findCombinations(candidates, combinations, new ArrayList<>(), 0, target, 0);
        return combinations;
    }

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
            //if we encounter a duplicate, it should be skipped
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //only add values if the running sum is less than the target
            if (sum < target) {
                //add the current value at index to the running sum and also add it to the list in case this combination sums to target
                sum += candidates[i];
                runningSum.add(candidates[i]);
                //System.out.println(runningSum.toString());  //print all combinations considered
                //we return i + 1 so as to not double count the current value at index i
                findCombinations(candidates, combinations, runningSum, sum, target, i + 1);
                sum -= candidates[i];
                runningSum.remove(runningSum.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }
}
