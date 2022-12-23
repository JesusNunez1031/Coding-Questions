package leetCode.linkedList;

public class swapNodesInPairs {

    /*
    Given a linked list, swap every two adjacent nodes and return its head.
    You may not modify the values in the list's nodes. Only nodes itself may be changed.

    Example 1:
    Original: 1 -> 2 -> 3 -> 4
    Swapped: 2 -> 1 -> 4 -> 3
    Input: head = [1,2,3,4]
    Output: [2,1,4,3]

    Example 2:
    Input: head = []
    Output: []

    Example 3:
    Input: head = [1]
    Output: [1]

    Constraints:
        The number of nodes in the list is in the range [0, 100].
        0 <= Node.val <= 100
     */
    /*                                                   Pseudocode
       1. we want to swap "first" with "second", so we take the nodes .next from "second" and append them to "first" so
          that "first" is now in the place where "second" used to be
            Ex: 1 -> 2 -> 3 -> 4
                first_node = 1
                second_node = 2
          we want to swap 1 and 2 so by making first_node.next = second.next, we get 1 -> 3 -> 4, the 1 is now in the right
          place, now we need to place the 2 before the 1

       2. "current" is our iterator, so its next will be the node that was just swapped so we make it point the the "second_node"
            Ex:
                    -1 -> 2 -> 3 -> 4
                     ↑    ↑
           current(dummy) second

       3. both nodes have been swapped so all that is left is to combine the lists so we set the next of "second" to "first"
             Ex: list is now -1 -> 2 -> 1 -> 3 -> 4
                              ↑    ↑
                   current(dummy) second
       4. move the iterator by 2, -1 -> 2 -> 1 -> 3 -> 4
                                             ↑
                                       current(dummy)
    */
    //TC: O(n) time and constant space
    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode swapped = new ListNode(-1);
        swapped.next = head;    //append the entire list to the next of swapped

        ListNode current = swapped; //list iterator

        //Move through list two nodes at a time
        while (current.next != null && current.next.next != null) {

            //Get the two nodes to be swapped [Node: initially current == -1, current.next = first node in head]
            ListNode first_node = current.next;
            ListNode second_node = current.next.next;

            //place the first_node in the place of the second_node
            first_node.next = second_node.next;

            //place the second_node in the place of the first_node
            current.next = second_node;

            //now combine the two nodes back into the main list
            current.next.next = first_node;

            //move the iter to the next two nodes to be swapped
            current = current.next.next;
        }
        return swapped.next;
    }

    //Recursive solution, O(n) space is used due to recursive stack
    private static ListNode swapPairsRec(ListNode head) {
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

    public static void main(String[] args) {
        ListNode list = new ListNode().makeList(4);
        ListNode head = swapPairs(list);
        head.print(head);
    }
}
