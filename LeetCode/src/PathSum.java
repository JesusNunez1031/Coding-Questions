public class PathSum {
    public static boolean hasPathSum(SameTree.TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        //If the current node it a leaf and the sum at said leaf is 0, we found a path
        else if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        else {
            //Otherwise, check other subtrees
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
