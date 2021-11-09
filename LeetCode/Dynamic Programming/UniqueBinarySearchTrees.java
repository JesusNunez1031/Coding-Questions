import java.util.Arrays;

public class UniqueBinarySearchTrees {
    /*
    Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes
    of unique values from 1 to n.

    Example 1:
    [1]       [1]             [2]              [3]         [3]
       \         \           /   \             /           /
        [3]       [2]      [1]    [3]       [2]         [1]
       /            \                       /             \
     [2]             [3]                 [1]               [2]
    Input: n = 3
    Output: 5

    Example 2:
    Input: n = 1
    Output: 1

    Constraints:
        1 <= n <= 19
     */
    private static final int[] dp = new int[20]; // n <= 19

    public static int numTrees(int n) {
        // only one way to make a tree of one or no nodes
        if (n <= 1) {
            return 1;
        }

        // return the previously calculated n-tree value if already calculated
        if (dp[n] > 0) {
            return dp[n];
        }

        // find the number of unique trees possible for each n-tree from 1 to n
        for (int i = 1; i <= n; i++) {
            /*
                dp[n] the sum of the number of unique trees using when a tree has i - 1 nodes * when a tree has - i nodes
             */
            dp[n] += numTrees(i - 1) * numTrees(n - i);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        numTrees(5);
    }
}
