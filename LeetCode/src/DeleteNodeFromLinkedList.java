public class DeleteNodeFromLinkedList {
    /*
    Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.

    It is guaranteed that the node to be deleted is not a tail node in the list.
     */
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public void deleteNode(ListNode node) {
        //Make the value of the node to be deleted to the value of the next node
        node.val=node.next.val;
        //Delete the next node by making it equal to the next of the .next
        node.next=node.next.next;
    }
}
