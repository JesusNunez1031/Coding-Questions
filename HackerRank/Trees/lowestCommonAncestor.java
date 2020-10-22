public class lowestCommonAncestor {
    /*
        You are given pointer to the root of the binary search tree and two values v1 and v2. You need to return the lowest common ancestor (LCA) of v1 and v2 in the binary search tree.
            Note:
                The LCA between two nodes v1 and v2 is considered to be the lowest node in BST T that has both v1 and v2 as descendants (a node is allowed to be a descendant of itself)
     */

    public static Node lca(Node root, int v1, int v2) {
        //lca has to be on the same subtree, either the left or the right, if the values split, then we just return the root.
        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        }
        //if the values are greater than the root, lca must be in the right
        if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        }
        //if the values split, meaning only one is less than or greater than the root, we just return the root
        else {
            return root;
        }
    }
}
