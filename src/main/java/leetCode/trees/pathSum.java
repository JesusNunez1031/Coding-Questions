package leetCode.trees;

public class pathSum {
    /*
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
    Note: A leaf is a node with no children.

    Example 1:
    Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
     return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

    Example 2:
                 1
               /   \
              2     3
    Input: root = [1,2,3], leetCode.dfs_bfs_topologicalSort.targetSum = 5
    Output: false

    Example 3:
    Input: root = [1,2], leetCode.dfs_bfs_topologicalSort.targetSum = 0
    Output: false
     */
    //TC/S: O(n) and O(n) space used since a DFS search is used
    public boolean hasPathSum(TreeNode root, int sum) {
        //check for a valid tree
        if (root == null) {
            return false;
        }
        return hasSum(root, sum, 0);
    }

    /*
        Method uses a running sum "current_sum" variable to hold the sum of a path and checks if the path sums up to
        the target when a leaf node is reached
     */
    public boolean hasSum(TreeNode root, int sum, int current_sum) {
        if (root == null) {
            return false;

        /*
            by the time a leaf node is reached, the total sum from the root to the node will have been calculated,
            therefore if the total sum of the path is equal to the target sum, we return true, otherwise we ignore it
            and go back to the call stack and check another path
         */
        } else if (root.left == null && root.right == null && current_sum + root.val == sum) {
            return true;
        }

        //check if the path is in the left or right
        return hasSum(root.left, sum, current_sum + root.val) || hasSum(root.right, sum, current_sum + root.val);
    }

    //Method checks for sum without the need to save the current paths sum and only updates the target sum and checks if it ever reaches 0
    public static boolean hasSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //If the current node it a leaf and the sum at said leaf is 0, we found a path
        else if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        } else {
            //Otherwise, check other subtrees
            return hasSum(root.left, sum - root.val) || hasSum(root.right, sum - root.val);
        }
    }
}
