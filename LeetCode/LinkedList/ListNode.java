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
}
