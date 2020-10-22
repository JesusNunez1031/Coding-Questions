public class heightOfBinaryTree {
    /*
        given a BST, return the height of the tree.
            Note:
                A tree with only one node is considered to have a height of 0
     */

    public static int height(Node root) {
        if (root == null) {
            return -1;
        }

        int height_of_left = height(root.left);
        int height_of_right = height(root.right);


        return Math.max(height_of_left, height_of_right) + 1;
    }
}
