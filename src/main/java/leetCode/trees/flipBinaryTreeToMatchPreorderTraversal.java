package leetCode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class flipBinaryTreeToMatchPreorderTraversal {
    /*
    You are given the root of a binary tree with n nodes, where each node is uniquely assigned a value from 1 to n. You
    are also given a sequence of n values voyage, which is the desired pre-order traversal of the binary tree.

    Any node in the binary tree can be flipped by swapping its left and right subtrees. For example, flipping node 1 will
    have the following effect:
                  1                     1
                /   \                 /   \
               2     3      ==>      3     2
                    /  \           /   \
                   4    5         4     5

    Flip the smallest number of nodes so that the pre-order traversal of the tree matches voyage.

    Return a list of the values of all flipped nodes. You may return the answer in any order. If it is impossible to flip
    the nodes in the tree to make the pre-order traversal match voyage, return the list [-1].

    Example 1:
            1
           /
          2
    Input: root = [1,2], voyage = [2,1]
    Output: [-1]
    Explanation: It is impossible to flip the nodes such that the pre-order traversal matches voyage.

    Example 2:
             1
           /   \
          2     3
    Input: root = [1,2,3], voyage = [1,3,2]
    Output: [1]
    Explanation: Flipping node 1 swaps nodes 2 and 3, so the pre-order traversal matches voyage.

    Example 3:
             1
           /   \
          2     3
    Input: root = [1,2,3], voyage = [1,2,3]
    Output: []
    Explanation: The tree's pre-order traversal already matches voyage, so no nodes need to be flipped.

    Constraints:
        The number of nodes in the tree is n.
        n == voyage.length
        1 <= n <= 100
        1 <= leetCode.trees.Node.val, voyage[i] <= n
        All the values in the tree are unique.
        All the values in voyage are unique.
     */
    int index;
    int[] v;
    List<Integer> flipped_nodes;

    //TC/S: O(n)
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        index = 0;
        v = voyage;
        flipped_nodes = new ArrayList<>();

        //if true, return the list of nodes flipped, else return -1 since trees can match pre-order traversal
        return dfs(root) ? flipped_nodes : Collections.singletonList(-1);
    }

    //Returns true if tree matches voyage or if its nodes can be flipped to match it, false otherwise
    private boolean dfs(TreeNode root) {
        //path has been fully traversed
        if (root == null) {
            return true;
        }

        /*
            if the current node in the tree does not equal the node in voyage, return false since the tree can be flipped
            index++ so we can check the next node on left or right, depending on where we are on the tree
         */
        if (root.val != v[index++]) {
            return false;
        }

        /*
            if the left of the current node does not equal to v[i], simulate flipping the nodes by calling the pre-order
            traversal on right before left, the current node is also added to the flipped_nodes list since its left node
            has been "flipped"
        */
        if (root.left != null && root.left.val != v[index]) {
            flipped_nodes.add(root.val);
            return dfs(root.right) && dfs(root.left);
        }
        // perform the pre-order traversal normally since trees are equal at this stage
        else {
            return dfs(root.left) && dfs(root.right);
        }
    }
}
