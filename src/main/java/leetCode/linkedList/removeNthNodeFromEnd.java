package leetCode.linkedList;

public class removeNthNodeFromEnd {

    /*
        Given the head of a linked list, remove the nth node from the end of the list and return its head.

        Example 1:
        Input: head = [1,2,3,4,5], n = 2
        Output: [1,2,3,5]

        Example 2:
        Input: head = [1], n = 1
        Output: []

        Example 3:
        Input: head = [1,2], n = 1
        Output: [1]

        Constraints:
            The number of nodes in the list is sz.
            1 <= sz <= 30
            0 <= Node.val <= 100
            1 <= n <= sz
     */

    //Method runs in O(n + n) or O(n) O(1) space
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        //Move fast ptr n steps forward
        for (int i = 0; i < n; i++) {
            //if fast hits null when moving it n steps, that means n is not valid since its larger than the list
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        //Save the previous value in case the node to delete is the last node in the list
        ListNode prev = null;

        /*
            Since we moved fast n steps forward, it will beat slow at reaching the end by a gap of n steps, therefore
            slow is guaranteed to be at the nth node from the end by the time fast reaches the end
        */
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        //If the node is at the end make the previous node point to null
        if (slow.next == null) {
            prev.next = null;
        } else {
            //We make the value of the node to be deleted the value of the .next and then point it to the .next of the next node
            slow.val = slow.next.val;
            slow.next = slow.next.next;
        }
        //return the head pointer reference
        return head;
    }
}
