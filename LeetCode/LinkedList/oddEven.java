public class oddEven {
    /*
        Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
        You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

        Example 1:
        Input: 1->2->3->4->5->NULL
        Output: 1->3->5->2->4->NULL

        Example 2:
        Input: 2->1->3->5->6->4->7->NULL
        Output: 2->3->6->7->1->5->4->NULL
     */

    private ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        //an even node is always next to an odd node, so we traverse the list by twos making unique odds and evens lists
        ListNode odds = head;   //list is 1 indexed so the first odd node is head
        ListNode odds_list = odds;

        ListNode evens = head.next;
        ListNode evens_list = evens;

        while (odds.next != null && evens.next != null) {
            //The next node in odds will be the next of evens and vise versa
            odds.next = evens.next;
            odds = odds.next;

            evens.next = odds.next;
            evens = evens.next;
        }

        //connect the two lists, if we wanted the even nodes first, evens.next = odds_list, and return evens_list
        odds.next = evens_list;

        return odds_list;
    }
}
