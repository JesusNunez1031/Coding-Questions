public class convertSortedArrayToBST {
    /*
    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

    Example:

    Given the sorted array: [-10,-3,0,5,9],

    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

          0
         / \
       -3   9
       /   /
     -10  5
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return constructBST(nums, 0, nums.length - 1);
    }

    public TreeNode constructBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        //make the mid of the array the new node, at every recursive call, the next node will be the sub-array's mid
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBST(nums, left, mid - 1);
        root.right = constructBST(nums, mid + 1, right);

        return root;
    }

//    public static TreeNode sortedArrayToBSTIter(int[] nums) {
//        if (nums.length == 0) {
//            return null;
//        }
//        int left = 0;
//        int right = nums.length - 1;
//        int mid = left + (right - left) / 2;
//
//        TreeNode root = new TreeNode(nums[mid]);
//
//        while (left <= mid - 1) {
//            int m = left + ((mid - 1) - left) / 2;
//            root = addToTree(root, nums[m]);
//            left++;
//        }
//
//        int j = mid + 1;
//        while (j <= nums.length - 1) {
//            int m = j + (right - j) / 2;
//            root = addToTree(root, nums[m]);
//            j++;
//        }
//        return root;
//    }
//
//    public static TreeNode addToTree(TreeNode root, int value) {
//        if (root == null) {
//            return new TreeNode(value);
//        }
//        if (value < root.val) {
//            root.left = addToTree(root.left, value);
//        } else if (value > root.val) {
//            root.right = addToTree(root.right, value);
//        }
//
//        return root;
//    }
}
