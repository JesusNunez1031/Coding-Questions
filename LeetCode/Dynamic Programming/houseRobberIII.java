import java.util.*;

public class houseRobberIII {
    /*
    The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the
    "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that
    "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked
    houses were broken into on the same night.
    Determine the maximum amount of money the thief can rob tonight without alerting the police.

    Example 1:
    Input: [3,2,3,null,3,null,1]
         3
        / \
       2   3
        \   \
         3   1

    Output: 7
    Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

    Example 2:
    Input: [3,4,5,1,3,null,1]
         3
        / \
       4   5
      / \   \
     1   3   1

    Output: 9
    Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
     */
    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return findMax(root);
    }

    public int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //if the map has the root, we have calculated its max sum so we return it
        if (map.containsKey(root)) {
            return map.get(root);
        }

        int sum = root.val; //assume the root node is level 0 and is even

        //rob nodes of even levels, so we skip one level every traversal
        if (root.left != null) {
            sum += findMax(root.left.left);
            sum += findMax(root.left.right);
        }
        if (root.right != null) {
            sum += findMax(root.right.left);
            sum += findMax(root.right.right);
        }

        //at every iteration, the sum of odd level nodes will be the left and right to the nodes of the even levels
        int odd_node_sum = findMax(root.left) + findMax(root.right);

        //for the given root, we calculate the max sum up to that point
        map.put(root, Math.max(sum, odd_node_sum));

        //is it more profitable to rob the even or odd levels
        return Math.max(sum, odd_node_sum);
    }
}
