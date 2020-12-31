import java.util.*;

public class bstZigZagLevelOrderTraversal {
    /*
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right
    to left for the next level and alternate between).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
    ]
     */
    //TC: O(n) and O(h) space used
    private List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zig_order = new ArrayList<>();
        if (root == null) {
            return zig_order;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zig_zag = false;    //boolean flag to indicate when to reverse the level

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();

                //if the level needs to be reversed, add values to stack, otherwise we do a normal level order traversal
                if (zig_zag) {
                    stack.push(curr.val);
                } else {
                    level.add(curr.val);
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            /*
                if the flag is true, we need to add the values from the stack to the level list, popping values from the
                stack will output values in reverse order
             */
            if (zig_zag) {
                while (!stack.isEmpty()) {
                    level.add(stack.pop());
                }
            }
            //add the level to the final list and trigger flag
            zig_order.add(level);
            zig_zag = !zig_zag;
        }
        return zig_order;
    }
}
