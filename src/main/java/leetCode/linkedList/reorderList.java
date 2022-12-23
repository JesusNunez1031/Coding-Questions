package leetCode.linkedList;

public class reorderList {
    /*
    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

    You may not modify the values in the list's nodes, only nodes itself may be changed.

    Example 1:
    Given 1->2->3->4, reorder it to 1->4->2->3.

    Example 2:
    Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
     */
    /*                                                  Pseudocode: 2 Pointers
        1. in order to reorder the list, we need to split the given list into two list, we start by getting the midpoint
           of the given list and reversing the second half
        2. Then we cut off the first half of the list to second and we can proceed to add values in the respective order
        3. Values are added in the following pattern, l1 -> l2 -> l1 -> l2..etc where l1 is the first list and l2 is the
           reversed list, whatever is left over is added to the end starting with l1 and then l2
     */
    //TC:O(n) and constant space
    private void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode tail = null;

        while (fast != null && fast.next != null) {
            tail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the latter half of the list
        ListNode rev = reverseList(slow);

        //to make a first half, we cut off the first half from the second half
        tail.next = null;

        reorder(head, rev);
    }

    private ListNode reorder(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode iter = result;

        /*
            we want to alternate taking values from the l1 and l2, so we use a boolean var to indicate when we take
            from one list, when false, we take from l1, when true, we take from l2
         */
        boolean takeFromReversed = false;

        while (l1 != null && l2 != null) {
            if (!takeFromReversed) {
                iter.next = l1;
                l1 = l1.next;
                takeFromReversed = true;
            } else {
                iter.next = l2;
                l2 = l2.next;
                takeFromReversed = false;
            }
            iter = iter.next;
        }
        if (l1 != null) {
            iter.next = l1;
        }
        if (l2 != null) {
            iter.next = l2;
        }
        return result.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}
