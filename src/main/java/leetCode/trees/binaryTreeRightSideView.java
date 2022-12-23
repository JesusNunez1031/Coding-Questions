package leetCode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeRightSideView {
    /*
    Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
    ordered from top to bottom.

    Example:
    Input: [1,2,3,null,5,null,4]
    Output: [1, 3, 4]
    Explanation:

       1            <---
     /   \
    2     3         <---
     \     \
      5     4       <---
     */
    //TC: O(n) using BFS search
    private List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();

                //when i == size - 1, we are at the rightmost value in the current level, so we add it to the list
                if (i == size - 1) {
                    list.add(curr.val);
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return list;
    }
}
