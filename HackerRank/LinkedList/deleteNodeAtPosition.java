public class deleteNodeAtPosition {

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (head == null) {
            return null;
        }
        SinglyLinkedListNode iter = head;

        while (iter != null) {
            if (position == 0) {
                iter.data = iter.next.data;
                iter.next = iter.next.next;
            }
            iter = iter.next;
            position--;
        }
        return head;
    }
}
