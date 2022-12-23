package leetCode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class minDepthOfBinaryTree {
    /*
    Given a binary tree, find its minimum depth.
    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

    Note: A leaf is a node with no children.

    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: 2

    Example 2:
    Input: root = [2,null,3,null,4,null,5,null,6]
    Output: 5

    Constraints:
        The number of nodes in the tree is in the range [0, 105].
        -1000 <= leetCode.trees.Node.val <= 1000
     */

    //O(n) time and space recursive solution [DFS]
    private int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //if the current node is a leaf, we return 1 and pass it on to call stack
        if (root.left == null && root.right == null) {
            return 1;
        }
        //if the left is null, we check right tree, same otherwise
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        //when we are back at the root, we compare the left and right depth and return the smallest value + 1 to account for the root
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /*
        much more intuitive solution is to perform a level order traversal, at every level we add 1 to the min_depth
        visited. At the first encounter of a leaf node, we know that's the shortest path so we return the min_depth
     */
    //TC: O(n) time and space, much faster than the recursive solution since this does not traverse the entire tree [BFS]
    private int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int min_depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            min_depth++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();

                //if the current is a leaf node, we have reached the shortest path
                if (current.left == null && current.right == null) {
                    return min_depth;
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return min_depth;
    }
}
