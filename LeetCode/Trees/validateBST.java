public class validateBST {
    /*
        Given a binary tree, determine if it is a valid binary search tree (BST).
        Assume a BST is defined as follows:

        - The left subtree of a node contains only nodes with keys less than the node's key.
        - The right subtree of a node contains only nodes with keys greater than the node's key.
        - Both the left and right subtrees must also be binary search trees.

        Example 1:

            2
           / \
          1   3

        Input: [2,1,3]
        Output: true

        Example 2:
              5
            /   \
           1     4
               /   \
              3     6
        Input: root = [5,1,4,null,null,3,6]
        Output: false
        Explanation: The root node's value is 5 but its right child's value is 4.
     */

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode root, Integer max, Integer min) {
        //An empty tree is considered valid
        if (root == null) {
            return true;
            //at every step we check if the given subtree is a valid BST
        } else if (max != null && root.val >= max || min != null && root.val <= min) {
            return false;
        } else {
            /*
                check the left side subtree where the all values have to be less than the max which is the root node after every call

                then check the right of the tree where all nodes have to be greater than the min which is the root node after every call
             */
            return validate(root.left, root.val, min) && validate(root.right, max, root.val);
        }
    }
}
