package leetCode.stacks;

import java.util.Stack;

public class removeAllAdjacentDuplicatesInStringII {
    /*
    You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters
    from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

    We repeatedly make k duplicate removals on s until we no longer can.

    Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

    Example 1:
    Input: s = "abcd", k = 2
    Output: "abcd"
    Explanation: There's nothing to delete.

    Example 2:
    Input: s = "deeedbbcccbdaa", k = 3
    Output: "aa"
    Explanation:
    First delete "eee" and "ccc", get "ddbbbdaa"
    Then delete "bbb", get "dddaa"
    Finally delete "ddd", get "aa"

    Example 3:
    Input: s = "pbbcggttciiippooaais", k = 2
    Output: "ps"

    Constraints:
        1 <= s.length <= 105
        2 <= k <= 104
        s only contains lower case English letters.
     */
    //TC: O(n)
    public String removeDuplicates(String s, int k) {
        //stack hold an array for each character encountered, e.g. character [0] = (int) a, [1] = count
        Stack<int[]> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            /*
                if the top of the stack matches the current character c, increase the count of the character, otherwise
                add the new character with count of 1
             */
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;
            } else {
                stack.push(new int[]{c, 1});
            }

            //when the top character has a count of k, remove it
            if (stack.peek()[1] == k) {
                stack.pop();
            }
        }

        /*
            add the remaining characters to a string and return its reverse since their order, being in a stack, will be
            in reverse
         */
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            int[] c = stack.pop();

            //each character has a count, append c while its count is not 0
            while (c[1]-- > 0) {
                sb.append((char) c[0]);
            }
        }
        return sb.reverse().toString();
    }

    /*
    public String removeDuplicatesez(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> counters = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                sb.append(c);
                count++;
            } else if (stack.peek() != c) {
                stack.push(c);
                sb.append(c);
                counters.push(count);
                count = 1;
            } else if (stack.peek() == c && count == k - 1) {
                while (!stack.isEmpty() && count > 0) {
                    stack.pop();
                    sb.setLength(sb.length() - 1);
                    count--;
                }
                if (!counters.isEmpty()) {
                    count = counters.pop();
                } else {
                    count = 0;
                }
            }
        }
        return sb.toString();
    }
     */
}
