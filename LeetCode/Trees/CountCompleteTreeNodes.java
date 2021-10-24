public class CountCompleteTreeNodes {
    /*
    Given the root of a complete binary tree, return the number of the nodes in the tree.

    According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and
    all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last
    level h.

    Design an algorithm that runs in less than O(n) time complexity.

    Example 1:
    Input: root = [1,2,3,4,5,6]
    Output: 6

    Example 2:
    Input: root = []
    Output: 0

    Example 3:
    Input: root = [1]
    Output: 1

    Constraints:
        The number of nodes in the tree is in the range [0, 5 * 10^4].
        0 <= Node.val <= 5 * 10^4
        The tree is guaranteed to be complete.
     */
    //TC: O(n)
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // height of the left subtree, starts at 1 to account for current node
        int leftLevels = 1;
        TreeNode l = root.left;

        // get the height of the left subtree
        while (l != null) {
            l = l.left;
            leftLevels += 1;
        }

        // height of the right subtree, starts at 1 to account for current node
        int rightLevels = 1;
        TreeNode r = root.right;

        // get the height of the right subtree
        while (r != null) {
            r = r.right;
            rightLevels += 1;
        }

        /*
            if both heights of the left and right subtree are the same, then the subtree is a complete subtree hence
            we return the number of nodes in the subtree which can be determined by using the following formula,
            nodes in Tree = 2 ^ (# of levels in tree) - 1
         */
        if (leftLevels == rightLevels) {
            return (int) Math.pow(2, leftLevels) - 1;
        }

        // return the number of complete nodes on the left, and right + 1 to account for the root node
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
