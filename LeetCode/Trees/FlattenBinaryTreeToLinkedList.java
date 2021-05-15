public class FlattenBinaryTreeToLinkedList {
    /*
    Given the root of a binary tree, flatten the tree into a "linked list":
        - The "linked list" should use the same TreeNode class where the right child pointer points to the next node in
          the list and the left child pointer is always null.
        - The "linked list" should be in the same order as a pre-order traversal of the binary tree.

    Example 1:                                   [1]
    Input: root = [1,2,5,3,4,null,6]               \
                                  [1]               [2]
                                /     \                \
                              [2]      [5]     ===>     [3]
                             /   \        \                \
                           [3]   [4]       [6]              [4]
    Output: [1,null,2,null,3,null,4,null,5,null,6]             \
                                                                [5]
                                                                   \
                                                                    [6]
    Example 2:
    Input: root = []
    Output: []

    Example 3:
    Input: root = [0]
    Output: [0]

    Constraints:
        The number of nodes in the tree is in the range [0, 2000].
        -100 <= Node.val <= 100

    Follow up: Can you flatten the tree in-place (with O(1) extra space)?
     */
    //TC/S: O(n)
    public void flatten(TreeNode root) {
        //check for a valid tree
        if (root == null) {
            return;
        }

        //save references to the left and right of the tree
        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;

        //remove the current roots' left node
        root.left = null;

        //flatten the rest of the tree recursively
        flatten(tempLeft);
        flatten(tempRight);

        /*
            attach the left tree to the right of the root
            Ex: given tree       [1]
                                /   \
                              [2]   [5]
                             /   \
                           [3]   [4]
             1. save the reference to left and right and then remove left leaves,
                             [1]
                            /   \
                         null    [5]
              2. Attaching the left part to the right,
                             [1]
                            /   \
                        null     [2]
                                /   \
                             null    [4]
               3. move to the right most node and attach the right saved reference,
                              [1]
                             /   \
                          null    [2]
                                 /   \
                              null    [5] <- will eventually become 3 -> 4 -> 5 since we recursively repeat these steps
                                             using the saved reference of the left and right trees after flattening the
                                             whole tree
         */
        root.right = tempLeft;

        /*
            traverse to the bottom most right node in the current tree and attach the right of the tree so we can repeat
            the same steps in the new tree
         */
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        current.right = tempRight;
    }

    //Follow-up: TC:O(n) and constant space O(1) using Morris Traversal
    public void flattenIter(TreeNode root) {
        if (root == null) {
            return;
        }
        /*
            Traverse the whole tree starting from the root, if the left is not null, save the reference to the left subtree
            and traverse to the right most node of the left subtree. At the end, attach the right of the root to the
            root.left.right-most and set the left to null since that subtree will now be on the right; we do this before
            putting the left of the root to the right so as to further flatten the tree and not loose the root.right tree.

            Ex:         [1]
                       /   \
                     [2]    [5]
                    /   \      \
                  [3]    [4]    [6]

           1. tree has a left hence we move to [2], save reference of this tree.
           2. Using "current" move to [2]'s right most node, which is [4]
           3. point the right of [1] to the right of [4],
                        [2]
                       /   \
                     [3]    [4]
                               \
                                [5]
                                   \
                                    [6]
           4. erase the left of the root,
                                [1]
                               /   \
                             null   [5]
                                      \
                                       [6]
            5. point the modified left subtree to the right of the root,
                                    [1]
                                       \
                                        [2]
                                       /   \
                                     [3]    [4]
                                               \
                                                [5]
                                                   \
                                                    [6]
           6. move to [2] are repeat steps
         */
        while (root != null) {
            //if the left of the current root's tree is not null, traverse down to its rightmost child and connect
            if (root.left != null) {
                TreeNode left = root.left;
                TreeNode current = left;
                while (current.right != null) {
                    current = current.right;
                }
                current.right = root.right; //MT main step
                root.left = null;
                root.right = left;
            }
            //move to the next subtree
            root = root.right;
        }
    }
}
