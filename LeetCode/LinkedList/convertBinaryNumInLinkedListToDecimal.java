public class convertBinaryNumInLinkedListToDecimal {

    //Using a string and Integer class
    public int getDecimalValue(ListNode head) {
        if (head.next == null) {
            return head.val;
        }

        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(sb.toString(), 2);
    }

    //Using a mathematical approach
    public int getDecimalValueM(ListNode head) {
        if (head.next == null) {
            return head.val;
        }

        int result = 0;
        while (head != null) {
            result = (result * 2 + head.val);
            head = head.next;
        }

        return result;
    }
}
