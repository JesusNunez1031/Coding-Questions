package leetCode.design;

import java.util.Arrays;

public class DesignCircularQueue {
    /*
    Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations
    are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position
    to make a circle. It is also called "Ring Buffer".

    One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal
    queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue.
    But using the circular queue, we can use the space to store new values.

    Implementation the MyCircularQueue class:
        - MyCircularQueue(k) Initializes the object with the size of the queue to be k.
        - int Front() Gets the front item from the queue. If the queue is empty, return -1.
        - int Rear() Gets the last item from the queue. If the queue is empty, return -1.
        - boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
        - boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
        - boolean isEmpty() Checks whether the circular queue is empty or not.
        - boolean isFull() Checks whether the circular queue is full or not.

    Example 1:
    Input
    ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
    [[3], [1], [2], [3], [4], [], [], [], [4], []]
    Output
    [null, true, true, true, false, 3, true, true, true, 4]

    Explanation
    MyCircularQueue myCircularQueue = new MyCircularQueue(3);
    myCircularQueue.enQueue(1); // return True
    myCircularQueue.enQueue(2); // return True
    myCircularQueue.enQueue(3); // return True
    myCircularQueue.enQueue(4); // return False
    myCircularQueue.Rear();     // return 3
    myCircularQueue.isFull();   // return True
    myCircularQueue.deQueue();  // return True
    myCircularQueue.enQueue(4); // return True
    myCircularQueue.Rear();     // return 4

    Constraints:
        1 <= k <= 1000
        0 <= value <= 1000
        At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.

    Follow up: Could you solve the problem without using the built-in queue?
     */
    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */


    //TC: O(1) and O(k) space
    int[] queue;
    int front = 0;
    int rear = 0;
    int size = 0;

    //initialize a new array queue of size k
    public DesignCircularQueue(int k) {
        queue = new int[k];
    }

    //adds a new value to the end of the queue and returns true if the addition was successful, false otherwise
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        /*
            when the queue is empty, the value to be inserted will be added to the first index, hence we make
            rear and front to 0 and add at rear, therefore, next time we add again, the new value will be added
            to rear + 1, and front will stay at 0, without this check the queue will lose track of the front and rear
         */
        if (isEmpty()) {
            front = rear = 0;
            queue[rear] = value;
            size++;
            return true;
        }

        //since its a circular queue, we add 1 to the rear and mod it with the length of the queue so indexes wrap around
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
        return true;
    }

    //removes the first value, front, of the queue and returns true if the removal was successful, false otherwise
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        queue[front] = 0; //set the current value to 0 to delete it
        //move front to the next index since an element has just been removed, its next index will be the new next
        front = (front + 1) % queue.length;
        size--;
        return true;
    }

    //returns the value at the front of the queue, i.e. first value
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    //returns the last value,i.e. value at the end, of the queue
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    //returns true if the queue is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    //returns true if the queue is at capacity, false otherwise
    public boolean isFull() {
        return size == queue.length;
    }

    //prints the queue
    public void print() {
        System.out.println(Arrays.toString(queue));
    }
}
