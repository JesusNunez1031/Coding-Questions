package leetCode.design;

import leetCode.trees.TreeNode;

import java.util.Stack;

public class BSTIterator {
    /*
    Implement the leetCode.design.BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
       - leetCode.design.BSTIterator(TreeNode root) Initializes an object of the leetCode.design.BSTIterator class. The root of the BST is given as part
         of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
       - boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise
         returns false.
       - int next() Moves the pointer to the right, then returns the number at the pointer.

    Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the
    smallest element in the BST.

    You may assume that next() calls will always be valid. That is, there will be at least a next number in the
    in-order traversal when next() is called.

    Example 1:
                7
              /   \
             3     15
                  /   \
                 9     20
    Input:
    ["leetCode.design.BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
    [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
    Output:
    [null, 3, 7, true, 9, true, 15, true, 20, false]

    Explanation:
    leetCode.design.BSTIterator bSTIterator = new leetCode.design.BSTIterator([7, 3, 15, null, null, 9, 20]);
    bSTIterator.next();    // return 3
    bSTIterator.next();    // return 7
    bSTIterator.hasNext(); // return True
    bSTIterator.next();    // return 9
    bSTIterator.hasNext(); // return True
    bSTIterator.next();    // return 15
    bSTIterator.hasNext(); // return True
    bSTIterator.next();    // return 20
    bSTIterator.hasNext(); // return False


    Constraints:
        The number of nodes in the tree is in the range [1, 105].
        0 <= Node.val <= 10^6
        At most 10^5 calls will be made to hasNext, and next.

    Follow up:
        Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?
     */

    /*
        Using a stack to simulate the recursive stack, we start by adding the root and all its left nodes to the stack,
        the top node will be the smallest value. After the first call of next(), we remove the smallest from the stack
        and then call the addLeftInOrder method to add all the left nodes of the right of the node that has just been
        removed. This ensures that we see nodes in order. We do loop through the nodes to add them to the stack, however,
        the average time complexity remains constant since we don't always add N nodes, and even if the tree is skewed,
        the method would only be called once for that specific tree.

        TC: O(1) time and O(h) space is used

        A O(n) and constant access to values can also be done using a queue. We do an actual inOrder traversal and add the
        nodes to the queue and then perform the methods by removing from the front of the queue. This however, does not
        satisfy the follow up question.
     */

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        addLeftInOrder(root);
    }

    private void addLeftInOrder(TreeNode root) {
        //add all the nodes to the left of given root to the stack
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    private int next() {
        TreeNode topNode = this.stack.pop();
        /*
            we call the addLeftInOrder method to add the topNodes right node to the stack along with all its left nodes,
            this will ensure an inOrder order of nodes in the stack
        */
        if (topNode.right != null) {
            this.addLeftInOrder(topNode.right);
        }
        return topNode.val;
    }

    private boolean hasNext() {
        return !stack.isEmpty();
    }
}
