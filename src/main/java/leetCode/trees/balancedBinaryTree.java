package leetCode.trees;

public class balancedBinaryTree {
    /*
        Given a binary tree, determine if it is height-balanced.
        For this problem, a height-balanced binary tree is defined as:
        a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

        Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: true

        Example 2:
        Input: root = [1,2,2,3,3,null,null,4,4]
        Output: false

        Example 3:
        Input: root = []
        Output: true
     */
    //TC: O(n) and space
    private boolean balanced = true;
    private boolean isBalanced(TreeNode root) {
        //the empty tree is considered balanced
        if (root == null) {
            return true;
        }
        checkHeights(root);
        return balanced;
    }

    //method to get the depths of each subtrees in the given tree
    private int checkHeights(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = checkHeights(root.left);
        int right = checkHeights(root.right);

        //if the difference in heights between the left and right subtrees is greater than 1, the tree is not balanced
        if (Math.abs(left - right) > 1) {
            balanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
