package leetCode.trees;

public class InsertIntoBST extends TreeNode {
    /*
    You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node
    of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

    Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
    You can return any of them.

    Example 1:
    Input: root = [4,2,7,1,3], val = 5
    Output: [4,2,7,1,3,5]
    Explanation: Another accepted tree is:

    Example 2:
    Input: root = [40,20,60,10,30,50,70], val = 25
    Output: [40,20,60,10,30,50,70,null,null,25]

    Example 3:
    Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
    Output: [4,2,7,1,3,5]

    Constraints:
        The number of nodes in the tree will be in the range [0, 104].
        -10^8 <= leetCode.trees.Node.val <= 10^8
        All the values leetCode.trees.Node.val are unique.
        -10^8 <= val <= 10^8
        It's guaranteed that val does not exist in the original BST.
     */

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // add the new node when we reach the end of the path where this nodes value belongs on the BST
        if (root == null) {
            return new TreeNode(val);
        }

        // search right if the value is greater than the current node, else move left if its of lesser value
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

//    public static leetCode.trees.Node insert(leetCode.trees.Node root, int data) {
//        if(root == null) {
//            return new leetCode.trees.Node(data);
//        } else {
//            leetCode.trees.Node cur;
//            if(data <= root.data) {
//                cur = insert(root.left, data);
//                root.left = cur;
//            } else {
//                cur = insert(root.right, data);
//                root.right = cur;
//            }
//            return root;
//        }
//    }
}
