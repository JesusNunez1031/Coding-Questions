package ctci.linkedLists;

public class LoopDetection extends ListNode {
    /*
    Given a circular linked list, implement an algorithm that returns the node at the
    beginning of the loop.

    DEFINITION
    Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
    as to make a loop in the linked list.

        EXAMPLE
        Input:  A - > B - > C - > D - > E - > C [the same C as earlier]
        Output: C

     */

    public static ListNode findStartOfLoop(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        //Find the point in which both pointers collide [size of list - k] steps into list
        while (fast != null && fast .next != null) {
            slow = slow.next;
            fast = fast.next.next;

            //Collision
            if(slow == fast) {
                break;
            }
        }

        //The list has no meeting point so no loop
        if(fast == null || fast.next == null) {
            return null;
        }

        /*
        Move slow to head and keep fast at collision point. Both are k steps from the start of the loop.
        If they move at the same pace, they must meet at loop start since fast is k steps from the head, all slow
        has to do if move k steps from head and they will reach the loop
         */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        //Both pointers now point to the start of the loop
        return fast;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(7);
        l1.next.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next.next = new ListNode(1);
        l1.next.next.next.next.next.next.next = new ListNode(10);
        l1.next.next.next.next.next.next.next = l1.next.next.next;

        System.out.printf("Loop starts at node -> %d", findStartOfLoop(l1).val);
    }
}
