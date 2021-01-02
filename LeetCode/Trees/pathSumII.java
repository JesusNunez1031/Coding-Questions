import java.util.ArrayList;
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

    private List<List<Integer>> paths = new ArrayList<>();  //list to hold all the paths to the target sum
    //TC: O(n) and O(n) space since we store the paths to every node
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return paths;
        }

        //pre-order traversal to check for all paths to the given sum
        searchPaths(root, sum, new ArrayList<>());

        return paths;
    }

    private void searchPaths(TreeNode root, int sum, List<Integer> path_sums) {
        if (root == null) {
            return;
        }

        sum -= root.val;
        path_sums.add(root.val);

        /*
            if we are at a leaf node, we check if the current path sums to the given sum, in this case, since we subtract
            the current values from the sum, we know the sum has been made if it is 0
         */
        if (root.left == null && root.right == null && sum == 0) {
            paths.add(path_sums);
        }

        /*
            we call the method back using a deep copy of the paths_sums array so that at every recursive stack call we
            get the reference of the array as it was prior to the current stack call and backtrack, so we avoid adding on to
            the same array
        */
        searchPaths(root.left, sum, new ArrayList<>(path_sums));
        searchPaths(root.right, sum, path_sums);
    }
}
