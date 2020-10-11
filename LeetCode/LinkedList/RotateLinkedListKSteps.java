public class RotateLinkedListKSteps {

    /*
    Since n may be a large number compared to the length of list we need to know the length of linked list.
    After that, move the list after the (l-n%l )th node to the front to finish the rotation.

    Ex: {1,2,3} k=2 Move the list after the 1st node to the front

    Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the front.

        So the code has three parts.
        1.  Get the length
        2.  Move to the (l-n%l)th node
        3. Do the rotation
     */

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        //Size is set to 1 since we are already at head
        int size = 1;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null) {
            size++;
            fast = fast.next;
        }

        int i = size - k % size;
        // i > 1 because we need to put slow.next at the start.
        while (i > 1) {
            slow = slow.next;
            i--;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
