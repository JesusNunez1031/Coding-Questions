public class ReverseLinkedList {

    /*
    Reverse a singly linked list.

    Example:
    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL

    Follow up:
    A linked list can be reversed either iteratively or recursively. Could you implement both?
     */


    //Iterative solution
    public static ListNode reverseListIter(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;   //reference to the previous node

        while (head != null) {
            //Temp variable to hold reference to the head.next
            ListNode next = head.next;
            //Set the new next of current head to the previous node
            head.next = prev;
            //Move previous pointer to the head
            prev = head;
            //Head of the list is now the the next value in list
            head = next;
        }
        return prev;
    }

    //Recursive solution
    public static ListNode reverseListRec(ListNode head) {
        if (head == null) {
            return null;
        }

        return reverseListRecHelper(head, null);
    }

    private static ListNode reverseListRecHelper(ListNode head, ListNode prev) {
        if(head == null) {
            return prev;
        }
        //Store reference value to head.next
        ListNode next = head.next;
        head.next = prev;

        return reverseListRecHelper(next, head);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        //since reverseList return prev, we make a new list with the new returned head
        ListNode reverse = reverseListRec(head);

       reverse.print(reverse);
    }
}
