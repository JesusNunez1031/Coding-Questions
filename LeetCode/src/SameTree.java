public class SameTree {

    /*
    Given a binary tree, check to see if all the values in
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

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // p and q are both null
        if (p == null && q == null)
            return true;

        // one of p and q is null
        if (q == null || p == null)
            return false;

        if(p.val != q.val) {
            return false;
        }

        //Check the left side of the tree then right and make sure both sides match
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

    }
}
