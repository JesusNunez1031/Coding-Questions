package leetCode.trees;

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
    //TC: O(n) and space due to recursive stack
    private boolean isValidBST(TreeNode root) {
        //an empty tree is a valid tree
        if (root == null) {
            return true;
        }
        return validate(root, null, null);
    }

    private boolean validate(TreeNode root, Integer max, Integer min) {
        //An empty tree is considered valid
        if (root == null) {
            return true;
        }

        /*
            at every step we check if the given subtree is a valid BST
                - when checking the left, the largest possible value we can find is the root of the tree since all values
                  to the left need to be less than the root, anything larger makes the tree invalid

                - when checking the right, the smallest possible value we can see is the root, since all values on the
                  right have to be greater than the root, anything smaller makes the tree invalid
         */
        if (max != null && root.val >= max || min != null && root.val <= min) {
            return false;
        }
        /*
            when checking the left, the largest possible value is the root value

            when checking the right, the smallest possible value is the root value
         */
        return validate(root.left, root.val, min) && validate(root.right, max, root.val);
    }
}
