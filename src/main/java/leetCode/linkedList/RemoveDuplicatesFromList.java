package leetCode.linkedList;

public class RemoveDuplicatesFromList {
    /*
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    Example 1:
    Input: 1->1->2
    Output: 1->2

    Example 2:
    Input: 1->1->2->3->3
    Output: 1->2->3
     */
    //TC: O(n) - Method preforms deletion in place using two Pointers
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        //to make de-referencing of duplicate nodes we save the previous of each node and only update its .next when its not a duplicate
        ListNode prev = head;
        ListNode iter = head.next;

        while (iter != null) {
            /*
                if the previous node == current node, check if the next is null, if so that means the last duplicate
                is at the end so we dereference it by setting the .next of prev to null, then we move to the next node
            */
            if (prev.val == iter.val) {
                if (iter.next == null) {
                    prev.next = null;
                }
            } else {
                /*
                    if the nodes value don't match, point the previous node .next to the current node, all duplicate nodes
                    after prev will be dereference, prev then becomes the current node and we move to the next node
                 */
                prev.next = iter;
                prev = prev.next;
            }
            iter = iter.next;
        }
        return head;
    }

    //Method deletes nodes by making a new list and adding only unique values to it
    public static ListNode deleteDuplicatesEz(ListNode head) {
        //Check for null lists
        if (head == null) {
            return null;
        }

        //Make a new List to hold values and set it to the first value in given list
        ListNode set = new ListNode(head.val);
        //Set a pointer var for set
        ListNode setHead = set;

        //move head pointer by one since we already added it to the set
        head = head.next;

        while (head != null) {
            //If the next value in given list isnt in out set, set it to the next node in set and move pointer
            if (head.val != setHead.val) {
                setHead.next = new ListNode(head.val);
                setHead = setHead.next;
            }
            //Otherwise we move given list pointer by 1
            head = head.next;
        }
        return set;
    }


    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);

        list.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        deleteDuplicates(list);

        list.print(list);

    }
}
