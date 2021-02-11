public class RemoveLinkedListElements {

    /*
    Remove all elements from a linked list of integers that have value val.

    Example:
    Input:  1->2->6->3->4->5->6, val = 6
    Output: 1->2->3->4->5
     */

    //TC: O(n)
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        //Get rid of any initial nodes that might be equal to the val
        while (head != null && head.val == val) {
            head = head.next;
        }

        //Create a reference node to the head
        ListNode current_node = head;

        while (current_node != null && current_node.next != null) {
            if (current_node.next.val == val) {
                //If currentNode.next == val, we make its .next, the next if the node whose value == val
                current_node.next = current_node.next.next;
            } else {
                //otherwise we move forward one node
                current_node = current_node.next;
            }
        }
        return head;
    }

    //TC: O(n)
    public ListNode removeElementsEz(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //start by getting rid of any nodes at the start with the value val
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode iter = head;
        //to make it easier to delete nodes, save the reference to the current nodes previous node
        ListNode prev = null;

        while (iter != null) {
            /*
                when val is encountered, set the previous nodes to the .next of the val node and move the
                iter pointer to the next node, otherwise, traverse the list normally
            */
            if (iter.val == val) {
                prev.next = iter.next;
                iter = prev.next;
            } else {
                prev = iter;
                iter = iter.next;
            }
        }
        return head;
    }
}
