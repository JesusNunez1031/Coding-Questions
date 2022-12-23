package leetCode.trees;

import java.util.ArrayList;
import java.util.List;

public class pathSumIII {
    /*
    You are given a binary tree in which each node contains an integer value.
    Find the number of paths that sum to a given value.

    The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

    The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

    Example:
    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
          10
         /  \
        5   -3
       / \    \
      3   2   11
     / \   \
    3  -2   1
    Return 3. The paths that sum to 8 are:
        1.  5 -> 3
        2.  5 -> 2 -> 1
        3. -3 -> 11
     */
    private int paths = 0;
    //TC: O(n^2) and O(h) space used to store the paths, h is the height of the tree
    private int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        //pre-order search for the sum
        searchPaths(root, sum, new ArrayList<>());

        return paths;
    }

    private void searchPaths(TreeNode root, int sum, List<Integer> nums) {
        if (root == null) {
            return;
        }
        nums.add(root.val); //add node to the path list

        /*
            search through the list of nodes starting from the end and increase the count every time we find a sum. We
            search from the end so as to not repeat paths by starting from the front
         */
        int pathSum = 0, size = nums.size();
        while (size-- > 0) {
            pathSum += nums.get(size);

            if (pathSum == sum) {
                paths++;
            }
        }

        //Search left and right subtrees and pass on a deep copy of the path array nums so we dont add on values not in the path
        searchPaths(root.left, sum, new ArrayList<>(nums));
        searchPaths(root.right, sum, nums);
    }
}
