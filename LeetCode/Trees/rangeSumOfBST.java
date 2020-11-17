public class rangeSumOfBST {

    /*
        Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
        The binary search tree is guaranteed to have unique values.

        Example 1:
        Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
        Output: 32

        Example 2:
        Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
        Output: 23
     */
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        //if the root is in the range of low and high, add it to the sum
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        //traverse left and right subtrees
        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);

        return sum;
    }
}
