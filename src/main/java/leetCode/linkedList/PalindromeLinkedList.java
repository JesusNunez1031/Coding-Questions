package leetCode.linkedList;

import java.util.Stack;

public class PalindromeLinkedList {
    /*
        Given a singly linked list, determine if it is a palindrome.

        Example 1:
        Input: 1->2
        Output: false

        Example 2:
        Input: 1->2->2->1
        Output: true

        Follow up:
        Could you do it in O(n) time and O(1) space?
     */
    //TC: O(n) and constant space
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode slow = head, fast = head;

        //find the middle of the list
        while (fast != null && fast.next != null) {
            //Fast traverses 2x as fast slow
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse the latter half of the list
        slow = reverseList(slow);

        //rest the fast pointer back to the start of the list
        fast = head;

        /*
            compare the first half of the list with the latter half that has been reversed, if the list is a palindrome,
            both lists will be equal
         */
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    //Method to reverse a list given the first node
    private ListNode reverseList(ListNode head) {
        //prev is used to save the previous node of a node in the list
        ListNode prev = null;
        while (head != null) {
            //save the reference to the next node
            ListNode next = head.next;
            head.next = prev;   //point the next of the current node to the previous node
            prev = head;        //move the previous to the current node
            head = next;        //move the head to the next node reference
        }
        //when the list is reversed, prev will be the new head of the list
        return prev;
    }

    //Method using a Stack, TC/S: O(n) due to use of a stack
    public boolean isPalindromeStack(ListNode head) {
        if (head == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();

        ListNode iter = head;

        while (iter != null) {
            stack.push(iter.val);
            iter = iter.next;
        }
        ListNode iter2 = head;
        while (iter2 != null && !stack.isEmpty()) {
            if (stack.pop() != iter2.val) {
                return false;
            }
            iter2 = iter2.next;
        }
        return true;
    }
}
