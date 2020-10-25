import java.util.LinkedList;
import java.util.Queue;

public class deepestLeavesSum {
    /*
        Given a binary tree, return the sum of values of its deepest leaves.

        Example 1:
                                1
                              /   \
                             2     3
                           /   \     \
                          4     5     6
                         /              \
                        7                8
        Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
        Output: 8 + 7 = 15
     */
    //Use a BFS search, at each level we calculate the sum, if the tree is one more level deep, we reset the sum, once done, we return the sum of the last level of the tree
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                sum += curr.val;

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return sum;
    }
}
