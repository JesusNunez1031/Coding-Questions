public class diameterOfBinaryTree {
    /*
    Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is
    the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

    Example:
    Given a binary tree
              1
             / \
            2   3
           / \
          4   5
    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

    Note: The length of path between two nodes is represented by the number of edges between them.
     */

    public static int diameter;

    private static int diameterOfBinaryTree(TreeNode root) {
        /*
            edges in a tree graph = number of Nodes - 1, so we find the number of nodes in the longest path and subtract
            1 to get number of edges
         */

        diameter = 1;
        findDepth(root);
        return diameter - 1;
    }

    public static int findDepth(TreeNode root) {
        /*
            when we reach a leaf node, we take the max of the right and left subtree and return the value + 1 to the
            parent node.
            The longest diameter is the max height, or path, of he left and right subtree + 1 to consider the connecting node
         */
        if (root == null) {
            return 0;
        }

        //traverse the left and right subtrees
        int left = findDepth(root.left);
        int right = findDepth(root.right);

        /*
            when we get to a parent node, the diameter is checked to see if its greater than the the height of the left
            and right subtrees plus the addition of the parent node, if not, we update it
        */
        diameter = Math.max(diameter, left + right + 1);

        //return the greater height between the left and right subtrees +1 to include the current root node
        return Math.max(left, right) + 1;
    }


    //Method using no global variables
    private int diameterOfBinaryTreeEz(TreeNode root) {
        int[] diameter = new int[1];

        findDepth(root, diameter);

        return diameter[0];
    }

    private int findDepth(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }

        int left = findDepth(root.left, diameter);
        int right = findDepth(root.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(0);
        root.left.left.left.right = new TreeNode(5);
        root.left.left.left.right.right = new TreeNode(14);
        root.left.left.left.left = new TreeNode(-1);
        root.right = new TreeNode(12);
        root.right = new TreeNode(25);

        System.out.println(diameterOfBinaryTree(root));
    }
}
