public class balancedBinaryTree {
    /*
        Given a binary tree, determine if it is height-balanced.
        For this problem, a height-balanced binary tree is defined as:
        a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

        Example 1:
        Input: root = [3,9,20,null,null,15,7]
        Output: true

        Example 2:
        Input: root = [1,2,2,3,3,null,null,4,4]
        Output: false

        Example 3:
        Input: root = []
        Output: true
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        //Get the depth of the left tree and right
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        //Conditional to store the status if a tree is balanced or not
        boolean isB = false;

        //If the difference in height is 1 or less, it is balanced
        if (Math.abs(left - right) <= 1) {
            isB = true;
        }

        //Preform the above operations on every subtree in tree
        return isB && isBalanced(root.left) && isBalanced(root.right);

    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right) + 1;
    }
}
