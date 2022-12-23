package leetCode.trees;

import leetCode.trees.SortedLListToBST.ListNode;

public class ConvertSortedListToBinarySearchTree {
    /*
    Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
    of every node never differ by more than 1.

    Example 1:
    Input: head = [-10,-3,0,5,9]
    Output: [0,-3,9,-10,null,5]
    Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

    Example 2:
    Input: head = []
    Output: []

    Example 3:
    Input: head = [0]
    Output: [0]

    Example 4:
    Input: head = [1,3]
    Output: [3,1]

    Constraints:
        The number of nodes in head is in the range [0, 2 * 10^4].
        -10^5 <= leetCode.trees.Node.val <= 10^5
     */
    //TC: O(n) and space is O(h)
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return makeTree(head);
    }

    private TreeNode makeTree(ListNode head) {
        //return null when no more list nodes remain
        if (head == null) {
            return null;
        }

        //get the middle node of the list while also dividing the array into two parts
        ListNode mid = findMid(head);

        //make the root of the current subtree the center node so we have a balanced left and right subtrees
        TreeNode root = new TreeNode(mid.val);

        //return the subtree if all nodes have been traversed in the current list
        if (head == mid) {
            return root;
        }

        //left is made from nodes before the middle node
        root.left = makeTree(head);

        //right is made from nodes after the mid
        root.right = makeTree(mid.next);

        return root;
    }

    //Method returns the latter half of given list
    private ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //break the link between the two lists if the middle is not null
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }
}
