import java.util.Stack;

public class PalindromeLinkedList {


    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode slow = head, fast = head;

        //slow and fast pointers, by the time fast reaches the tail, slow will be at the center of list
        while (fast != null && fast.next != null) {
            //Fast traverses 2x as fast slow
            fast = fast.next.next;
            slow = slow.next;
        }

        //pass in the slow head to be reversed
        slow = reverseList(slow);
        fast = head;    //point head back to the front so we can use it to compare with slow

        //Check for equality from slow list and head of original list
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    //Method to reverse a list given the first node
    /*
        3 2 1   prev = null             |  next = 1
                next = 2;               |
                head.next = 3 null      |
                prev = 3                |
                head = 2                |
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    //Method using a Stack
    public boolean isPalindromeStack(ListNode head) {
        if(head == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();

        ListNode iter = head;

        while(iter != null) {
            stack.push(iter.val);
            iter = iter.next;
        }
        ListNode iter2 = head;
        while(iter2 != null && !stack.isEmpty()) {
            if(stack.pop() != iter2.val){
                return false;
            }
            iter2 = iter2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));

    }
}
