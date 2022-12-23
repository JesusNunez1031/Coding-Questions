package ctci.linkedLists;

public class sumLists extends ListNode {
    /*
    You have two numbers represented by a linked list, where each node contains a single
    digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
    function that adds the two numbers and returns the sum as a linked list.

    EXAMPLE
    Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
    Output: 2 -> 1 -> 9. That is, 912.

    FOLLOW UP
    Suppose the digits are stored in forward order. Repeat the above problem.
    Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
    Output: 9 -> 1 -> 2. That is, 912.
     */

    //Method is O(n) time, however it assumes both lists are equal to each other in size
    //To handle different size LinkedLists, we find out the one with the shorter length and pad it with zeros until it matches the length of the other list
    public static ListNode sumLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode result = new ListNode();
        ListNode head = result;

        int sum = 0;
        int carry = 0;
        while (l1 != null && l2 != null) {
            sum += carry;
            sum += l1.val;
            sum += l2.val;

            if (sum >= 10) {
                carry = 1;
            }
            result.val = sum % 10;
            sum = 0;

            /*if the next of l1 and l2 we make the .next of result a new node to hold another value, if both list.next = null
            then we proceed to check if the carry is 1 or 0, if its zero we are done and make null the end, otherwise we make
            a new node to hold the carry
             */
            result.next = l1.next != null && l2.next != null ? new ListNode() : carry == 0 ? null : new ListNode(1);
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(0);
        l2.next.next = new ListNode(0);

        ListNode sum = sumLists(l1, l2);

        while (sum != null) {
            if (sum.next == null) {
                System.out.printf("%d ", sum.val);
            } else {
                System.out.printf("%d -> ", sum.val);
            }
            sum = sum.next;
        }
    }
}
