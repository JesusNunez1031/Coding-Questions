public class RangeSumOfBST {

    /*
        Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes
        with a value in the inclusive range [low, high].

        Example 1:
        Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
        Output: 32
        Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

        Example 2:
        Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
        Output: 23
        Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

        Constraints:
            The number of nodes in the tree is in the range [1, 2 * 104].
            1 <= Node.val <= 105
            1 <= low <= high <= 105
            All Node.val are unique.
     */
    int sum = 0;
    //TC: O(n)
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

    public int rangeSumBSTEz(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        // add to the total sum if the root value is in range of low and high
        else if (root.val >= low && root.val <= high) {
            return root.val += rangeSumBSTEz(root.left, low, high) + rangeSumBSTEz(root.right, low, high);
        }
        // search right subtree of the current node is less than the low
        else if (root.val < low) {
            return rangeSumBSTEz(root.right, low, high);
        }
        // if the root node is greater than low, look for a smaller node on the left
        else return rangeSumBSTEz(root.left, low, high);
    }
}
