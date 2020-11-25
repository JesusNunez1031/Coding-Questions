import java.util.*;

public class levelOrderTraversalII {
    /*
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
    level by level from leaf to root).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
    return its bottom-up level order traversal as:
        [
          [15,7],
          [9,20],
          [3]
        ]
     */
    //TC: O(n) and O(n) space
    private List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        //Stack used to reverse all the levels
        Stack<List<Integer>> stack = new Stack<>();

        //queue used to perform the level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                level.add(current.val);

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            //add the list of current nodes in the level to a stack
            stack.add(level);
        }

        /*
            the top of the stack holds the last level in the tree while the oldest list in the stack is the first level.
            To get the bottom up order of the levels, pop all the lists in the stack and add them to the result list
            as they come
         */

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
