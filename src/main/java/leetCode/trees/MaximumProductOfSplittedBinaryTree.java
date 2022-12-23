package leetCode.trees;

public class MaximumProductOfSplittedBinaryTree {
    /*
    Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product
    of the sums of the subtrees is maximized.

    Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 10^9 + 7.

    Note that you need to maximize the answer before taking the mod and not after taking it.


    Example 1:
                          [1]                        [1]
                       {/}    \                         \
                     [2]       [3] ==>   [2]             [3]
                    /  \       /         /  \             /
                 [4]    [5]  [6]       [4]  [5]         [6]
                                      sum = 11        sum = 10

    Input: root = [1,2,3,4,5,6]
    Output: 110
    Explanation: Remove the {} edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)

    Example 2:
                [1]
                   \
                    [2]               [1]
                    /  {\}  ==>          \
                  [3]   [4]              [2]            [4]
                        /  \            /              /   \
                      [5]   [6]       [3]            [5]   [6]
                                     sum = 6         sum = 15
    Input: root = [1,null,2,3,4,null,null,5,6]
    Output: 90
    Explanation: Remove the {} edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)

    Example 3:
    Input: root = [2,3,9,10,7,8,6,5,4,11,1]
    Output: 1025

    Example 4:
    Input: root = [1,1]
    Output: 1

    Constraints:
        The number of nodes in the tree is in the range [2, 5 * 10^4].
        1 <= leetCode.trees.Node.val <= 10^4
     */
    long totalSum = 0;
    long max = 0;

    //TC: O(n)
    public int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // calculate the sum of the entire tree
        findSum(root);

        // find the max product that can be made
        findMax(root);

        // result may be large so mod it with 10^9+7
        return (int) (max % (1e9 + 7));
    }

    private void findSum(TreeNode root) {
        if (root == null) {
            return;
        }

        findSum(root.left);
        findSum(root.right);

        totalSum += root.val;
    }

    private long findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // find the sum of the left and right subtree
        long left = findMax(root.left);
        long right = findMax(root.right);

        // get the total sum of the current subtree
        long currSum = (long) root.val + left + right;

        /*
            update max if dividing at the current subtree yields a larger product
            total sum - current sum of subtree = the remaining sum of the tree
         */
        max = Math.max(max, currSum * (totalSum - currSum));

        return currSum;
    }
}
