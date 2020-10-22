import java.util.ArrayList;
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

    //Method performs a level order traversal or Depth first traversal, each level is examined at at a time -> O(n) runtime and O(n) space for the queue size
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg = new ArrayList<>();
        if (root == null) {
            return avg;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //each new iteration the queue size will be updated otherwise the size will be dynamically updated and we would process more nodes than wanted
            int size = queue.size();

            //Reset values if not the fist time, otherwise sum will be used to calculate the average based off how many modes we processed per level
            double sum = 0;
            int nodes = 0;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                sum += current.val;
                nodes++;

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            avg.add(sum / nodes);
        }
        return avg;
    }
}
