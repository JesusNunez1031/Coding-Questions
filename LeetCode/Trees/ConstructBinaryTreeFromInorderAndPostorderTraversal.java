import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    /*
    Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder
    is the postorder traversal of the same tree, construct and return the binary tree.

    Example 1:
                     [3]
                    /   \
                  [9]   [20]
                        /   \
                     [15]    [7]
    Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    Output: [3,9,20,null,null,15,7]

    Example 2:
    Input: inorder = [-1], postorder = [-1]
    Output: [-1]

    Constraints:
        1 <= inorder.length <= 3000
        postorder.length == inorder.length
        -3000 <= inorder[i], postorder[i] <= 3000
        inorder and postorder consist of unique values.
        Each value of postorder also appears in inorder.
        inorder is guaranteed to be the inorder traversal of the tree.
        postorder is guaranteed to be the postorder traversal of the tree.
     */
    int postOrderIndex;
    Map<Integer, Integer> indexes = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }

        // store all inorder values with their indexes to avoid searching for them every time
        for (int i = 0; i < inorder.length; i++) {
            indexes.put(inorder[i], i);
        }

        postOrderIndex = postorder.length - 1;

        return buildTreeHelper(inorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        // the root of the tree will always be the last node if the postOrder
        TreeNode root = new TreeNode(postorder[postOrderIndex--]);

        // get the index of the root value in the inorder array.
        int index = indexes.get(root.val);

        // all nodes before "index" are the nodes on the left subtree, and nodes after are on the right subtree
        root.left = buildTreeHelper(inorder, postorder, start, index - 1);
        root.right = buildTreeHelper(inorder, postorder, index + 1, end);

        return root;
    }
}
