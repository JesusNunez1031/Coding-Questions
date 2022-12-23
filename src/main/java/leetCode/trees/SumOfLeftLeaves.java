package leetCode.trees;

public class SumOfLeftLeaves {
    /*
        Find the sum of all left leaves in a given binary tree.
        Example 1:

            3
           / \
          9  20
            /  \
           15   7

        There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

        Example 2:
        Input: root = [1]
        Output: 0

        Constraints:
            The number of nodes in the tree is in the range [1, 1000].
            -1000 <= leetCode.trees.Node.val <= 1000
     */

    private int sumOfLeaves = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traverseTree(root);
        return sumOfLeaves;
    }

    public void traverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        //Check of the left of the current root node is a leaf, if so add its value to the total sum
        if (isLeaf(root.left)) {
            sumOfLeaves += root.left.val;
        }
        //Recursively check left subtrees and right subtrees
        traverseTree(root.left);
        traverseTree(root.right);
    }

    public boolean isLeaf(TreeNode root) {
        if (root == null) {
            return false;
        }
        //if there are no values to the left and right of the current node it is a leaf
        return root.left == null && root.right == null;
    }

    // optimized helper method to not use global variables
    private int findSum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(isLeaf(root.left)) {
            // if the left node is a leaf return its value + the sum of the right subtrees left nodes
            return root.left.val + findSum(root.right);
        }
        return findSum(root.left) + findSum(root.right);
    }
}
