package leetCode.trees;

public class sameTree {
    /*
    Given two binary trees, write a function to check if they are the same or not.
    Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

    Example 1:
    Input:     1         1
              / \       / \
             2   3     2   3

            [1,2,3],   [1,2,3]
    Output: true

    Example 2:

    Input:     1         1
              /           \
             2             2

            [1,2],     [1,null,2]
    Output: false

    Example 3:
    Input:     1         1
              / \       / \
             2   1     1   2

            [1,2,1],   [1,1,2]
    Output: false
     */

    //TC/S: O(n) and O(n) space due to dfs
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null, we have traversed the tree's to their leaves
        if (p == null && q == null)
            return true;

        /*
            if one is null and the other isn't, we reached the end of a path for a tree while the other sill has nodes
            therefore the trees are not the same
         */
        if (q == null || p == null)
            return false;

        //if the values don't match, the tree is not equal
        if (p.val != q.val) {
            return false;
        }

        //traverse the left and right subtrees in p and q
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(11);
        tree.left.left.left = new TreeNode(7);
        tree.right.right = new TreeNode(4);
        tree.right.left = new TreeNode(13);
        tree.right.right.right = new TreeNode(1);

    }
}
