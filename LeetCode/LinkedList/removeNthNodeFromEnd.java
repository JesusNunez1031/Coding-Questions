public class removeNthNodeFromEnd {

    /*
        Given the head of a linked list, remove the nth node from the end of the list and return its head.
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
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        //Save the previous value in case n = 1
        ListNode prev = null;
        //By the time fast reaches the end, slow will be at the node we want to delete
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
