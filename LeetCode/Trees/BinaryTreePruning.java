public class BinaryTreePruning {
    /*
    Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

    A subtree of a node node is node plus every node that is a descendant of node.

    Example 1:
                [1]             [1]
                   \               \
                    [0]   ==>      [0]
                   /   \              \
                 [0]   [1]            [1]
    Input: root = [1,null,0,0,1]
    Output: [1,null,0,null,1]
    Explanation:
    Only the red nodes satisfy the property "every subtree not containing a 1".
    The diagram on the right represents the answer.

    Example 2:
                             [1]                [1]
                           /     \                 \
                         [0]      [1]      ==>      [1]
                        /   \    /   \                 \
                      [0]   [0] [0]  [1]                [1]
    Input: root = [1,0,1,0,0,0,1]
    Output: [1,null,1,null,1]

    Example 3:
    Input: root = [1,1,0,1,1,0,1,0]
    Output: [1,1,0,1,1,null,1]

    Constraints:
        The number of nodes in the tree is in the range [1, 200].
        Node.val is either 0 or 1.
     */
    //TC: O(n)
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //the value at the left and right will remain if the node is not null or is 1, anything else will be set to null
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        //return the current node if its left or right subtree is not null or if it is a 1
        if (root.left != null || root.right != null || root.val == 1) {
            return root;
        }

        /*
            when a node is 0, we return null to the left or right subtree, depending on where the call stack is, will be
            dereference
         */
        return null;
    }
}
