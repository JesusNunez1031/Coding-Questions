package leetCode.trees;

import java.util.ArrayList;
import java.util.List;

public class increasingOrderSearchTree {
    /*
    Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child

    Example 1:
    Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
    Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
                               5                    1
                            /     \                  \
                           3       6                   2
                         /   \      \      ===>         \
                        2     4      8                    3
                       /           /   \                    \
                      1           7     9                     4
                                                                \
    Example 2:                                                    5 ... down to 9
    Input: root = [5,1,7]
    Output: [1,null,5,null,7]
                    5                    1
                 /     \        ==>       \
                1       7                   5
                                             \
                                              7
    Constraints:
        The number of nodes in the given tree will be in the range [1, 100].
        0 <= leetCode.trees.Node.val <= 1000
     */
    List<TreeNode> nodes = new ArrayList<>();

    //To perform this without using extra space, we use a Pointer and update in place during traversal
    TreeNode current_node = null;

    //TC: O(n) and space since we add all nodes into a list
    private TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        //make a new tree that will hold the final result
        TreeNode res = new TreeNode(0);
        current_node = res;

        //Perform an inorder traversal of the tree and store all the nodes into the list of nodes
        populateList(root);

        //to use no space, we call the inOrder method
        inOrder(root);

        /*
            iterate through the list of nodes and delete the left node of every node and make the right node the next
            node in the list, in the end
         */
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).left = null;
            nodes.get(i).right = nodes.get(i + 1);
        }

        //since we don't get to the last node, delete the left of the node to avoid cycles
        nodes.get(nodes.size() - 1).left = null;

        //return the fist node in the list since this is now the new root
        return nodes.get(0); //using no space we return res.right;
    }

    //inOrder Traversal
    private void populateList(TreeNode root) {
        if (root != null) {
            populateList(root.left);
            nodes.add(root);
            populateList(root.right);
        }
    }

    //Method to update nodes in place with no extra space
    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            /*
                set the left of the node in the tree to null to delete it, make the new list's node.right the current node
                root, and finally move the current_node pointer to the current node root to processes the next node
             */
            root.left = null;
            current_node.right = root;
            current_node = current_node.right;
            inOrder(root.right);
        }
    }
}
