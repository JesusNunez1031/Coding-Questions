package leetCode.trees;

public class SortedLListToBST {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }

        return ConstructBSTFromList(head, null);
    }

    public TreeNode ConstructBSTFromList(ListNode head, ListNode tail) {
        if(head == tail) {
            return null;
        }

        ListNode slow = head, fast = head;

        //After while loop, slow will be at midpoint node
        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode node = new TreeNode(slow.val);

        //Populate left side of the tree and right
        node.left = ConstructBSTFromList(head, slow);
        node.right = ConstructBSTFromList(slow.next, tail);

        return node;
    }

}
