public class DeleteMiddleNode extends ListNode {


    //Delete the middle node of a list given access to only the center node
    public static boolean deleteMiddleNode(ListNode node) {
        if(node == null || node.next == null) {
            return false;
        }

        //Make reference var to the value of the next node
        ListNode next = node.next;
        //Set the node to be deleted value to the value of the node next to it
        node.data = next.data;
        //point the node next to the node whose data we just copied from, node is now deleted
        node.next = next.next;
        return true;

    }
}
