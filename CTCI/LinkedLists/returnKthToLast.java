public class returnKthToLast extends ListNode {

    /*
    Iterative solution using two pointers, we position ptr1 and ptr2 k nodes apart. We first move ptr1 k nodes deep and then we begin to iterate from ptr2.
    By the time ptr1 reaches the end, ptr2 will be k places from the list and at the node we need to delete

     */
    //Time complexity is O(n) with O(1) space
    public static ListNode returnKthToLast(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = head;

        //place ptr1 k nodes into the list
        for(int i = 0; i < k;i++) {
            if(ptr1 == null) {
                return null;
            }
            ptr1 = ptr1.next;
        }

        //By the time ptr1 reaches the end, ptr2 will be at the element we want to modify
        while(ptr1 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr2;
    }

    //Recursive solution O(n) time and O(n) space
    public static int returnKthListNodeRec(ListNode head, int k) {
        if(head == null) {
            return 0;
        }

        int pos = returnKthListNodeRec(head, k) + 1;

        //If the counter == k, we are at the correct position
        if(pos == k) {
            System.out.printf("%dth to last node is %d", k, head.val);
        }
        return pos;
    }

    //Easiest method is when the length of the list is given to us, in which case the problem Time complexity becomes O(length-k) with O(1) space
    public static ListNode returnKthToLastListLength(ListNode head, int k, int length) {
        if(head == null) {
            return null;
        }

        while (length != k) {
            head = head.next;
            length--;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(returnKthToLast(head, 3).val);
        System.out.println(returnKthToLastListLength(head, 3, 6).val);
    }
}
