package leetCode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTreesII {
    /*
    Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of
    unique values from 1 to n. Return the answer in any order.



    Example 1:
        [1]         [1]                 [2]             [3]      [3]
           \            \              /   \            /        /
            [3]          [2]        [1]     [3]       [2]      [1]
           /                \                         /          \
        [2]                  [3]                    [1]           [2]
    Input: n = 3
    Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

    Example 2:
    Input: n = 1
    Output: [[1]]

    Constraints:
        1 <= n <= 8
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }

        //start from the first root node, 1
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        // add a null node to mark the end of a path on a tree
        if (start > end) {
            list.add(null);
            return list;
        }

        // add the last node to the tree when we've reached the end
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        // generate all possible trees from start, i, to end nodes
        for (int i = start; i <= end; i++) {
            // generate left and right subtrees trees
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // attach the left and right possible trees to the current node i and add the tree to the list
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
