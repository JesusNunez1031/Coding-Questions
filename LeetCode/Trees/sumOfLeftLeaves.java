public class sumOfLeftLeaves {
    /*
        Find the sum of all left leaves in a given binary tree.
        Example:

            3
           / \
          9  20
            /  \
           15   7

        There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     */

    private int sumOfLeaves = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traverseTree(root);
        return sumOfLeaves;
    }

    public void traverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        //Check of the left of the current root node is a leaf, if so add its value to the total sum
        if (isLeaf(root.left)) {
            sumOfLeaves += root.left.val;
        }
        //Recursively check left subtrees and right subtrees
        traverseTree(root.left);
        traverseTree(root.right);
    }

    public boolean isLeaf(TreeNode root) {
        if (root == null) {
            return false;
        }
        //if there are no values to the left and right of the current node it is a leaf
        return root.left == null && root.right == null;
    }
}
