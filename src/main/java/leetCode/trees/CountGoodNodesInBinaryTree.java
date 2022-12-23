package leetCode.trees;

public class CountGoodNodesInBinaryTree {
    /*
    Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a
    value greater than X.

    Return the number of good nodes in the binary tree.


    Example 1:
                {3}
                / \
             [1]   {4}
            /      / \
         {3}     [1]  {5}
    Input: root = [3,1,4,3,null,1,5]
    Output: 4
    Explanation: Nodes in {} are good.
    Root leetCode.trees.Node (3) is always a good node.
    leetCode.trees.Node 4 -> (3,4) is the maximum value in the path starting from the root.
    leetCode.trees.Node 5 -> (3,4,5) is the maximum value in the path
    leetCode.trees.Node 3 -> (3,1,3) is the maximum value in the path.

    Example 2:
                {3}
               /
             {3}
            /   \
          {4}   [2]
    Input: root = [3,3,null,4,2]
    Output: 3
    Explanation: leetCode.trees.Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.

    Example 3:
    Input: root = [1]
    Output: 1
    Explanation: Root is considered as good.

    Constraints:
        The number of nodes in the binary tree is in the range [1, 10^5].
        Each node's value is between [-10^4, 10^4].
     */
    //TC: O(n) where n is the number of nodes in the tree
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // by default the root node is a good node hence it is set as the max
        return countGoodNodes(root, root.val);
    }

    private int countGoodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int good_nodes = 0;

        // a node is considered Good if its equal or larger in value than the largest node seen so far in the path
        if (root.val >= max) {
            good_nodes++;
            max = root.val;
        }

        good_nodes += countGoodNodes(root.left, max);
        good_nodes += countGoodNodes(root.right, max);

        return good_nodes;
    }
}
