import java.util.Stack;

public class validateStackSequence {
    /*
    Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result
    of a sequence of push and pop operations on an initially empty stack.

    Example 1:
    Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
    Output: true
    Explanation: We might do the following sequence:
    push(1), push(2), push(3), push(4), pop() -> 4,
    push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

    Example 2:
    Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
    Output: false
    Explanation: 1 cannot be popped before 2.

    Constraints:
        0 <= pushed.length == popped.length <= 1000
        0 <= pushed[i], popped[i] < 1000
        pushed is a permutation of popped.
        pushed and popped have distinct values.
     */
    //TC/S: O(n) and O(n) space since a stack is used
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //stack used to keep track of the values pushed
        Stack<Integer> stack = new Stack<>();
        //pointer to keep track of value to pop
        int i = 0;

        /*
            add all the values to in pushed to the stack and when the top of the stack equals popped[i], pop values and
            move to the next value in the popped, if i == popped.length, all the stack instructions were valid
         */
        for (int num : pushed) {
            stack.add(num);
            //check of the top value in stack == popped[i] and pop values while this holds true
            while (!stack.isEmpty() && i < popped.length && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return i == popped.length;
    }
}
