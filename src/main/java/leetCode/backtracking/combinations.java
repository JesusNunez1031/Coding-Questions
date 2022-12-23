package leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class combinations {
    /*
    Given two integers n and k, return all possible leetCode.backtracking.combinations of k numbers out of 1 ... n.
    You may return the answer in any order.

    Example 1:
    Input: n = 4, k = 2
    Output:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]

    Example 2:
    Input: n = 1, k = 1
    Output: [[1]]

    Constraints:
        1 <= n <= 20
        1 <= k <= n
     */
    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();   //list to hold all leetCode.backtracking.combinations

        List<Integer> pairs = new ArrayList<>();    //list to store the current combination
        generateCombinationsEff(n, k, combinations, pairs, 1);

        return combinations;
    }
    //TC: O(N! / (K! * (N-K)!)) the combination formula C(n, k)
    //This method does extra work since it considers all values, even those who are not valid to form a permutation, in the range of 1 - n
    private static void generateCombinations(int n, int k, List<List<Integer>> combinations, List<Integer> pairs, int start) {
        //if the list is the size of k, we have made a combination so we add it to the leetCode.backtracking.combinations list [deep copy]
        if (pairs.size() == k) {
            combinations.add(new ArrayList<>(pairs));
            return;
        }

        for (int i = start; i <= n; i++) {
            pairs.add(i);
            generateCombinations(n, k, combinations, pairs, i + 1);
            pairs.remove(pairs.size() - 1);
        }
    }

    /*
        Method avoids extra work by only putting numbers in the range of (n - k + 1), beyond this range the values will not be valid
        Ex: if n = 4 and k = 2
            all possible values in index 0 are 1, 2, and 3
            all possible values in index 1 are 2, 3, and 4

        where as the previous implementation considers the last value in range and does extra recursive calls
     */
    //TC: O(N! / (K! * (N-K)!)) the combination formula C(n, k)
    private static void generateCombinationsEff(int n, int k, List<List<Integer>> combinations, List<Integer> pairs, int start) {
        //When k is 0, we know that the pairs list will hold k values in it since at every call we all the method with k - 1
        if (k == 0) {
            combinations.add(new ArrayList<>(pairs));
            return;
        }

        /*
            reduce the values that can be placed at the start by using n - k + 1, e.g. if n = 4 and k = 2, then
            1, 2, 3 will be in the fist position, then 2, 3, 4 in the second position. This avoid unnecessary work because
            at any point we can put only the numbers in the range of [start, n - k + 1] at any position and any recursive
            calls beyond this range will not produce valid leetCode.backtracking.combinations that will be discarded ultimately.
         */
        for (int i = start; i <= n - k + 1; i++) {
            pairs.add(i);
            generateCombinationsEff(n, k - 1, combinations, pairs, i + 1);
            pairs.remove(pairs.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k).toString());
    }
}
