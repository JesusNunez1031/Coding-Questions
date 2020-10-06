public class ReversedLinkedListII {


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        //Varaibles to store the previous node and reference to the head used as the start to the to be reversed list
        ListNode prev = null;
        ListNode current_node = head;

        while (m > 1) {
            //While we are not at positon m, update current and prev nodes
            prev = current_node;
            current_node = current_node.next;
            m--;
            n--;
        }

        //Connection holds the node that will need to be connected to the tail of the reversed list while tail is the node that will become the last node in reversed list
        ListNode connection = prev;
        ListNode tail = current_node;

        //This is where we do the reversing of the list from m to n
        while (n > 0) {
            ListNode next = current_node.next;
            current_node.next = prev;
            prev = current_node;
            current_node = next;
            n--;
        }

        //Connect the node m-1 to the reversed list, if its null, then the whole list was reversed, so make head prev
        if (connection != null) {
            connection.next = prev;
        } else {
            head = prev;
        }
        //connect the tail to the n-1 node
        tail.next = current_node;

        return head;
    }
}
