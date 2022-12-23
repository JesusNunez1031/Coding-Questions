package leetCode.treeTraversals_BFS_DFS;

import leetCode.trees.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrderTraversal {

    /*
     Given the root of a binary tree, return the preorder traversal of its nodes' values.
     (Root, Left, Right)
     */

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        addHelper(root, list);

        return list;
    }

    public void addHelper(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                addHelper(root.left, list);
            }
            if (root.right != null) {
                addHelper(root.right, list);
            }
        }
    }

    public List<Integer> preorderTraversalIter(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        //Add root to the stack
        stack.push(root);

        //every time we pop a value, we add the right first and then the left to the stack so we are able to process the left node first from the stack
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }
}
