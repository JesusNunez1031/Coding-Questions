public class oddEven {
    /*
        Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with
        even indices, and return the reordered list.

        The first node is considered odd, and the second node is even, and so on.

        Note that the relative order inside both the even and odd groups should remain as it was in the input.

        Example 1:
        Input: 1->2->3->4->5->NULL
        Output: 1->3->5->2->4->NULL

        Example 2:
        Input: 2->1->3->5->6->4->7->NULL
        Output: 2->3->6->7->1->5->4->NULL

        Constraints:
            The number of nodes in the linked list is in the range [0, 104].
            -10^6 <= Node.val <= 10^6

        Follow up: Could you solve it in O(1) space complexity and O(nodes) time complexity?
     */

    //TC: O(n) time and constant space since lists are made in place
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        //an even node is always next to an odd node, so we traverse the list by twos adding onto the unique odds and evens lists
        ListNode odds_list = head;   //list is 1 indexed so the first odd node is head
        ListNode odds = odds_list;  //ptr to odds

        //the second node is the first even node
        ListNode evens_list = head.next;
        ListNode evens = evens_list; //ptr to evens

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
