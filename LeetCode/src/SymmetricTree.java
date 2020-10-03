public class SymmetricTree {

    //Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

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
    // Main exe method
    public boolean isSymmetric(TreeNode root) {

        return isSymmetric(root, root);
    }

    //Overloaded Helper method to split tree into two subtrees
    public boolean isSymmetric(TreeNode l, TreeNode r) {

        if(l == null && r == null) return true;

        if(l == null || r == null) return false;

        return (l.val == r.val) && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }
}
