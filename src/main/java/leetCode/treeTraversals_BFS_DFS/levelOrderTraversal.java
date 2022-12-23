package leetCode.treeTraversals_BFS_DFS;

import leetCode.trees.TreeNode;

import java.util.*;

public class levelOrderTraversal {

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
    //TC/S: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> levels = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        //add the root of tree to the queue
        queue.add(root);

        //we need to process all values in the queue
        while (!queue.isEmpty()) {
            int size = queue.size(); //number of nodes we need to process for the current level

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
            //add the level to list of levels
            levels.add(currentLevel);
        }
        return levels;
    }

    List<List<Integer>> levels = new ArrayList<>();

    //recursive function
    public List<List<Integer>> levelOrderRec(TreeNode root) {
        if (root == null) {
            return levels;
        }
        levelOrderTraverse(root, 0);
        return levels;
    }

    //helper method for recursive function
    private void levelOrderTraverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        //if the levels list matches the level we are in, we need a new list for the current level
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        //add the current node "root" to the list of the current level
        levels.get(level).add(root.val);

        //process left and right subtrees by add 1 to the level
        levelOrderTraverse(root.left, level + 1);
        levelOrderTraverse(root.right, level + 1);
    }
}
