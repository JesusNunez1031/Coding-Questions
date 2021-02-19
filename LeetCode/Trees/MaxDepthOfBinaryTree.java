public class MaxDepthOfBinaryTree {
    /*
    Given a binary tree, find its maximum depth.
    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Note: A leaf is a node with no children.

    Example 1:
    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
    return its depth = 3.

    Example 2:
    Input: root = [1,null,2]
    Output: 2

    Example 3:
    Input: root = []
    Output: 0

    Example 4:
    Input: root = [0]
    Output: 1
     */

    //TC/S: O(n) and O(n) space
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
