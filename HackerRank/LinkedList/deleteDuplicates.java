public class deleteDuplicates {

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        if (head == null) {
            return null;
        }
        SinglyLinkedListNode result = new SinglyLinkedListNode(head.data);
        SinglyLinkedListNode iter = result;
        head = head.next;

        while (head != null) {
            if (iter.data != head.data) {
                iter.next = new SinglyLinkedListNode(head.data);
                iter = iter.next;
            }
            head = head.next;
        }
        return result;
    }
}
