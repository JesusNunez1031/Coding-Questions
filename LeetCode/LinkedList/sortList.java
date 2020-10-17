public class sortList {
    /*
        Given the head of a linked list, return the list after sorting it in ascending order.
        Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

        Method Sorts a given list using mergesort which takes nlogn time, quicksort is also efficent however it has a worse case of n^2 given a bad partition, so its not the best to use
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode tail = null;

        while (fast != null && fast.next != null) {
            tail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        tail.next = null;

        ListNode left_list = sortList(head);
        ListNode right_list = sortList(slow);

        return mergeLists(left_list, right_list);
    }

    public static ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(0);
        ListNode iter = merged;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } else {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }

        if (l1 != null) {
            iter.next = l1;
        }
        if (l2 != null) {
            iter.next = l2;
        }

        return merged.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(10);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(-1);
        head.next.next.next.next.next = new ListNode(9);

        sortList(head);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
