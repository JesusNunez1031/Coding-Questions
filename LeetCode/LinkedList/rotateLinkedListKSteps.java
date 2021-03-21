public class rotateLinkedListKSteps {
    /*
    Given the head of a linked list, rotate the list to the right by k places.

    Example 1:

        Original List: 1 -> 2 -> 3 -> 4 -> 5
        rotate 1: 5 -> 1 -> 2 -> 3 -> 4
        rotate 2: 4 -> 5 -> 1 -> 2 -> 3 -> 4

    Input: head = [1,2,3,4,5], k = 2
    Output: [4,5,1,2,3]

    Example 2:

        Original List: 0 -> 1 -> 2
        rotate 1: 2 -> 0 -> 1
        rotate 2: 1 -> 2 -> 0
        rotate 3: 0 -> 1 -> 2
        rotate 4: 2 -> 0 -> 1

    Input: head = [0,1,2], k = 4
    Output: [2,0,1]

    Constraints:
        The number of nodes in the list is in the range [0, 500].
        -100 <= Node.val <= 100
        0 <= k <= 2 * 10^9
     */

    /*
    Since k may be a large number compared to the length of list we need to know the length of linked list.
    After we get the length, move a pointer to right after the (l - k % l)th node where l is the length of the list, to
    the front to finish the rotation.

    Ex: given the list: 1 -> 2 -> 3 -> 4 -> 5 and k = 2
                                            ↑
                                           tail
    1. the size of the list is 5
    2. we need to move to the node at position i = size - (k % size), or the node just before the new head after list is
       rotated. i = 5 - (2 % 5) = 5 - 2 = 3
       Here, 3 is the node at position i. 1 -> 2 -> 3 -> 4 -> 5
                                                    ↑         ↑
                                                 new tail    tail
    3. To rotate the list, we set the .next of the end of the list to the list itself so the list becomes the following,
       5 -> 1 -> 2 -> 3 -> 4 -> 5 -> 1 -> 2 -> 3 -> 4 -> 5 -> ... (values repeat)
       ↑              ↑                                  ↑
      tail         new tail                             cycle
    4. then we set the head to the .next of the new_tail so the list becomes 4 -> 5 -> 1 -> 2 -> 3 -> 4 -> 5
                                                                             ↑                   ↑
                                                                            head              new tail
    5. Finally, we get rid of the excess, we set the .next of new_tail to null so the final list becomes, 4 -> 5 -> 1 -> 2 -> 3 -> NULL
       which has been rotated 2 steps k to the right
     */

    //TC: O(n) and constant space
    private static ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        /*
            in order to rotate the list, we need to first get the size of the list, doing so will allow us to get the
            node that will be the new tail of the list after its been rotated. We also need to get the reference to the
            tail of the list to create a cycle in the list
        */
        ListNode tail = head;
        int size = 1;   //size starts at 1 since we know the head is not null

        while(tail.next != null) {
            size++;
            tail = tail.next;
        }

        /*
            i is the node that will be the new_tail, if we want to rotate the list 2 nodes to the right, then the last 2
            nodes will be moved to the front, and the rest, size - (k % size) nodes will remain
        */
        int i = size - (k % size);
        ListNode new_tail = head;

        //if k is 0, that means we have no nodes to shift so we directly return the list
        if(k == 0) {
            return head;
        }

        //i > 1 since we want the loop to end at the node i
        while(i > 1) {
            new_tail = new_tail.next;
            i--;
        }

        //create the cycle in the list
        tail.next = head;

        //the .next of the ith node, "new_tail" is the new head of the reversed list, so we set the head to this node
        head = new_tail.next;

        //now we get rid of the cycle by deleting all nodes after the new_tail
        new_tail.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode();
        ListNode head = list.makeList(5);
        list.print(head);

        System.out.println(rotateRight(head, 10));

    }
}
