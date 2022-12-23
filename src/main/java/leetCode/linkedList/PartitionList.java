package leetCode.linkedList;

public class PartitionList {
    /*
    Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    Example 1:
    [1] -> [2] -> [3] -> [2] -> [5] -> [2]

    [1] -> [2] -> [2] -> [4] -> [3] -> [5]
    Input: head = [1,4,3,2,5,2], x = 3
    Output: [1,2,2,4,3,5]

    Example 2:
    Input: head = [2,1], x = 2
    Output: [1,2]

    Constraints:
        The number of nodes in the list is in the range [0, 200].
        -100 <= Node.val <= 100
        -200 <= x <= 200
     */
    //TC: O(n)
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        //Initialize two lists, one for all nodes less than x, and another for values equal and greater than x
        ListNode lessThan = new ListNode(-1);
        ListNode tailL = lessThan;
        ListNode iter = head;

        ListNode greaterThan = new ListNode(-1);
        ListNode tailG = greaterThan;

        //if the current value "iter" is less than x add it to "tailL", less than list, otherwise add it to the greater list
        while (iter != null) {
            if (iter.val < x) {
                tailL.next = new ListNode(iter.val);
                tailL = tailL.next;
            } else {
                tailG.next = new ListNode(iter.val);
                tailG = tailG.next;
            }
            iter = iter.next;
        }

        //connect the two lists so the less than values come first
        tailL.next = greaterThan.next;

        return lessThan.next;
    }
}
