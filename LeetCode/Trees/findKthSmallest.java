import java.util.Stack;

public class findKthSmallest {
    //Recursive approach O(n) time and space
    public int kthSmallest(TreeNode root, int k) {
        //nums[0] is the current value, and nums[1] is the value we want to return
        int[] nums = new int[2];

        //do an inorder traversal
        inOrder(root, nums, k);

        return nums[1];
    }

    public void inOrder(TreeNode root, int[] nums, int k) {
        if (root == null) {
            return;
        }

        inOrder(root.left, nums, k);
        //when the left recursive call ends, as we go back up the call stack, of the value of nums[0] == k, we return that value
        if (++nums[0] == k) {
            nums[1] = root.val;
        }
        inOrder(root.right, nums, k);
    }

    /*
        Using a stack, we push all the values we are visiting from the left onto it until we hit the last left node, then we begin to pop all values while decrementing k,
        once k is 0, we have reached the kth smallest. (Iterative approach O(h + k) where h is the height of the tree runtime and O(logn) average space, worst is O(N) since we use a stack
     */
    public int kthSmallestIter(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}
