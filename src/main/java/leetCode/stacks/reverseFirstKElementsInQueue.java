package leetCode.stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseFirstKElementsInQueue {
    /*
    Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, leaving the other elements in the same relative order.
    Only following standard operations are allowed on queue.

        enqueue(x) : Add an item x to rear of queue
        dequeue() : Remove an item from front of queue
        size() : Returns number of elements in queue.
        front() : Finds front item.

    Example 1:
    Input:
    5 3
    1 2 3 4 5

    Output:
    3 2 1 4 5

    Explanation:
    After reversing the given
    input from the 3rd position the resultant
    output will be 3 2 1 4 5.

    Example 2:
    Input:
    4 4
    4 3 2 1

    Output:
    1 2 3 4

    Explanation:
    After reversing the given
    input from the 4th position the resultant
    output will be 1 2 3 4.
     */
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> stack = new Stack<>();
        int size = q.size();

        while (k != 0) {
            stack.push(q.poll());
            k--;
        }
        if (k == size) {
            while (!stack.isEmpty()) {
                q.add(stack.pop());
            }
            return q;
        } else {
            Queue<Integer> ans = new LinkedList<>();
            while (size != 0) {
                if (!stack.isEmpty()) {
                    ans.add(stack.pop());
                } else {
                    ans.add(q.poll());
                }
                size--;
            }
            return ans;
        }
    }
}
