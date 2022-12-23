package leetCode.trees;

public class lowestCommonAncestorOfBinaryTree {
    /*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
    the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”


    Example 1:
               3
            /      \
           5        1
         /   \     /  \
        6     2   0    8
             /  \
             7   4
    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    Output: 3
    Explanation: The LCA of nodes 5 and 1 is 3.

    Example 2:
    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    Output: 5
    Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

    Example 3:
    Input: root = [1,2], p = 1, q = 2
    Output: 1

    Constraints:
        The number of nodes in the tree is in the range [2, 105].
        -109 <= leetCode.trees.Node.val <= 109
        All leetCode.trees.Node.val are unique.
        p != q
        p and q will exist in the tree.
     */
    //TC: O(n) and O(h) space
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //if the root is either p or q, we return the root since the node can be an ancestor of itself
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        //search left subtree
        TreeNode left_search = lowestCommonAncestor(root.left, p, q);
        //search right subtree
        TreeNode right_search = lowestCommonAncestor(root.right, p, q);

        //if either left or right are null, we return the other, not the root since its not the LCA
        if (left_search == null) {
            return right_search;
        }
        if (right_search == null) {
            return left_search;
        }

        //if left and right were not null, that means we are currently at the LCA so we return the current value of root
        return root;
    }
}
