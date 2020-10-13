public class addAtHead {


    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        if(llist == null) {
            llist = new SinglyLinkedListNode(data);
            return llist;
        }
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        node.next = llist;

        return node;
    }
}
