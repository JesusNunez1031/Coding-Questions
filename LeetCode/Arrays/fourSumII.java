import java.util.HashMap;
import java.util.Map;

public class fourSumII {
    /*
    Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
    To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range
    of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

    Example:
    Input:
    A = [ 1, 2]
    B = [-2,-1]
    C = [-1, 2]
    D = [ 0, 2]
    Output:
    2

    Explanation:
    The two tuples are:
    1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
    2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     */
    //TC: O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int tuples = 0;

        //put all the sum of AB into the hashmap
        for (int numA : A) {
            for (int numB : B) {
                int sum = numA + numB;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        /*
            calculate the sums of CD and check if the negated version exists in the map, if it does, we increase the
            count of the tuples by the number of time the sum of A + B occurred since the negation of sum C + D compared
            to A + B == 0
        */
        for (int numC : C) {
            for (int numD : D) {
                int sum = -(numC + numD);
                if (map.containsKey(sum)) {
                    tuples += map.get(sum);
                }
            }
        }
        return tuples;
    }
}
