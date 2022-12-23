package leetCode.linkedList;

import java.util.HashMap;
import java.util.Map;

public class copyListWithRandomPointer {
    /*
    A linked list of length n is given such that each node contains an additional random pointer, which could point to
    any node in the list, or null.

    Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has
    its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes
    should point to new nodes in the copied list such that the pointers in the original list and copied list represent
    the same list state. None of the pointers in the new list should point to nodes in the original list.

    For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding
    two nodes x and y in the copied list, x.random --> y.

    Return the head of the copied linked list.

    The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val,
    random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not
    point to any node.
    Your code will only be given the head of the original linked list.

    Example 1:
    Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
    Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

    Example 2:
    Input: head = [[1,1],[2,1]]
    Output: [[1,1],[2,1]]

    Example 3:
    Input: head = [[3,null],[3,0],[3,null]]
    Output: [[3,null],[3,0],[3,null]]

    Example 4:
    Input: head = []
    Output: []
    Explanation: The given linked list is empty (null pointer), so return null.

    Constraints:
        0 <= n <= 1000
        -10000 <= Node.val <= 10000
        Node.random is null or is pointing to some node in the linked list.
     */
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    //TC: O(n) and O(n) space due to use of hash map
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        //store all the nodes in the list into a map
        Map<Node, Node> map = new HashMap<>();
        Node iter = head;

        while (iter != null) {
            //the value of the current node is a copy of the node's value
            map.put(iter, new Node(iter.val));
            iter = iter.next;
        }

        //make the new list from nodes in the map by taking the value of each node and assigning its .next and .random to the key's .next and .random
        for (Node key : map.keySet()) {
            Node newCopy = map.get(key);            //get the copy node of key
            newCopy.next = map.get(key.next);       //set the .next of the copy to node of key.next
            newCopy.random = map.get(key.random);   //set the random of the copy to node of key.random
        }

        //return the new head node from the map which is a deep copy of the original head
        return map.get(head);
    }

    //TC: O(n) time and constant time
    public Node copyRandomListEz(Node head) {
        if (head == null) {
            return null;
        }

        /*
            iter is the pointer to all nodes in the original list, we will make copies of each node in the list and set
            them to the next of the original nodes
        */
        Node iter = head;

        while (iter != null) {
            Node next = iter.next;
            Node random = iter.random;
            iter.next = new Node(iter.val, next, random);  //copy node of iter
            iter = iter.next.next;  //move to the .next of the copy
        }

        /*
            the random pointers of the alpha nodes, copy nodes, point to the original random nodes so we need to update
            this pointer by making the random of each alpha node point to the next node since all original nodes are now
            followed by an alpha node
        */

        Node alphaList = head.next;
        iter = head;

        while (iter != null) {
            Node alpha = iter.next;
            if (alpha.random != null) {
                alpha.random = alpha.random.next;
            }
            iter = alpha.next;
        }

        //unwind the list so only alpha nodes remain, we do this by pointing the next of each alpha node to the next of an original node
        iter = head;

        while (iter != null) {
            Node alpha = iter.next;  //alpha node, copy node
            iter.next = alpha.next;  //point the original node to another original node

            if (alpha.next != null) {
                alpha.next = iter.next.next; //point the current alpha node to another alpha node
            }
            //move to the next original node
            iter = iter.next;
        }
        return alphaList;
    }
}
