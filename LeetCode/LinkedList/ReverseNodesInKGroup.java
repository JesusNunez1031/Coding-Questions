public class ReverseNodesInKGroup {
    /*
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

    k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a
    multiple of k then left-out nodes, in the end, should remain as it is.

    You may not alter the values in the list's nodes, only nodes themselves may be changed.

    Example 1:
    [1] -> [2] -> [3] -> [4] -> [5]
    [2] -> [1] -> [4] -> [3] -> [5]
    Input: head = [1,2,3,4,5], k = 2
    Output: [2,1,4,3,5]

    Example 2:
    [1] -> [2] -> [3] -> [4] -> [5]
    [3] -> [2] -> [1] -> [4] -> [5]
    Input: head = [1,2,3,4,5], k = 3
    Output: [3,2,1,4,5]

    Example 3:
    Input: head = [1,2,3,4,5], k = 1
    Output: [1,2,3,4,5]

    Example 4:
    Input: head = [1], k = 1
    Output: [1]

    Constraints:
        The number of nodes in the list is in the range sz.
        1 <= sz <= 5000
        0 <= Node.val <= 1000
        1 <= k <= sz

    Follow-up: Can you solve the problem in O(1) extra memory space?
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //number of nodes in the list, start at 1 since we are sure there is at least one node, i.e. head != null
        int nodesLeft = 1;

        ListNode revList = new ListNode(-1); // new list with k reversed nodes
        revList.next = head;

        ListNode iter = head;

        //count the number of nodes in the list so we can later use this value to know when we can no longer reverse k nodes
        while (iter.next != null) {
            iter = iter.next;
            nodesLeft++;
        }

        //reset the iter node back to the head of the new list
        iter = revList;

        while (iter != null) {
            //break out of the loop when we can no longer reverse k nodes
            if (nodesLeft < k) {
                break;
            }

            int nodes = k; //nodes to be reversed, two nodes are observed at once hence k - 1

            // when the section of k nodes is reversed, iter.next will be the last node of the reversed section
            ListNode tail = iter.next;

            //reverse nodes by 2's
            ListNode first = iter.next;
            ListNode second = first.next;

            //reverse the k nodes
            while (nodes-- > 1) {
                ListNode next = second.next;
                second.next = first;
                first = second;
                second = next;
            }

            //reduce the number of nodes left
            nodesLeft -= k;

            /*
                the section of k nodes is now reversed so we set the next of the iter ptr to the reversed sections new
                head node and the old head node of the section, i.e. the tail node's .next is the reset of the list
                    ex: [-1] -> [1] -> [2] -> [3] -> [4] -> [5] k = 2 | t = tail, f = first, and s = second

                    after reversing the first 2 nodes: [-1] -> [1] <- [2] -> [3] -> [4] -> [5]
                                                                t      f      s

                    iter.next = first and tail.next = second: [-1] -> [2] -> [1] -> [3] -> [4] -> [5]
                                                                       f      t      s
                    finally we move iter to t so we can then reverse the next k nodes
             */
            iter.next = first;
            tail.next = second;

            //move to the tail to continue reversing the rest of the nodes
            iter = tail;
        }

        return revList.next;
    }
}
