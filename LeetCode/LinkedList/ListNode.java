public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int data) {
        this.val = data;
    }

    ListNode(int value, ListNode next) {
        this.next = next;
        this.val = value;
    }

    //Print the values in the list
    public void print(ListNode head) {
        ListNode iter = head;
        while (iter != null) {
            if (iter.next == null) {
                System.out.printf("%d ", iter.val);
            } else {
                System.out.printf("%d -> ", iter.val);
            }
            iter = iter.next;
        }
    }

    //method to return a generic list given a size
    public ListNode makeList(int size){
        ListNode head = new ListNode(1);
        ListNode iter = head;
        int i = 2;
        while (size > 1) {
            iter.next = new ListNode(i++);
            iter = iter.next;
            size--;
        }
        return head;
    }
}
