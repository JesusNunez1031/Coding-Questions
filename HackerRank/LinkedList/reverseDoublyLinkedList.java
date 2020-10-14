public class reverseDoublyLinkedList {
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head == null) {
            return head;
        }

        DoublyLinkedListNode current_node = head;
        DoublyLinkedListNode new_head = head;

        while (current_node != null) {
            //save reference to the prev node
            DoublyLinkedListNode prev = current_node.prev;
            //Make the node that used to be the next the previous node
            current_node.prev = current_node.next;
            //make the current nodes.next to the prev
            current_node.next = prev;
            //Move the new head the the node
            new_head = current_node;

            current_node = current_node.prev;
        }
        return new_head;
    }
}
