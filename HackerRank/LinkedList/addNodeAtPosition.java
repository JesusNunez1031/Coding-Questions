public class addNodeAtPosition {
    /*
        Given the pointer to the head node of a linked list and an integer to insert at a certain position, create a new node with the given integer
        as its data attribute, insert this node at the desired position and return the head node. A position of 0 indicates head, a position of 1 indicates one node away from the head and so on.
        The head pointer given may be null meaning that the initial list is empty.
     */

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        if (head == null) {
            head = new SinglyLinkedListNode(data);
        }
        SinglyLinkedListNode iter = head;
        int counter = 1;

        while (iter != null) {
            if (counter == position) {
                SinglyLinkedListNode node = new SinglyLinkedListNode(data);
                node.next = iter.next;
                iter.next = node;
            }
            iter = iter.next;
            counter++;
        }
        return head;
    }
}
