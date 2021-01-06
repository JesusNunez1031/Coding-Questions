import java.util.HashMap;
import java.util.Map;

public class constructBinaryTreeFromPreorderAndInorderTraversal {
    /*
    Given preorder and inorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.

    For example, given:
        preorder = [3,9,20,15,7]
        inorder = [9,3,15,20,7]
    Return the following binary tree:
            3
           / \
          9  20
            /  \
           15   7
     */
    Map<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;   //index variable used to get the root of each subtree

    //TC/S: O(n) time and O(n) space to store all values and indexes from inorder traversal
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        //check for valid tree
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }

        //store all the values from the inorder traversal along with their index to avoid searching for them every time
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        /*
            "build" will construct the tree using both traversals, we start from the first value in the inorder traversal
            and end at the last value inorder
            we don't need to pass the inorder array since we use the map the get the indexes of the each value
        */
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int start, int end) {
        //if we've reached the end of the tree
        if (start > end) {
            return null;
        }

        /*
            the root of the new tree will be the first value in the preorder array initially since its (Root L R) traversal,
            after that, the root of the left subtree will be index+1, the right will be index+1 and so on
            Ex: preorder = [3,9,20,15,7] | inorder = [9,3,15,20,7]

                root = 3
                root of left subtree = 9
                root of right subtree = 20
                etc..
        */
        TreeNode root = new TreeNode(preorder[preIndex++]);

        //if we've exhausted all values in the subtree, or its a leaf node, return the tree
        if (start == end) {
            return root;
        }

        /*
            get the index from where the left and right subtrees are divided
            Ex: preorder = [3,9,20,15,7] | inorder = [9,3,15,20,7]

                root = 3
                root.left = all values left of the index of 3 in the inorder array
                root.right = all values to the right of the index of 3 in the inorder array

            then we repeat for the subtree of 9, then 20, then 15, then 7, etc.
            Note: without the use of the HM, we would have to search for the root every time in the inorder array
        */
        int index = map.get(root.val);

        root.left = build(preorder, start, index - 1);
        root.right = build(preorder, index + 1, end);

        return root;
    }
}
