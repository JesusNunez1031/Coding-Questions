public class insertIntoBST {

    /*
        You are given a pointer to the root of a binary search tree and values to be inserted into the tree.
        Insert the values into their appropriate position in the binary search tree and return the root of the updated
        binary tree. You just have to complete the function.
     */

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
}
