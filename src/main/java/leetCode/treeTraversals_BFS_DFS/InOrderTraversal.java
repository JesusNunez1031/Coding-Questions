package leetCode.treeTraversals_BFS_DFS;

import leetCode.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    /*
        Given the root of a binary tree, return the inorder traversal of its nodes' values.
        (Left, Root, Right)

        O(n) time and O(n) space due to recursive calls
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addHelper(root, list);

        return list;
    }

    public void addHelper(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                addHelper(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                addHelper(root.right, list);
            }
        }
    }

    //Iterative Solution
    /*
        using a stack and a list, we add every root we see and move left, once we reach the left most node, we add its value to the list, pop it from the stak
        and point the root to the right of that node. This will ensure we don't skip over any right nodes through the traversals
     */
    public List<Integer> inorderTraversalIter(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                list.add(stack.peek().val);
                root = stack.pop().right;
            }
        }
        return list;
    }
}
