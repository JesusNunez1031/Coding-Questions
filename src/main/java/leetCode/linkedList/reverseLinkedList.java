package leetCode.linkedList;

public class reverseLinkedList {

    /*
    Reverse a singly linked list.

    Example:
    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL

    Follow up:
    A linked list can be reversed either iteratively or recursively. Could you implement both?
     */

    //Iterative solution TC/S: O(n) and constant space used
    public static ListNode reverseListIter(ListNode head) {
        if (head == null) {
            return null;
        }

        //To easily reverse list, save a reference to the previous node
        ListNode prev = null;   //reference to the previous node

        while (head != null) {
            //Temp variable to hold reference to the next node to current node
            ListNode next = head.next;
            //Set the new next of current head to the previous node
            head.next = prev;
            //Move previous pointer to the head
            prev = head;
            //Head of the list is now the the next value in list
            head = next;
        }
        //when the list is reversed, the new head node is at the end of the list so we return prev
        return prev;
    }

    //Recursive solution TC/S: O(n)
    public static ListNode reverseListRec(ListNode head) {
        if (head == null) {
            return null;
        }

        return reverseListRecHelper(head, null);
    }

    private static ListNode reverseListRecHelper(ListNode head, ListNode prev) {
        //if the head is null, we've reached the end of the list so we return the new head, prev
        if(head == null) {
            return prev;
        }
        //Store reference value to head.next
        ListNode next = head.next;
        head.next = prev;

        //call method with the new head node and the previous node
        return reverseListRecHelper(next, head);
    }

    public static void main(String[] args) {
        //make a new list of size 5
        ListNode list = new ListNode().makeList(5);

        //since reverseList return prev, we make a new list with the new returned head
        ListNode reverse = reverseListIter(list);

       reverse.print(reverse);
    }
}
