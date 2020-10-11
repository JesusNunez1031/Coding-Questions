public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) { // leaf node
            return 1;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }
}
