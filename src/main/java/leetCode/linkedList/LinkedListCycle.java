package leetCode.linkedList;

public class LinkedListCycle {
    /*
    Given head, the head of a linked list, determine if the linked list has a cycle in it.

    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
    Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

    Return true if there is a cycle in the linked list. Otherwise, return false.
     */
    //TC: O(N+K), which is O(n) and constant space  Note: another approach is to use a Hashset visiting every node
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        /*
            move the fast pointer 2x faster than the slow pointer, if there is a cycle, eventually, the slow will
            catch up to fast, otherwise fast will just terminate loop
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            //Found a cycle
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
