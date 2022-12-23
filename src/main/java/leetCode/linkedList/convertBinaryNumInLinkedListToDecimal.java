package leetCode.linkedList;

import java.util.ArrayList;
import java.util.List;

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

    public int getDecimalValueA(ListNode head) {
        List<Integer> nums = new ArrayList<>();

        //add the values in LL to an array
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        //traverse the array from the end and convert binary value to integer
        int j = 0, bin = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            bin += nums.get(i) * Math.pow(2, j++);
        }

        return bin;
    }
}
