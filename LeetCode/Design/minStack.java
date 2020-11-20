public class minStack {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    /*
        Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

        push(x) -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() -- Get the top element.
        getMin() -- Retrieve the minimum element in the stack.
     */
    private static class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public void push(int x) {
        if (head == null)
            //Adding for the first time, min is the current value
            head = new Node(x, x);
        else
            //min is the lowest value btw the new value and the min prior
            head = new Node(x, Math.min(x, head.min), head);
    }

    //Move head one step forward
    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

}

/*------------------------------------------------------------------------------------------------------------------------------------*/
//implementation using a primitive array
class MinStack {
    private int[] stackArray;
    private int[] minArray;
    private int topStack = -1;
    private int topMin = -1;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stackArray = new int[10000];
        this.minArray = new int[stackArray.length];
    }

    public boolean minIsEmpty() {
        return topMin == -1;
    }

    public void push(int x) {
        topStack++;
        stackArray[topStack] = x;

        if (minIsEmpty()) {
            topMin++;
            minArray[topMin] = x;
        } else if (x <= minArray[topMin]) {
            topMin++;
            minArray[topMin] = x;
        }
    }

    public void pop() {
        int removed = stackArray[topStack];
        stackArray[topStack] = 0;
        topStack--;

        if (removed == minArray[topMin]) {
            minArray[topMin] = 0;
            topMin--;
        }
    }

    public int top() {
        if (stackArray.length == 0) {
            return 0;
        }
        return stackArray[topStack];
    }

    public int getMin() {
        if (minIsEmpty()) {
            return 0;
        }
        return minArray[topMin];
    }
}

