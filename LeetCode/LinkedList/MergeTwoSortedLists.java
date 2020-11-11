import java.util.List;

public class MergeTwoSortedLists extends ListNode {
    /*
        Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

        Example 1:
        Input: l1 = [1,2,4], l2 = [1,3,4]
        Output: [1,1,2,3,4,4]

        Example 2:
        Input: l1 = [], l2 = []
        Output: []

        Example 3:
        Input: l1 = [], l2 = [0]
        Output: [0]

        Constraints:
            The number of nodes in both lists is in the range [0, 50].
            -100 <= Node.val <= 100
            Both l1 and l2 are sorted in non-decreasing order.
     */

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode head = newList;

        while (l1 != null && l2 != null) {
            //if the value in l1 is less than the value in l2, add it to the list
            if (l1.val <= l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                //otherwise add l2's value and move its pointer by 1
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }

        //check of a list is not empty yet, if one isn't, point sorted to the rest of the remaining list
        if (l1 == null && l2 != null) {
            head.next = l2;
        }
        if (l2 == null && l1 != null) {
            head.next = l1;
        }
        return newList.next;
    }
}
