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

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        //if the node is a leaf add it to total
        if (root.left == null && root.right == null) { // leaf node
            return 1;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
