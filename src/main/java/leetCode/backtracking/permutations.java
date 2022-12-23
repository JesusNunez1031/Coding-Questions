package leetCode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class permutations {
    /*
    Given an array nums of distinct integers, return all the possible leetCode.backtracking.permutations. You can return the answer in any order.

    Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    Example 2:
    Input: nums = [0,1]
    Output: [[0,1],[1,0]]

    Example 3:
    Input: nums = [1]
    Output: [[1]]

    Constraints:
        1 <= nums.length <= 6
        -10 <= nums[i] <= 10
        All the integers of nums are unique.
     */
    //TC: O(2^n) where n is the length of nums
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        //list used to make leetCode.backtracking.permutations
        List<Integer> permutation = new ArrayList<>();

         /*
            to avoid using the value of an index more than once, we need to make sure we mark it as used for every
            current permutation being made
        */
        boolean[] used = new boolean[nums.length];

        //get all leetCode.backtracking.permutations from nums
        getPerm(nums, permutation, used, res);

        return res;
    }

    //Method to get all leetCode.backtracking.permutations from nums using backtracking
    public static void getPerm(int[] nums, List<Integer> permutation, boolean[] used, List<List<Integer>> res) {
        //if the size of leetCode.backtracking.permutations is the size of nums.length, a permutation has been made
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));  //deepcopy since we pass by reference
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //if the value hasn't been used, add it to the list
            if (!used[i]) {
                used[i] = true;
                permutation.add(nums[i]);
                getPerm(nums, permutation, used, res);
                //after we've made a permutation, backtrack and check other values, clear list and set its used to false
                permutation.remove(permutation.size() - 1); //backtrack and remove values from list starting from the back
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr).toString());
    }
}
