package leetCode.linkedList;

import java.util.ArrayList;
import java.util.List;

public class linkedListRandomNode {
    /*
    Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

    Follow up:
    What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

    Example:
        // Init a singly linked list [1,2,3].
        leetCode.linkedList.ListNode head = new leetCode.linkedList.ListNode(1);
        head.next = new leetCode.linkedList.ListNode(2);
        head.next.next = new leetCode.linkedList.ListNode(3);
        Solution solution = new Solution(head);

    // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
    solution.getRandom();
     */
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */

    /*
        First method is to iterate through the entire list and add all the nodes values to a an indexed structure like an
        array list, then we get a random index using the size of the array list as the upper bound, this however requires
        us to use extra space
     */
    List<Integer> nodes = new ArrayList<>();
    ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public linkedListRandomNode(ListNode head) {
        this.head = head;
        ListNode iter = head;

        while(iter != null) {
            this.nodes.add(iter.val);
            iter = iter.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int sample = (int) (Math.random() * this.nodes.size());
        return this.nodes.get(sample);
    }

    /*
       Reservoir Sampling solution
       We iterate through the list and at each element, we generate a random value that will determine if the current
       value should be included in the pool of chosen values the chance that a value will be picked in the list is i / k
       when i > k where i is the index and k is the size of the list, for every value in the list, there is a 1 / j
       chance it will be picked when j > i
     */
    public int getRandomRS() {
        int scope = 1;
        int chosenValue = 0;
        ListNode iter = this.head;

        while(iter != null) {
            //decide whether to include the current value in the reservoir
            if(Math.random() < 1.0 / scope) {
                chosenValue = iter.val;
            }
            //move forward to the next node
            scope++;
            iter = iter.next;
        }
        return chosenValue;
    }
}
