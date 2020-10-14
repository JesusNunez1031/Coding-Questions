public class reverseList {
    /*
        given the head of a linked list, reverse the list and return the new head
     */

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null) {
            return null;
        }

        SinglyLinkedListNode prev = null;

        while (head != null) {
            SinglyLinkedListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
