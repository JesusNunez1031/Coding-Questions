import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationsII {
    /*
    Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

        Example 1:
        Input: nums = [1,1,2]
        Output:
        [[1,1,2],
         [1,2,1],
         [2,1,1]]

        Example 2:
        Input: nums = [1,2,3]
        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        Constraints:
            1 <= nums.length <= 8
            -10 <= nums[i] <= 10
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        //Sort the Array to put duplicates together
        Arrays.sort(nums);

        //boolean array to hold the values in nums that have already been used
        boolean[] used = new boolean[nums.length];

        //list to hold a specific permutation from the nums array
        List<Integer> permutation = new ArrayList<>();

        //call method to populate all permutations from nums
        getPermutation(nums, permutation, used, ans);

        return ans;
    }

    public static void getPermutation(int[] nums, List<Integer> permutation, boolean[] used, List<List<Integer>> ans) {
        //if the permutation list is the size of nums, we have completed one permutation
        if (permutation.size() == nums.length) {
            ans.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            /*
                if the current element has been used, we don't want to add it to the current permutation, so we check if
                nums[i] has been used or if the current number is a duplicate and has not been used
                    Ex:
                                    [1, 1, 2] used -> [false, false, false]
                   - 1st iteration: permutation = [1] used -> [true, false, false]
                   - 2nd iteration: we start at i = 0, i has been used so we move to i = 1, 1 is a duplicate but its a 1 in
                    a different index therefore we can use it permutation = [1, 1] used -> [true, true, false]
                   - 3rd iteration: we start at i = 0, i has been used, we move to i = 1, i has been used, i = 2, i has
                   not been used, so we add it to the list permutation = [1, 1, 3] used -> [true, true, true]

                   when we backtrack, we then check if the value to be at the start of the new permutation is a duplicate,
                   if it is, we do not want to use it as the start since it would yield duplicate permutations, so we
                   move on to the next value

                   Ex:
                   when we back track from 1, 3, 1, if we where to consider duplicates, 1, 1, 3 would be made again
                   except the first 1 is from index 2, instead when we come to the 1 from index 2, we check if its been
                   used, the first check is false since it has not been used in the current permutation, however, it is
                   a duplicate and the used list is all false so !used makes it true therefore we move on to the three

             */
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            //mark element as used, add it to the permutation, and call method again
            used[i] = true;
            permutation.add(nums[i]);
            getPermutation(nums, permutation, used, ans);
            //once a permutations is completed, remove values from list and set its used value to false to make new permutation
            permutation.remove(permutation.size() - 1);
            used[i] = false;
            //if the next number in nums is a duplicate, we want to skip it since we want to avoid duplicate permutations
//            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
//                i++;
//            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3};
        System.out.println(permuteUnique(arr).toString());
    }
}
