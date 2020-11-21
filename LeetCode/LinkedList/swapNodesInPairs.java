public class swapNodesInPairs {

    /*
    Given a linked list, swap every two adjacent nodes and return its head.
    You may not modify the values in the list's nodes. Only nodes itself may be changed.

     */
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        //pointer used to iterate through the list, we do .next since the first node of temp is 0
        ListNode current = temp.next;

        //Move through list two nodes at a time
        while (current.next != null && current.next.next != null) {
            //Get the two first nodes in list
            ListNode first_node = current.next;
            ListNode second_node = current.next.next;

            //make the first nodes next the second nodes next
            first_node.next = second_node.next;
            //Make the first node the second node
            current.next = second_node;

            //point the first node, previously the second node, to the rest of the list where its head is the old first node
            current.next.next = first_node;

            //move current to the third node
            current = current.next.next;
        }
        return temp.next;
    }

    //Recursive solution
    public ListNode swapPairsRec(ListNode head) {
        if ((head == null) || (head.next == null))
            return head;
        //Set n to the node after the initial head
        ListNode n = head.next;
        //Set the next to the third node
        head.next = swapPairsRec(head.next.next);
        //point n back to the rest of the list
        n.next = head;
        return n;
    }
}
