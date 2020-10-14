public class mergeTwoSortedLinkedList {

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }

        SinglyLinkedListNode result = new SinglyLinkedListNode(0);
        SinglyLinkedListNode current_node = result;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current_node.next = head1;
                head1 = head1.next;
            } else {
                current_node.next = head2;
                head2 = head2.next;
            }
            current_node = current_node.next;
        }

        if (head1 != null) {
            current_node.next = head1;
        }
        if (head2 != null) {
            current_node.next = head2;
        }
        return result.next;

    }
}
