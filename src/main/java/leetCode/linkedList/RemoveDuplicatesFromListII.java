package leetCode.linkedList;

public class RemoveDuplicatesFromListII extends ListNode {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode iter = head;
        //List we will return
        ListNode result = new ListNode(0);
        ListNode newList = result;

        //temp will hold the value that is the duplicate
        int temp = Integer.MIN_VALUE;

        while (iter != null) {
            //if we find a duplicate, we set it to a temp variable
            if (iter.next != null && iter.val == iter.next.val) {
                temp = iter.val;
                //if the current value is greater than the duplicate, we add it to the list
            } else if (iter.val > temp) {
                newList.next = new ListNode(iter.val);
                newList = newList.next;
            }
            iter = iter.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = null;

        System.out.println(deleteDuplicates(a));

        while (a.next != null) {
            System.out.println(a.val + " ");
        }
    }
}
