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
    //StackNode holds the min value at the current node, the nodes integer value, and a reference to its next node
    static class StackNode {
        int min;
        int value;
        StackNode next;

        public StackNode(int value, int min) {
            this.value = value;
            this.min = min;
        }

        public StackNode(int value, int min, StackNode next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }

    //Head node, or top of the stack
    StackNode head;

    //Initialize an empty stack
    public minStack() {
        head = null;
    }

    //Adds a new node of value x to stack
    public void push(int x) {
        //if the stack is empty, make the top of the stack a new node x
        if (head == null) {
            head = new StackNode(x, x);
        } else {
            /*
                if the stack is not empty, make a new node of value x with a min value of the smallest value between x
                and the current min. The top of the stack becomes this new node and its next is the old top
             */
            head = new StackNode(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        //point the head to its next
        head = head.next;
    }

    public int top() {
        //return the head's value
        return head.value;
    }

    public int getMin() {
        //return the current min at the head
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

