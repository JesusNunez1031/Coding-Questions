package leetCode.linkedList;

public class reverseLinkedListII {
    /*
    Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the
    list from position left to position right, and return the reversed list.

    Example:
    Input: 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL

    Example 2:
    Input: head = [5], left = 1, right = 1
    Output: [5]

    Constraints:
        The number of nodes in the list is n.
        1 <= n <= 500
        -500 <= Node.val <= 500
        1 <= left <= right <= n
     */

    //TC: O(n) and constant space
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //if the list is empty or there is only one node
        if (head == null || head.next == null) {
            return head;
        }
        /*
            we need to save the previous node to the node at left so when the list is reversed, the previous section can
            be joined to reversed list
         */
        ListNode prev = null;
        ListNode iter = head; //node pointer to the current node

        //move to the start "m" of the list section to be reversed
        while (left > 1) {
            prev = iter;
            iter = iter.next;
            left--;
            /*
                decrease "right" so that when left == 1, right will be right - left places from the end, hence "right"
                will be the length of the list to be reversed
             */
            right--;
        }

        ListNode connection = prev;     //connection holds the node just before the node at "left"
        ListNode tail = iter;   //tail points the to node at "left" which after reversed will be come the tail of list

        //reverse the inner list from "left" to "right", iter will be at the node "right" + 1 when loop ends
        while (right > 0) {
            ListNode nextNode = iter.next;
            iter.next = prev;
            prev = iter;
            iter = nextNode;
            right--;
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
