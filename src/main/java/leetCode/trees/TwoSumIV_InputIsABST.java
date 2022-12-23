package leetCode.trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoSumIV_InputIsABST {
    /*
    Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST
    such that their sum is equal to the given target.



    Example 1:
    Input: root = [5,3,6,2,4,null,7], k = 9
    Output: true

    Example 2:
    Input: root = [5,3,6,2,4,null,7], k = 28
    Output: false

    Example 3:
    Input: root = [2,1,3], k = 4
    Output: true

    Example 4:
    Input: root = [2,1,3], k = 1
    Output: false

    Example 5:
    Input: root = [2,1,3], k = 3
    Output: true

    Constraints:
        The number of nodes in the tree is in the range [1, 10^4].
        -10^4 <= leetCode.trees.Node.val <= 10^4
        root is guaranteed to be a valid binary search tree.
        -10^5 <= k <= 10^5
     */
    //TC/SC: O(n) using BFS and Set
    public boolean findTarget(TreeNode root, int k) {
        // set to store seen values
        Set<Integer> set = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();

                //check of the difference between k and the current node's value has been seen
                if (set.contains(k - curr.val)) {
                    return true;
                }

                //add the current node's value to the set for future reference
                set.add(curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return false;
    }
}
