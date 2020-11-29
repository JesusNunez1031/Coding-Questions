import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class slidingWindowMaximum {

    //Time limit exceeded method TC: O((n - k) * k) where n is the number of items and k is the window
    public int[] maxSlidingWindowEXE(int[] nums, int k) {
        int[] max = new int[nums.length - (k - 1)];

        //there is no window other than the value itself
        if (k == 1) {
            return nums;
        }

        //queue to store all the max values at the front and all other values at the end
        //Deque<Integer> deque = new LinkedList<>();
        int j = 0;

        for (int i = 0; i < nums.length - (k - 1); i++) {
            max[j++] = getMax(nums, i, i + k);
        }
        return max;
    }

    private int getMax(int[] nums, int start, int end) {
        //queue to store all the max values at the front and all other values at the end
        Deque<Integer> deque = new LinkedList<>();
        deque.add(nums[start]);

        for (int i = start + 1; i < end; i++) {
            if (deque.getFirst() < nums[i]) {
                deque.addFirst(nums[i]);
            }
        }
        return deque.getFirst();
    }

    //TC: O(n - k) where n is the number of items in nums and k is the window size
    public int[] maxSlidingWindow(int[] nums, int k) {
        //there are n - k + 1 windows so that is how many max values we will check for
        int[] max = new int[nums.length - k  + 1];

        //there is no window other than the value itself
        if (k == 1) {
            return nums;
        }

        /*
            deque to hold the indexes of the values we are processing. Indexes are used rather than
            values since they make tracking the window much easier
        */
        Deque<Integer> deque = new LinkedList<>();
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            //if the first index in the deque is no longer in the window we remove it from the deque so we can get new max
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.remove();
            }

            /*
                if the current value is greater than the last value in the deque, we need to remove all values
                starting from the back until we find one greater or equal to the current value
            */
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }

            //add the current index to the deque, adding the index makes keeping track of window easier
            deque.add(i);

            /*
                we know we've found a window when the index we are at is equal to greater than k - 1, k - 1 since index
                is 0 based, since we always add before we check the top of the deque, peek wont return null

                Since we always check if the last value is less than the current value, assuming all values
                currently in the deque are less than the current, the first value stored will be the largest

            */
            if (i >= k - 1) {
                max[j++] = nums[deque.peek()];
            }
        }
        return max;
    }
}