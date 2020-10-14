public class addNodeDoubleLinkedList {
//
//    Node SortedInsert(Node head,int data) {
//        Node n = new Node();
//        n.data = data;
//        if (head == null) {
//            return n;
//        }
//        else if (data <= head.data) {
//            n.next = head;
//            head.prev = n;
//            return n;
//        }
//        else {
//            Node rest = SortedInsert(head.next, data);
//            head.next = rest;
//            rest.prev = head;
//            return head;
//        }
//    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
        node.next = null;
        node.prev = null;
        if (head == null) {
            head = node;
        }

        if (data <= head.data) {
            node.next = head;
            head.prev = node;
            return node;
        }
        DoublyLinkedListNode parent = null;
        DoublyLinkedListNode iter = head;

        while (iter != null) {
            if (node.data <= iter.data) {
                break;
            }
            parent = iter;
            iter = iter.next;
        }
        //Insert at the head if parent == null
        if (parent == null) {
            node.next = head;
            head.prev = node;

            head = node;
        }

        parent.next = node;
        node.prev = parent;
        node.next = iter;

        if (iter != null) {
            iter.prev = node;
        }
        return head;
    }
}
