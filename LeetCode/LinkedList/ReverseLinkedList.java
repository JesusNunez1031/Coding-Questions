public class ReverseLinkedList {


    //Iterative solution
    public static ListNode reverseListIter(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;

        while (head != null) {
            //Temp variable to hold reference to the head.next
            ListNode next = head.next;
            //Set the new next of current head to the previous node
            head.next = prev;
            //Move previous pointer to the head
            prev = head;
            //Head of the list is now the the next value in list
            head = next;
        }
        return prev;
    }

    //Recursive solution
    public static ListNode reverseListRec(ListNode head) {
        if (head == null) {
            return null;
        }

        return reverseListRecHelper(head, null);
    }

    private static ListNode reverseListRecHelper(ListNode head, ListNode prev) {
        if(head == null) {
            return prev;
        }
        //Store reference value to head.next
        ListNode next = head.next;
        head.next = prev;

        return reverseListRecHelper(next, head);
    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.printf("%d -> ", head.val);
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        reverseListRec(head);

        printList(head);
    }
}
