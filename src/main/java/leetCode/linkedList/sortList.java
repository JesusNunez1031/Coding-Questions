package leetCode.linkedList;

public class sortList {
    /*
    Given the head of a linked list, return the list after sorting it in ascending order.

    Follow up: Can you sort the linked list in O(n log n) time and O(1) memory (i.e. constant space)?

    Example 1:
                 4 -> 2 -> 1 -> 3
                        ↓
                 1 -> 2 -> 3 -> 4
    Input: head = [4,2,1,3]
    Output: [1,2,3,4]

    Example 2:
                 -1 -> 5 -> 3 -> 4 -> 0
                            ↓
                 -1 -> 0 -> 3 -> 4 -> 5
    Input: head = [-1,5,3,4,0]
    Output: [-1,0,3,4,5]

    Example 3:
    Input: head = []
    Output: []

    Constraints:
        The number of nodes in the list is in the range [0, 5 * 104].
        -10^5 <= Node.val <= 10^5
     */
    //TC: O(n log n) and O(n) space due to recursive stack
    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        /*
            Split the list into two parts to be used for sorting. To do this we split the list down until single nodes
            remain each call we find the mid of the given list
        */
        ListNode slow = head;
        ListNode fast = head;
        ListNode tail = null;

        while (fast != null && fast.next != null) {
            tail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
          /*
            the fist time we split the list in half, we set the tail.next to null to cut off the second half of the list
            we do this recursively for every sublist
        */
        tail.next = null;

        ListNode left_list = sortList(head);
        ListNode right_list = sortList(slow);

        return mergeLists(left_list, right_list);
    }

    private static ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(-1);
        ListNode l3 = merged;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if (l1 != null) {
            l3.next = l1;
        }
        if (l2 != null) {
            l3.next = l2;
        }
        return merged.next;
    }

    //Merge two lists using recursion
    private static ListNode mergeListsRec(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l2.val > l1.val) {
            return new ListNode(l1.val, mergeListsRec(l1.next, l2));
        } else {
            return new ListNode(l2.val, mergeListsRec(l1, l2.next));
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(10);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(-1);
        head.next.next.next.next.next = new ListNode(9);

        sortList(head);

        head.print(head);
    }
}
