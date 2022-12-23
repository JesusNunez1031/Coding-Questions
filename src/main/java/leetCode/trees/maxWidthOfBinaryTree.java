package leetCode.trees;

import java.util.ArrayList;
import java.util.List;

public class maxWidthOfBinaryTree {
    /*
    Given a binary tree, write a function to get the maximum width of the given tree. The maximum width of a tree is the maximum width among all levels.
    The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes
    in the level, where the null nodes between the end-nodes are also counted into the length calculation.

    It is guaranteed that the answer will in the range of 32-bit signed integer.

    Example 1:
    Input:
               1
             /   \
            3     2
           / \     \
          5   3     9
    Output: 4
    Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

    Example 2:
    Input:
              1
             /
            3
           / \
          5   3
    Output: 2
    Explanation: The maximum width existing in the third level with the length 2 (5,3).

    Example 3:
    Input:
              1
             / \
            3   2
           /
          5
    Output: 2
    Explanation: The maximum width existing in the second level with the length 2 (3,2).

    Example 4:
    Input:
              1
             / \
            3   2
           /     \
          5       9
         /         \
        6           7
    Output: 8
    Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


    Constraints:
        The given binary tree will have between 1 and 3000 nodes.
     */
    //TC/S: O(n)
    private static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        /*
            search through the tree return the max width, the max width can be seen as the index of the right most
            node - the index of left most node + 1

            we keep track of the depth of each node and index of nodes so,
            index of root = 1, left child = 1 * 2, right child = 1 * 2 + 1 ...etc

            index is multiplied by 2 so for depth greater than 0, we account for all nodes in that level
            Ex:
                           1 -> 1
                         /   \
     width = 2 * 1 ->   3     2 -> 2 nodes
                       / \     \
     width = 2 * 2 -> 5   3     9 -> 4 nodes counting null
        */
        return getWidth(root, 0, 1, new ArrayList<>());
    }

    private static int getWidth(TreeNode root, int depth, int index, List<Integer> list) {
        if (root == null) {
            return 0;
        }

        //add the index of leftmost node to the list at the depth position
        if (depth == list.size()) {
            list.add(index);
        }

        int current_width = index - list.get(depth) + 1;
        int left_width = getWidth(root.left, depth + 1, index * 2, list);
        int right_width = getWidth(root.right, depth + 1, index * 2 + 1, list);

        return Math.max(current_width, Math.max(left_width, right_width));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        System.out.println(widthOfBinaryTree(root));
    }
}
