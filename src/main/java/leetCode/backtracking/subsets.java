package leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    /*
    Given an integer array nums, return all possible leetCode.backtracking.subsets (the power set).
    The solution set must not contain duplicate leetCode.backtracking.subsets.

    Example 1:
    Input: nums = [1,2,3]
    Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    Example 2:
    Input: nums = [0]
    Output: [[],[0]]

    Constraints:
        1 <= nums.length <= 10
        -10 <= nums[i] <= 10
     */
    //TC: O(n * 2^n) and space where n is the size of array
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();

        generatePowerSet(nums, new ArrayList<>(), powerSet, 0);

        return powerSet;
    }

    private static void generatePowerSet(int[] nums, List<Integer> subset, List<List<Integer>> powerSet, int index) {
        //At evey call, we add the current subset since the method will generate all possible leetCode.backtracking.permutations of the array nums including the empty set
        powerSet.add(new ArrayList<>(subset));

        /*
            add the current number at nums[i] to the subset list, when the last value in nums is reached, backtrack to
            moving to index + 1
         */
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            generatePowerSet(nums, subset, powerSet, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums).toString());
    }
}
