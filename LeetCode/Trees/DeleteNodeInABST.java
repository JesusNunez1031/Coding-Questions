public class DeleteNodeInABST {
    /*
    Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node
    reference (possibly updated) of the BST.

    Basically, the deletion can be divided into two stages:
        Search for a node to remove.
        If the node is found, delete the node.

    Example 1:
    Input: root = [5,3,6,2,4,null,7], key = 3
    Output: [5,4,6,2,null,null,7]
    Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
    One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
    Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

    Example 2:
    Input: root = [5,3,6,2,4,null,7], key = 0
    Output: [5,3,6,2,4,null,7]
    Explanation: The tree does not contain a node with value = 0.

    Example 3:
    Input: root = [], key = 0
    Output: []

    Constraints:
        The number of nodes in the tree is in the range [0, 10^4].
        -10^5 <= Node.val <= 10^5
        Each node has a unique value.
        root is a valid binary search tree.
        -10^5 <= key <= 10^5

    Follow up: Could you solve it with time complexity O(height of tree)?
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        return removeNode(root, key);
    }

    private TreeNode removeNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // key node found
        if (root.val == key) {
            // case 1: leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2: one subtree is null so use the other subtree
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            // case 3: find the next smallest value in right subtree to make the new root node
            else {
                int smallestValue = findSmallestValue(root.right);
                root.val = smallestValue;
                root.right = removeNode(root.right, smallestValue);
                return root;
            }
        }

        // search left subtree if root is greater than key value, otherwise search right subtree
        if (key < root.val) {
            root.left = removeNode(root.left, key);
            return root;
        }
        root.right = removeNode(root.right, key);
        return root;
    }

    //searches for the smallest node in the subtree
    public int findSmallestValue(TreeNode root) {
        return root.left == null ? root.val : findSmallestValue(root.left);
    }
}
