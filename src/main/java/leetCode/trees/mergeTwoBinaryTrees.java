package leetCode.trees;

public class mergeTwoBinaryTrees {
    /*
    Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees
    are overlapped while the others are not.
    You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values
    up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

    Example 1:
    Input:
        Tree 1                     Tree 2
              1                         2
             / \                       / \
            3   2                     1   3
           /                           \   \
          5                             4   7
    Output:
    Merged tree:
             3
            / \
           4   5
          / \   \
         5   4   7

    Example 2:
    Input: root1 = [1], root2 = [1,2]
    Output: [2,2]

    Note: The merging process must start from the root nodes of both trees.
     */
    //TC/S: O(n) and O(n) space due to dfs recursion
    private TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        return merge(t1, t2);
    }

    private TreeNode merge(TreeNode t1, TreeNode t2) {
        //if one of the trees is null, return the other
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        //when both trees have a node, add the value of t2's node to t1's node
        t1.val += t2.val;

        //if the left or right of t1 is null and t2 isn't, we set the value t1 to the value in t2
        t1.left = merge(t1.left, t2.left);
        t1.right = merge(t1.right, t2.right);

        //t1 will hold the merged tree
        return t1;
    }
}
