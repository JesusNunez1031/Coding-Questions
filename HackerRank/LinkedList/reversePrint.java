import java.util.Stack;

public class reversePrint {

    static void reversePrint(SinglyLinkedListNode head) {
        if (head == null) {
            System.out.println("");
        }
        SinglyLinkedListNode iter = head;
        Stack<Integer> stack = new Stack<>();

        while (iter != null) {
            stack.push(iter.data);

            iter = iter.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
