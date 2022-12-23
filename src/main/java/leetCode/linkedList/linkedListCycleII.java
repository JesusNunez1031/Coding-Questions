package leetCode.linkedList;

public class linkedListCycleII {
    /*
    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
    following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
    connected to. Note that pos is not passed as a parameter.

    Notice that you should not modify the linked list.

    Example 1:
    Input: head = [3,2,0,-4], pos = 1
    Output: tail connects to node index 1
    Explanation: There is a cycle in the linked list, where tail connects to the second node.

    Example 2:
    Input: head = [1,2], pos = 0
    Output: tail connects to node index 0
    Explanation: There is a cycle in the linked list, where tail connects to the first node.

    Example 3:
    Input: head = [1], pos = -1
    Output: no cycle
    Explanation: There is no cycle in the linked list.

    Constraints:
        The number of the nodes in the list is in the range [0, 104].
        -10^5 <= Node.val <= 10^5
        pos is -1 or a valid index in the linked-list.

    Follow up: Can you solve it using O(1) (i.e. constant) memory?
     */
    //TC: O(n) and constant space Floyd's Cycle detection algorithm
    public ListNode detectCycle(ListNode head) {
        //if the head is null or if we have a single node, there is no cycle
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        /*
            Using two pointers, move "slow" one step at a time while "fast" traverses the list 2x faster than slow
            If there is a cycle in the list, the slow pointer will eventually meet with the fast pointer and when that
            happens, we mark hasCycle to true and break out of the loop
        */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { //if a cycle was found, mark hasCycle as true
                hasCycle = true;
                break;
            }
        }

        //check if we found a cycle, if we didn't, return null
        if (!hasCycle) {
            return null;
        }
       /*
            The reason we don't just return the next from where slow and fast meet, is because that is just used to
            confirm that there is a cycle. slow and fast might not meet up at the node where cycle starts, therefore, to
            accurately find the start of the cycle, we reset either slow or fast to the head, and have them traverse one
            node at the time, when slow and fast finally meet again, both will be at the start of the cycle
        */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        //either slow or fast will be at the start of the cycle
        return slow;
    }
}
