package leetCode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class invertBinaryTree {

    /*
       Invert a binary tree.
        Example:
        Input:
             4
           /   \
          2     7
         / \   / \
        1   3 6   9
        Output:
             4
           /   \
          7     2
         / \   / \
        9   6 3   1
     */

    //Recursive approach O(h) time where h is the height of the tree and O(n) space
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //save the left subtree to "left" and right subtree to "right"
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        //to invert trees, set the left subtree to the right subtree and right to left
        root.left = right;
        root.right = left;

        return root;
    }
//    public leetCode.trees.TreeNode invertTree(leetCode.trees.TreeNode root) {
//        if(root == null) {
//            return null;
//        }
//
//        leetCode.trees.TreeNode left = root.left;
//        leetCode.trees.TreeNode right = root.right;
//
//        root.left = right;
//        root.right = left;
//        invertTree(root.left);
//        invertTree(root.right);
//
//        return root;
//    }

    //Iterative approach, O(n) time BFS
    public TreeNode invertTreeIter(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //Swap the left and right nodes
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            //if the left has a node, add it to queue
            if (current.left != null) {
                queue.add(current.left);
            }

            //if the right has a node, add it to queue
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }
}
