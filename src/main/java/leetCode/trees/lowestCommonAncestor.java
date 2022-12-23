package leetCode.trees;

public class lowestCommonAncestor {
    /*
        Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
        According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the
        lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

        Example 1:
        Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        Output: 6
        Explanation: The LCA of nodes 2 and 8 is 6.

        Example 2:
        Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        Output: 2
        Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

        Example 3:
        Input: root = [2,1], p = 2, q = 1
        Output: 2

        Constraints:
            The number of nodes in the tree is in the range [2, 105].
            -109 <= leetCode.trees.Node.val <= 109
            All leetCode.trees.Node.val are unique.
            p != q
            p and q will exist in the BST.
     */

    //TC/S: O(n) and O(n) space due to DFS
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if both p and q are less than the root value, check in the left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        //If both p and q are greater than the root value, move to the right subtree
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        //If p or q values violate the previous conditions, we just return the current root since a node can be a descendant of itself
        else {
            return root;
        }
    }
}
