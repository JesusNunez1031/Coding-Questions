package leetCode.trees;

public class ConstructBinaryTreeFromPreorderTraversal {
    /*
    Return the root node of a binary search tree that matches the given preorder traversal.

    (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a
    value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal
    displays the value of the node first, then traverses node.left, then traverses node.right.)

    It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given
    requirements.

    Example 1:
    Input: [8,5,1,7,10,12]
    Output: [8,5,10,1,7,null,12]
                      8
                    /   \
                   /     \
                  5        10
                 / \      /  \
                1   7  null   12
    Constraints:
        1 <= preorder.length <= 100
        1 <= preorder[i] <= 10^8
        The values of preorder are distinct.
     */

    //TC:O(n^2) and O(n) space due to recursive stack
    private TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        //set the root of the subtree to the start node
        TreeNode root = new TreeNode(preorder[start]);

        //if we've exhausted all values in the subtree, or its a leaf node, return the tree
        if (start == end) {
            return root;
        }

        //search for the first occurrence in preorder where preorder[index] > preorder[start]
        int index = start;
        for (; index <= end; index++) {
            if (preorder[index] > preorder[start]) {
                break;
            }
        }

        /*
            since we break out of the loop at the first value that is greater than the root, all values
            from start + 1 to index - 1 will be the left subtree, all values from index to end are the
            right subtree

            +1 to not include the current root, and -1 to not include the value greater than root
        */
        root.left = buildTree(preorder, start + 1, index - 1);
        root.right = buildTree(preorder, index, end);

        return root;
    }

    //TC/S: O(n)
    int index = 0;

    private TreeNode bstFromPreorderEz(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildTreeEz(int[] preorder, int min, int max) {
        //all values have been seen, subtree is constructed
        if (index == preorder.length) {
            return null;
        }

        int value = preorder[index];

        //value does not fit in the current subtree since its either less than the parent, or greater
        if (value < min || value > max) {
            return null;
        }

        //if the value belongs in the current subtree, make in into the parent node, and make subtree by calling method
        index++; //move to the next value in preorder

        TreeNode root = new TreeNode(value);

        root.left = buildTree(preorder, min, value);    //max value in the left subtree is "value"
        root.right = buildTree(preorder, value, max);   //min value in the right subtree is "value"

        return root;
    }
}
