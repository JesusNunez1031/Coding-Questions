package leetCode.greedyAlgorithms;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    /*
    Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer
    after removing k digits from num.

    Example 1:
    Input: num = "1432219", k = 3
    Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

    Example 2:
    Input: num = "10200", k = 1
    Output: "200"
    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

    Example 3:
    Input: num = "10", k = 2
    Output: "0"
    Explanation: Remove all the digits from the number, and it is left with nothing which is 0.

    Constraints:
        1 <= k <= num.length <= 105
        num consists of only digits.
        num does not have any leading zeros except for the zero itself.
     */
    //TC: O(n)
    public String removeKdigits(String num, int k) {
        char[] nums = num.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : nums) {
            // remove the most recent digit if the current digit is smaller | avoid strictly increasing sequence
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
                deque.removeLast();
                k--;
            }

            // avoid adding zeros when the deque is empty to prevent leading zeros
            if (deque.isEmpty() && c == '0') {
                continue;
            }
            deque.addLast(c);
        }

        // handle case where nums are all duplicates, i.e. 11111, so remove values until k = 0
        while (!deque.isEmpty() && k-- != 0) {
            deque.removeLast();
        }

        // return "0" if no values are left in the deque
        if (deque.isEmpty()) {
            return "0";
        }

        // generate resulting string
        StringBuilder sb = new StringBuilder();
        // deque starts from the front
        for (char c : deque) {
            sb.append(c);
        }
        return sb.toString();
    }
}
