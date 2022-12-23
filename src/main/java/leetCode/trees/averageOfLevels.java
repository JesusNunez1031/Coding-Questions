package leetCode.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class averageOfLevels {
    /*
        Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

        Example 1:
        Input:
            3
           / \
          9  20
            /  \
           15   7
        Output: [3, 14.5, 11]
        Explanation:
        The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
     */

    //O(n) runtime and O(n) space for the queue size
    private List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new LinkedList<>();  //list to hold the averages at each level

        if (root == null) {
            return averages;
        }
        /*
            Perform a level order traversal of the tree, at every level, we calculate the average
            by adding up all the values in each node and dividing them by the number of nodes seen
        */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                sum += current.val;

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            //the average of a level in the tree is the sum of values in a specific level divided by the number of nodes in the level
            averages.add(sum / size);
        }
        return averages;
    }
}
