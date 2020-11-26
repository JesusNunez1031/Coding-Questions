public class PathSum {
    /*
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
    Note: A leaf is a node with no children.

    Example:

    Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     */
    public boolean hasPathSum(TreeNode root, int sum) {

        return hasSum(root, sum, 0);
    }

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
//    public static boolean hasPathSum(TreeNode root, int sum) {
//        if(root == null) {
//            return false;
//        }
//        //If the current node it a leaf and the sum at said leaf is 0, we found a path
//        else if (root.left == null && root.right == null && sum - root.val == 0) {
//            return true;
//        }
//        else {
//            //Otherwise, check other subtrees
//            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//        }
//    }
}
