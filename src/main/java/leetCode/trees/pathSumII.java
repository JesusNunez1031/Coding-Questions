package leetCode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pathSumII {
    /*
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    Note: A leaf is a node with no children.

    Example:
    Given the below binary tree and sum = 22,

          5
         / \
        4   8
       /   / \
      11  13  4
     /  \    / \
    7    2  5   1

    Return:
    [
       [5,4,11,2],
       [5,8,4,5]
    ]
     */
    //TC: O(n) and O(n) space since we store the paths to every node
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> paths = new ArrayList<>(); //list to hold all the paths to the target sum

        searchForPaths(root, paths, new ArrayList<>(), targetSum);

        return paths;
    }

    private void searchForPaths(TreeNode root, List<List<Integer>> paths, List<Integer> path, int targetSum) {
        if (root == null) {
            return;
        }

        // reduce the total sum by the current node value and add it to the path
        targetSum -= root.val;
        path.add(root.val);

        // add the path if the current node is a leaf and if the path sums up to the total sum, i.e. sum == 0
        if (root.left == null && root.right == null && targetSum == 0) {
            paths.add(new ArrayList<>(path));
        }

        //search left and right subtrees using the current path and sum up to the current node
        searchForPaths(root.left, paths, path, targetSum);
        searchForPaths(root.right, paths, path, targetSum);

        path.remove(path.size() - 1); //backtrack by removing nodes from the path on new iterations

    }
}
