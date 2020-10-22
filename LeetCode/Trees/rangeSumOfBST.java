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
    int rangeSum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        calculateSum(root, L, R);
        return rangeSum;
    }

    public void calculateSum(TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }
        //inOrder traversal, if the current node is in the range of L and R, add its value to the total sum
        calculateSum(root.left, L, R);

        if (root.val >= L && root.val <= R) {
            rangeSum += root.val;
        }

        calculateSum(root.right, L, R);
    }
}
