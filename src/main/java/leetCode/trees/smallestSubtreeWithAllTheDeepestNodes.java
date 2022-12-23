package leetCode.trees;

public class smallestSubtreeWithAllTheDeepestNodes {
    /*
    Given the root of a binary tree, the depth of each node is the shortest distance to the root.
    Return the smallest subtree such that it contains all the deepest nodes in the original tree.
    A node is called the deepest if it has the largest depth possible among any node in the entire tree.
    The subtree of a node is tree consisting of that node, plus the set of all descendants of that node.

    Example 1:
                            3
                        /      \
                       5        1
                      / \      /  \
                      6  2 ←  0    8
                        / \
                       7   4 - deepest nodes
    Input: root = [3,5,1,6,2,0,8,null,null,7,4]
    Output: [2,7,4]
    Explanation: We return the node with value 2, pointed "←" in the diagram.
    Notice that nodes 5, 3 and 2 contain the deepest nodes in the tree but node 2 is the smallest subtree among them,
    so we return it.

    Example 2:
    Input: root = [1]
    Output: [1]
    Explanation: The root is the deepest node in the tree.

    Example 3:
    Input: root = [0,1,3,null,2]
    Output: [2]
    Explanation: The deepest node in the tree is 2, the valid subtrees are the subtrees of nodes 2, 1 and 0 but the
    subtree of node 2 is the smallest.

    Constraints:
        The number of nodes in the tree will be in the range [1, 500].
        0 <= leetCode.trees.Node.val <= 500
        The values of the nodes in the tree are unique.
     */
    int maxDepth = -1;
    TreeNode smallest_subtree = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        //perform a post order traversal to find the depths of the child nodes
        postOrder(root, 0);

        return smallest_subtree;
    }

    private int postOrder(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        //find the depths of the left and right subtrees
        int left_depth = postOrder(root.left, depth + 1);
        int right_depth = postOrder(root.right, depth + 1);

        /*
            since we do a post order traversal, we check if the left and right depths are equal, if they are then we know
            we are at a deepest part of the subtree so we update the maxDepth, if the current depth is larger than the
            current maxDepth, then the maxDepth will change
        */
        if (left_depth == right_depth) {
            maxDepth = Math.max(maxDepth, left_depth);

            /*
                if the current depth is also the maxDepth, then since we want to return the subtree, we set the smallest_subtree
                to the current node "root". The current root here will always be the parent node since this is a post order traversal
             */
            if (maxDepth == left_depth) {
                smallest_subtree = root;
            }
        }
        //return the max depth value from either the left or right subtree
        return Math.max(left_depth, right_depth);
    }
}
