import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    /*
        Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
        For example:
        Given binary tree [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
        return its level order traversal as:
        [
          [3],
          [9,20],
          [15,7]
        ]
     */

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        //add the root of tree to the queue
        queue.add(root);

        //we need to process all values in the queue
        while (!queue.isEmpty()) {
            int size = queue.size();

            //List to store all the values in the current level
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                currentLevel.add(current.val);

                //Check if the current node had any children starting from left to right
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
