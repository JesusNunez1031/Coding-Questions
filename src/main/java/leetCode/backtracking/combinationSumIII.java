package leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class combinationSumIII {
    /*
    Find all valid leetCode.backtracking.combinations of k numbers that sum up to n such that the following conditions are true:
     - Only numbers 1 through 9 are used.
     - Each number is used at most once.
    Return a list of all possible valid leetCode.backtracking.combinations. The list must not contain the same combination twice, and the leetCode.backtracking.combinations may be returned in any order.

    Example 1:
    Input: k = 3, n = 7
    Output: [[1,2,4]]
    Explanation:
    1 + 2 + 4 = 7
    There are no other valid leetCode.backtracking.combinations.

    Example 2:
    Input: k = 3, n = 9
    Output: [[1,2,6],[1,3,5],[2,3,4]]
    Explanation:
    1 + 2 + 6 = 9
    1 + 3 + 5 = 9
    2 + 3 + 4 = 9
    There are no other valid leetCode.backtracking.combinations.

    Example 3:
    Input: k = 4, n = 1
    Output: []
    Explanation: There are no valid leetCode.backtracking.combinations. [1,2,1] is not valid because 1 is used twice.

    Example 4:
    Input: k = 3, n = 2
    Output: []
    Explanation: There are no valid leetCode.backtracking.combinations.

    Example 5:
    Input: k = 9, n = 45
    Output: [[1,2,3,4,5,6,7,8,9]]
    Explanation:
    1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45 There are no other valid leetCode.backtracking.combinations.

    Constraints:
        2 <= k <= 9
        1 <= n <= 60
     */
    //TC: C(9, k) ==> O(N! / (K! * (N-K)!))
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();

        //since all values from 1 - 9 can only be used once, the max possible sum generated using all values is 45
        if (n > 45) {
            return combinations;
        }

        List<Integer> runningSum = new ArrayList<>();
        generateCombinations(k, n, combinations, runningSum, 0, 1);

        return combinations;
    }

    private void generateCombinations(int k, int n, List<List<Integer>> combinations, List<Integer> runningSum, int sum, int start) {
        //if the size of the current running sum is the required k values and running sum sum up to n, we've found a combination
        if (runningSum.size() == k && sum == n) {
            combinations.add(new ArrayList<>(runningSum));
            return;
        }

        //loop up to 9 since we can only use values from 1 to 9
        for (int i = start; i <= 9; i++) {
            //As long as the sum is less than the target n and the number of values used does not exceed k, we can add more values to the sum
            if (sum < n && runningSum.size() < k) {
                runningSum.add(i);
                sum += i;
                generateCombinations(k, n, combinations, runningSum, sum, i + 1);
                sum -= i;
                runningSum.remove(runningSum.size() - 1);
            }
        }
    }

    //Method without the used of sum variable, we just update n and k
    private void generateCombinations(int k, int n, int index, List<Integer> runningSum, List<List<Integer>> combinations) {
        //when both n and k are 0 we know there are k values in runningSum that sum up to n
        if (k == 0 && n == 0) {
            combinations.add(new ArrayList<>(runningSum));
            return;
        }

        /*
            we only want to use a new value if we can still use a new value, i.e., k > 0, and if the summing of current
            values hasn't exceeded the target, i.e. n > 0
         */
        for (int i = index; i <= 9 && n > 0 && k > 0; i++) {
            runningSum.add(i);
            //subtract from the target n the value i and 1 from k to show we've used a new value
            n -= i;
            k -= 1;
            generateCombinations(k, n, i + 1, runningSum, combinations);
            //when backtracking add the values back to n and k
            n += i;
            k += 1;
            runningSum.remove(runningSum.size() - 1);
        }
    }
}
