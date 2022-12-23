package leetCode.linkedList;

import java.util.Stack;

public class flattenMultiLevelDoublyLinkedList {

    // Definition for a Node.
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        //Use a stack to process nodes in order that they come
        Stack<Node> stack = new Stack<>();
        Node flat = null;

        stack.push(head);

        //if a node has a child, we add it to the stack and it will be processed first along with all sub nodes
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            Node child = curr.child;

            //case for the first node
            if (flat != null) {
                flat.next = curr;
            }
            curr.prev = flat;

            //point the child node to null
            curr.child = null;
            flat = curr;    //move the ptr forward to the current node
            //add the next node to current
            if (curr.next != null) {
                stack.push(curr.next);
            }
            //add the child after the current.next so all its neighbor nodes nested children get processed first
            if (child != null) {
                stack.push(child);
            }
        }
        return head;
    }
}
