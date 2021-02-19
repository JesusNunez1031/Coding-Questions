public class subtreeOfAnotherTree {
    /*
    Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a
    subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could
    also be considered as a subtree of itself.

    Example 1:
    Given tree s:

         3
        / \
       4   5
      / \
     1   2
    Given tree t:
       4
      / \
     1   2
    Return true, because t has the same structure and node values with a subtree of s.


    Example 2:
    Given tree s:

         3
        / \
       4   5
      / \
     1   2
        /
       0
    Given tree t:
       4
      / \
     1   2
    Return false.
     */

    //TC: O(n * m) where n is the number of nodes in s and m is the number of nodes in t
    private static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        /*
            at every node of s, we call isSame to check if the node equals the root of t, if it doesnt, search left and
            right subtree until we find a potential match of nodes, if there is not match, we will have compared n nodes in
            s, m times to nodes in t therefore time complexity is O(n * m) worst case
        */
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(4);
        root2.right = new TreeNode(2);
        root2.left = new TreeNode(1);

        System.out.println(isSubtree(root, root2));
    }
}
