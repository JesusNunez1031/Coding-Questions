package leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSumII {
    /*
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique leetCode.backtracking.combinations in candidates where the candidate numbers sum to target.
    Each number in candidates may only be used once in the combination.
    Note: The solution set must not contain duplicate leetCode.backtracking.combinations.

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
    //TC: O(n log n + 2 ^ n) we sort the candidates and there are 2 ^ n possible leetCode.backtracking.combinations to sum to target, n is the length of the candidates array
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
                //System.out.println(runningSum.toString());  //print all leetCode.backtracking.combinations considered
                //we return i + 1 so as to not double count the current value at index i
                findCombinations(candidates, combinations, runningSum, sum, target, i + 1);
                sum -= candidates[i];
                runningSum.remove(runningSum.size() - 1);
            }
        }
    }

    //Method without the use of a sum variable to track the sum of values chosen
    private void generateCombinations(int[] candidates, int target, int index, List<Integer> combination, List<List<Integer>> combinations) {
        //when the target == 0, we know all values in the current combination will sum up to target
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        /*
            only add values to the combination list as long as they are not a duplicate and their sum does not exceed
            target, i.e. target > 0
         */
        for (int i = index; i < candidates.length && target > 0; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            target -= candidates[i];
            generateCombinations(candidates, target, i + 1, combination, combinations);
            target += candidates[i];
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }
}
