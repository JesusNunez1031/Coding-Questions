package leetCode.trees;

public class SumOfRootToLeafBinaryNumbers {
    /*
    You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a
    binary number starting with the most significant bit.

    For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
    For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum
    of these numbers.

    The test cases are generated so that the answer fits in a 32-bits integer.

    Example 1:
    Input: root = [1,0,1,0,1,0,1]
    Output: 22
    Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

    Example 2:
    Input: root = [0]
    Output: 0

    Constraints:
        The number of nodes in the tree is in the range [1, 1000].
        leetCode.trees.Node.val is 0 or 1.
     */
    //TC: O(n) and SC: O(h) where h is the height of the tree
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return TreeSum(root, 0);
    }

    private int TreeSum(TreeNode root, int pathSum) {
        if (root == null) {
            return 0;
        }
        // simulate the increasing of power when moving from MSB to LSB | equivalent to 2^n * nth bit + 2^n-1 * n-1th bit + ... + 2^0 * 0th bit
        pathSum = (2 * pathSum) + root.val;

        // return the digit made from the path of bits
        if (root.left == null && root.right == null) {
            return pathSum;
        }

        return TreeSum(root.left, pathSum) + TreeSum(root.right, pathSum);
    }
}
