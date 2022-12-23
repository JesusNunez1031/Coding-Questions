package leetCode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    /*
    Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return
    true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

    Two nodes of a binary tree are cousins if they have the same depth with different parents.

    Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

    Example 1:
                [1]
               /   \
             [2]    [3]
            /
          [4]
    Input: root = [1,2,3,4], x = 4, y = 3
    Output: false

    Example 2:
                [1]
               /   \
             [2]    [3]
                \      \
                [4]     [5]
    Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    Output: true

    Example 3:
                [1]
               /   \
             [2]    [3]
                \
                [4]
    Input: root = [1,2,3,null,4], x = 2, y = 3
    Output: false

    Constraints:
        The number of nodes in the tree is in the range [2, 100].
        1 <= leetCode.trees.Node.val <= 100
        Each node has a unique value.
        x != y
        x and y are exist in the tree.
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // assign different depths
        int x_depth = -1;
        int y_depth = -2;

        int level = 0; // tracks the current level visited of a tree

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();

                // check if nodes have same parent
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) {
                        return false;
                    }
                    if (curr.right.val == x && curr.left.val == y) {
                        return false;
                    }
                }

                // check if the current node is x or y
                if (curr.val == x) {
                    x_depth = level;
                }
                if (curr.val == y) {
                    y_depth = level;
                }

                // return true if depth of both x and y nodes match
                if (y_depth == x_depth) {
                    return true;
                }

                // add nodes to queue
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return false;
    }
}
