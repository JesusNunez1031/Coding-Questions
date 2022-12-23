package leetCode.trees;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Method creates a Tree structure using values from {@code nums} array, {@code null} values in the array are considered as
     * nodes. values are added from left to right, i.e. root is index 0, left is index 1, right is index 2, left of the
     * left subtree is index 3, right of the left subtree is 4, left of right subtree is index 5, right of the right subtree
     * is index 6, etc.
     *
     * @param nums Integer array of values, {@code null} values are considered nodes to be skipped
     * @return A Tree constructed from {@code nums} values
     */
    public TreeNode makeTree(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return makeTreeHelper(nums, 0);
    }

    //helper method to construct tree using values in Integer array
    private TreeNode makeTreeHelper(Integer[] nums, int index) {
        //when we are out of bounds of indexes in the array, return null
        if (index >= nums.length || nums[index] == null) {
            return null;
        }

        //make the root of the current subtree
        //leetCode.trees.TreeNode root = nums[index] == null ? null : new leetCode.trees.TreeNode(nums[index]);
        TreeNode root = new TreeNode(nums[index]);

        //if we are at the last element in the array, return the node
        if (index == nums.length - 1) {
            return root;
        }

        /*
            since we want to add elements linearly into the tree, the left node for any ith value will be the index at
            (2 * i + 1) and the right node will be the index at (2 * i + 2), these nodes are created recursively.
         */
        root.left = makeTreeHelper(nums, (2 * index) + 1);
        root.right = makeTreeHelper(nums, (2 * index) + 2);

        return root;
    }


    /**
     * Method returns an inorder traversal of given tree
     *
     * @param root root node of tree
     */
    public void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.val + " ");
            print(root.right);
        }
    }
}
