import java.util.*;

public class MaxFrequencyStack {
    /*
    Implement FreqStack, a class which simulates the operation of a stack-like data structure.
    FreqStack has two functions:
        - push(int x), which pushes an integer x onto the stack.
        - pop(), which removes and returns the most frequent element in the stack.
            - If there is a tie for most frequent element, the element closest to the top of the stack is removed and
              returned.


    Example 1:
    Input:
    ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
    [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
    Output: [null,null,null,null,null,null,null,5,7,5,4]
    Explanation:
    After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:

    pop() -> returns 5, as 5 is the most frequent.
    The stack becomes [5,7,5,7,4].

    pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
    The stack becomes [5,7,5,4].

    pop() -> returns 5.
    The stack becomes [5,7,4].

    pop() -> returns 4.
    The stack becomes [5,7].

    Note:
        Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
        It is guaranteed that FreqStack.pop() won't be called if the stack has zero elements.
        The total number of FreqStack.push calls will not exceed 10000 in a single test case.
        The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
        The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.
     */

    /**
     * Your FreqStack object will be instantiated and called as such:
     * FreqStack obj = new FreqStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     */
    //TC: O(1) for push and pop and O(n) space since we store values into hashmaps and stacks
    class FreqStack {
        //Frequency Map stores the frequency of all values
        Map<Integer, Integer> freqMap;

        //Frequency stack, keeps track of the max frequency of values and has a stack for all values of equal frequency
        Map<Integer, Stack<Integer>> freqStack;

        //keeps track of the current highest frequency seen
        int maxFreq;

        public FreqStack() {
            freqMap = new HashMap<>();
            freqStack = new HashMap<>();
            maxFreq = 0;
        }

        public void push(int x) {
            int freq = freqMap.getOrDefault(x, 0) + 1;
            //update the frequency of x in the map
            freqMap.put(x, freq);

            //update the maxFrequency
            maxFreq = Math.max(maxFreq, freq);

        /*
            add the value x to the stack that belongs to the current max frequency, if there exits a stack
            for "freq" then x is added to it, otherwise a new stack is made for "freq"
        */
            freqStack.computeIfAbsent(freq, f -> new Stack()).push(x);
        }

        public int pop() {
            //Remove the top of the maxFreq Stack
            Stack<Integer> stack = freqStack.get(maxFreq);
            int top = stack.pop();

            //if the stack for the current frequency is empty, reduce the max frequency so next time we pop from new stack
            if (stack.isEmpty()) {
                maxFreq--;
            }

            //update the frequency map
            freqMap.put(top, freqMap.get(top) - 1);

            //return the most frequent value of the current top value
            return top;
        }
    }

    class FreqStackList {

        //for each value pushed, updates and stores the freqeuency of it
        Map<Integer, Integer> freqMap;

        //creates a unique list for all values of equal frequency therfore when a values have equal frequencies, we return the most recent value
        List<List<Integer>> freqList;

        //the value for the most frequent value seen
        int maxFreq;

        public FreqStackList() {
            freqMap = new HashMap<>();
            freqList = new ArrayList<>();
            //add a list for frequency of 0
            freqList.add(new ArrayList<>());
            maxFreq = 0;
        }

        public void push(int x) {
            //get the frequency of x
            int x_freq = freqMap.getOrDefault(x, 0) + 1;

            //add the new value to the frequency map
            freqMap.put(x, x_freq);

            //update the current max frequency
            maxFreq = Math.max(maxFreq, x_freq);

            //add x to its respective list
            //add a new list if there is no list for the value of "x_freq"
            if (freqList.size() <= x_freq) {
                freqList.add(new ArrayList<>());
            }
            freqList.get(x_freq).add(x);
        }

        public int pop() {
            //get the list of the current maxFreq
            List<Integer> list = freqList.get(maxFreq);

            //save the top/most frequent value
            int top = list.remove(list.size() - 1);

            //check if the list is now empty, if it is, the max frequency is no longer "maxFreq", so decrement
            if (list.isEmpty()) {
                maxFreq--;
            }

            //update the frequency of the top value
            freqMap.put(top, freqMap.get(top) - 1);

            //return the value
            return top;
        }
    }
}
