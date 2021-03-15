import java.util.ArrayList;
import java.util.List;

public class swappingNodesInLinkedList {
    /*
    You are given the head of a linked list, and an integer k.

    Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node
    from the end (the list is 1-indexed).

    Example 1:
    [1] -> [2] -> [3] -> [4] -> [5]
            *             #
    [1] -> [4] -> [3] -> [2] -> [5]
            #             *
    Input: head = [1,2,3,4,5], k = 2
    Output: [1,4,3,2,5]

    Example 2:
    Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
    Output: [7,9,6,6,8,7,3,0,9,5]

    Example 3:
    Input: head = [1], k = 1
    Output: [1]

    Example 4:
    Input: head = [1,2], k = 1
    Output: [2,1]

    Example 5:
    Input: head = [1,2,3], k = 2
    Output: [1,2,3]

    Constraints:
        The number of nodes in the list is n.
        1 <= k <= n <= 105
        0 <= Node.val <= 100
     */
    //TC/S: O(n) and O(n) space since we store all the nodes into a list
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //turn the linked list to an array
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        //swap the kth node from the front with the kth node from the end
        Integer temp = list.get(k - 1);
        list.set(k - 1, list.get(list.size() - k));
        list.set(list.size() - k, temp);

        //Turn the arraylist back to a linked list
        ListNode newHead = new ListNode(-1);
        ListNode iter = newHead;

        for (Integer val : list) {
            iter.next = new ListNode(val);
            iter = iter.next;
        }

        return newHead.next;
    }

    //TC: O(n)
    public ListNode swapNodesEz(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        ListNode n1, n2;

        //move fast pointer k nodes forward
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        //save the reference to fast node since this node is k nodes from the front
        n1 = fast;

        //when fast reaches the last node in the list, slow will be k nodes from the end, i.e. that second node to be swapped
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //save the reference to the second node
        n2 = slow;

        //swap the values from slow and fast
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;

        //return the list with swapped nodes
        return head;
    }
}
