package leetCode.trees;

public class sumOfNodesWithEvenValuedGrandparents {
    /*
    Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)
    If there are no nodes with an even-valued grandparent, return 0.

    Example 1:
                            [6]
                         /       \
                        7        [8]
                      /  \       /  \
                     2 <- 7 <-  1 <- 3 <-
                    /    /  \         \
                   9    1    4         5 <-

    Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
    Output: 2 + 7 + 1 + 3 + 5 = 18
    Explanation: The nodes with arrows are the nodes with even-value grandparent while the nodes in brackets are the even-value grandparents.
     */
    public int sumEvenGrandparent(TreeNode root) {
        int[] res = new int[1];     //array to hold the sum of nodes
        traverseTree(root, null, null, res);
        return res[0];
    }

    public void traverseTree(TreeNode current, TreeNode parent, TreeNode grandparent, int[] res) {
        if (current == null) {
            return;
        }
        //if the grandparent is an even valued node, we add the sum of the current node
        if (grandparent != null && grandparent.val % 2 == 0) {
            res[0] += current.val;
        }

        //after one call, the current becomes the parent, and the grandparent is the parent
        traverseTree(current.left, current, parent, res);
        traverseTree(current.right, current, parent, res);
    }
}
