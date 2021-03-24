public class reverseLinkedListII {
    /*
    Reverse a linked list from position m to n. Do it in one-pass.
    Note: 1 ≤ m ≤ n ≤ length of list.

    Example:
    Input: 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL
     */

    //TC: O(n) and constant space
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //if the list is empty or there is only one node
        if (head == null || head.next == null) {
            return head;
        }
        /*
            we need to save the previous node to the node at m so when the list is reversed, the previous section can
            be joined to reversed list
         */
        ListNode prev = null;
        ListNode iter = head; //node pointer to the current node

        //move to the start "m" of the list section to be reversed
        while (m > 1) {
            prev = iter;
            iter = iter.next;
            m--;
            //decrease n so that when m == 1, n will be n - m places from the end, hence n will be the length of the list to be reversed
            n--;
        }

        ListNode connection = prev;     //connection holds the node just before the node m
        ListNode tail = iter;   //tail points the to node at m which after reversed will be come the tail of list

        //reverse the inner list from m to n, iter will be at the node n + 1 when loop ends
        while (n > 0) {
            ListNode nextNode = iter.next;
            iter.next = prev;
            prev = iter;
            iter = nextNode;
            n--;
        }

        /*
            if the connection is null, then the whole list was reversed so we point the head to the reversed list, otherwise
            we just connect the first part to the reversed list
        */
        if (connection == null) {
            head = prev;
        } else {
            connection.next = prev;
        }

        //connect the end of the reversed list to the rest of the list
        tail.next = iter;

        return head;
    }
}
