import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsII {
    /*
    Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:
    Input: [1,2,2]
    Output:
    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]
     */
    //TC: O(n log n + (n * 2^n)) where n is the length of nums, 2^n possible combinations
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //sort the array so all duplicates are close to each other
        Arrays.sort(nums);

        List<List<Integer>> powerSet = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        genUniquePermutations(nums, powerSet, subset, 0);

        return powerSet;
    }

    private void genUniquePermutations(int[] nums, List<List<Integer>> powerSet, List<Integer> subset, int index) {
        powerSet.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            //check if the the previous value is a duplicate to the current, if so, we don't want to use it
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            genUniquePermutations(nums, powerSet, subset, i + 1);
            subset.remove(subset.size() - 1);

        }
    }
}
