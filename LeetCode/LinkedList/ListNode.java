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

    /**
     * Method prints the list starting from the given {@code head}
     * @param head head of list
     */
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

    /**
     * Method returns the head of a list of length {@code size}, list starts from 1
     * @param size size of list
     * @return A list starting from 1 up the {@code size} length
     */
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
