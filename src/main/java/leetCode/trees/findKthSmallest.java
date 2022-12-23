package leetCode.trees;

import java.util.Stack;

public class findKthSmallest {
    //Recursive approach O(n) time and space
    private int kthSmallest(TreeNode root, int k) {
        //count_smallest[0] is the current smallest counter, and count_smallest[1] is the kth smallest value
        int[] count_smallest = new int[2];

        //do an inorder traversal
        inOrder(root, count_smallest, k);

        return count_smallest[1];
    }

    private void inOrder(TreeNode root, int[] count_smallest, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left, count_smallest, k);
        //when the counter at count_smallest[0] is equal to k, we set count_smallest[1] to the root val since its the kth smallest value
        if (++count_smallest[0] == k) {
            count_smallest[1] = root.val;
        }
        inOrder(root.right, count_smallest, k);
    }

    /*
        Using a stack, we push all the values we are visiting from the left onto it until we hit the last left node,
        then we begin to pop all values while decrementing k, once k is 0, we have reached the kth smallest. (Iterative
        approach O(h + k) where h is the height of the tree runtime and O(logn) average space, worst is O(N) since we
        use a stack
     */
    private int kthSmallestIter(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            //Add all the left values to the stack
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //Pop the leftmost node and check if its the kth smallest, if not, move to the right of the current popped node
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            //if the current node has no right node, we pop the next node in the stack
            root = root.right;
        }
        return -1;
    }
}
