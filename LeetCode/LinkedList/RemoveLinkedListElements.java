public class RemoveLinkedListElements {

    /*
    Remove all elements from a linked list of integers that have value val.

    Example:
    Input:  1->2->6->3->4->5->6, val = 6
    Output: 1->2->3->4->5
     */

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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(6);

        removeElements(head, 2);

        while (head != null) {
            if (head.next == null) {
                System.out.printf("%d ", head.val);
            } else {
                System.out.printf("%d -> ", head.val);
            }
            head = head.next;
        }
    }
}
