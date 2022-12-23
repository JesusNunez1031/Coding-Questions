package leetCode.trees;

public class SortedArrayToBinarySearchTree {


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return constructTreeFromArray(nums, 0, nums.length - 1);
    }

    public TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        //Binary Search application to problem
        if (left > right) {
            return null;
        }
        int midpoint = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[midpoint]);
        //Construct left tree from all the values left to the midpoint
        node.left = constructTreeFromArray(nums, left, midpoint - 1);

        //Construct right tree from all the values right to the midpoint
        node.right = constructTreeFromArray(nums, midpoint + 1, right);

        return node;
    }

}
