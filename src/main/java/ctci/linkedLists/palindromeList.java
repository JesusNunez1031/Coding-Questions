package ctci.linkedLists;

import java.util.Stack;

public class palindromeList extends ListNode {
    /*
        Implement a function to check if a given list is a palindrome

        1. first solution is to reverse the linked list and compare the reversed list to the original list. If they're the
        same, the lists are identical.

        2. Use a stack to store half the list and then compare with the latter half, we do this using the slow and fast
        pointer method to get the center of the list
     */

    //Method runs in O(n+n/2) time so O(n) time
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        Stack<ListNode> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        //if there is no definitive middle, e.g odd number of items, skip the middle element
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != stack.pop().val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);
        list.next.next.next = new ListNode(2);
        list.next.next.next.next = new ListNode(1);
        list.next.next.next.next.next = new ListNode(0);

        System.out.println(isPalindrome(list));
    }
}
