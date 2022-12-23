package leetCode.treeTraversals_BFS_DFS;

import leetCode.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal extends TreeNode {

    /*
        Given the root of a binary tree, return the postorder traversal of its nodes' values.

        (Left, Right, Root)
     */

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addHelper(root, list);
        return list;
    }

    public void addHelper(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                addHelper(root.left, list);
            }
            if (root.right != null) {
                addHelper(root.right, list);
            }
            list.add(root.val);
        }
    }

    //Iterative solution using stacks and linked lists
    public List<Integer> postorderTraversalIter(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) {
            return result;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            //all values are added to the front of the list
            result.addFirst(current.val);

            if(current.left != null) {
                stack.push(current.left);
            }
            if(current.right != null) {
                stack.push(current.right);
            }
        }
        return result;
    }
}
