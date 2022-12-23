package leetCode.trees;

public class maxDifferenceBetweenNodeAndAncestor {
    /*
    Given the root of a binary tree, find the maximum value V for which there exist different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
    A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.

    Example 1:
                        8
                     /     \
                    3       10
                  /   \       \
                 1     6       14
                     /   \    /
                    4     7  13

    Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
    Output: 7
    Explanation: We have various ancestor-node differences, some of which are given below :
    |8 - 3| = 5
    |3 - 7| = 4
    |8 - 1| = 7
    |10 - 13| = 3
    Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

    Example 2:
                        1
                         \
                          2
                           \
                            0
                           /
                          3
    Input: root = [1,null,2,null,0,3]
    Output: 3
     */

    int diff = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return diff;
    }

    void dfs(TreeNode node, int current_min, int current_max) {
        if (node == null) {
            return;
        }

        //update the diff to the max between the current diff, or the max between the difference of the current node with the current_max and min
        diff = Math.max(diff, Math.max(Math.abs(node.val - current_min), Math.abs(node.val - current_max)));

        //update the current_max and min
        current_min = Math.min(current_min, node.val);
        current_max = Math.max(current_max, node.val);

        //search the left tree and right subtree passing along the current min and max
        dfs(node.left, current_min, current_max);
        dfs(node.right, current_min, current_max);

    }
}
