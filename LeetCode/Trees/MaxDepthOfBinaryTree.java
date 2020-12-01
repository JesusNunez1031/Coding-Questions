public class MaxDepthOfBinaryTree {
    /*
    Given a binary tree, find its maximum depth.
    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Note: A leaf is a node with no children.

    Example:

    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
    return its depth = 3.
     */

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //if we are at a leaf node, we return 1 to the call stack
        if (root.left == null && root.right == null) {
            return 1;
        }

        //return the the subtree with the largest depth, left or right +1 to account for the root
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
