public class addTwoNumbers {

    /*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself

    Ex:
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
     */

    //Method runs in O(n + m) time where n is the length of l1 and m is the length of l2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode l3 = result;

        int carry = 0;

        while (l1 != null || l2 != null) {
            //If one list is longer than the other, just add a 0 to not get a null pointer
            int l1_val = l1 != null ? l1.val : 0;
            int l2_val = l2 != null ? l2.val : 0;

            int current_sum = l1_val + l2_val + carry;

            //current_sum / 10 gets us a one or a zero if the sum is only one digit
            carry = current_sum / 10;

            //current_sum % 10 gets us the last digit
            ListNode new_node = new ListNode(current_sum % 10);
            l3.next = new_node;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        if (carry > 0) {
            l3.next = new ListNode(carry);
        }

        //We return .next since we initialized the first node as 0;
        return result.next;
    }
}
