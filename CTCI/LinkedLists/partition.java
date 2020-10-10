import java.util.List;

public class partition extends ListNode {
    /*
    Write code to partition a linked list around a value x, such that all nodes less than x come
    before all nodes greater than or equal to x. If x is contained within the list the values of x only need
    to be after the elements less than x (see below). The partition element x can appear anywhere in the
    "right partition"; it does not need to appear between the left and right partitions.

    EXAMPLE
    Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
    Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
     */

    /*
    We can do this by creating two lists, one to hold the values less than the partition value and
    another to hold the values greater than partition. We do this in place by making two copies of the
    given linked list, every time we encounter a lesser value, we move the pointer to the next node and make the head of
    the lesser list the next node.
    If the value is greater, we make it the next node in tail and move the tail pointer. At the end, we make the .next in tail null to mark the end
    and return the head since that holds all the modified values
    O(n) runtime
     */
    public static ListNode partition(ListNode node, int x) {
        //Elements in the list less than x are placed at the head, the larger elements go at the tail
        ListNode head = node;
        ListNode tail = node;

        while(node != null) {
            ListNode next = node.next;
            if(node.val < x) {
                //Place node at head list
                node.next = head;
                head = node;
            } else {
              //insert node at the tail list
              tail.next = node;
              tail = node;
            }
            node = next;
        }
        tail.next = null;

        //return the head of the modified list
        return head;
    }
}
