public class maximumBinaryTree {
    /*
    You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums
    using the following algorithm:
        - Create a root node whose value is the maximum value in nums.
        - Recursively build the left subtree on the subarray prefix to the left of the maximum value.
        - Recursively build the right subtree on the subarray suffix to the right of the maximum value.
        - Return the maximum binary tree built from nums.

    Example 1:
    Input: nums = [3,2,1,6,0,5]
    Output: [6,3,5,null,2,0,null,null,1]
    Explanation: The recursive calls are as follow:
    - The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
        - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
            - Empty array, so no child.
            - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
                - Empty array, so no child.
                - Only one element, so child is a node with value 1.
        - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
            - Only one element, so child is a node with value 0.
            - Empty array, so no child.

    Example 2:
    Input: nums = [3,2,1]
    Output: [3,null,2,null,1]

    Constraints:
        1 <= nums.length <= 1000
        0 <= nums[i] <= 1000
        All integers in nums are unique.
     */
    //TC: O(n^2) and best case of O(n log n)
    private TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return constructTree(nums, 0, nums.length);
    }

    private TreeNode constructTree(int[] nums, int left, int right) {
        //like a binary search, we return null when the range is invalid, e.g. when left index is >= right
        if (left >= right) {
            return null;
        }

        //find the index of the max value in nums in the range of left and right
        int max_value = findMax(nums, left, right);

        //make the root the value of the max index found in the range of left to right
        TreeNode root = new TreeNode(nums[max_value]);

        //repeat the steps for the left and right subtrees
        root.left = constructTree(nums, left, max_value);  //search for the max in the range of the left up to the index of the first max
        root.right = constructTree(nums, max_value + 1, right); //search for larger values from the index of the max + 1 to the right

        //Return the root in the constructed tree
        return root;
    }

    //method to search for a max value in nums in the range of left and right and return its index
    private int findMax(int[] nums, int left, int right) {
        int max = left;

        for (int i = left; i < right; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }
}
