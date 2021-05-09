import java.util.PriorityQueue;

public class constructTargetArrayWithMultipleSums {
    /*
    Given an array of integers target. From a starting array, A consisting of all 1's, you may perform the following
    procedure:
        - let x be the sum of all elements currently in your array.
        - choose index i, such that 0 <= i < target.size and set the value of A at index i to x.
        - You may repeat this procedure as many times as needed.

    Return True if it is possible to construct the target array from A otherwise return False.

    Example 1:
    Input: target = [9,3,5]
    Output: true
    Explanation: Start with [1, 1, 1]
    [1, 1, 1], sum = 3 choose index 1
    [1, 3, 1], sum = 5 choose index 2
    [1, 3, 5], sum = 9 choose index 0
    [9, 3, 5] Done

    Example 2:
    Input: target = [1,1,1,2]
    Output: false
    Explanation: Impossible to create target array from [1,1,1,1].

    Example 3:
    Input: target = [8,5]
    Output: true

    Constraints:
        N == target.length
        1 <= target.length <= 5 * 10^4
        1 <= target[i] <= 10^9
     */
    //TC/S: O(n long(max(target)) & O(log(max(target))
    public boolean isPossible(int[] target) {
        long sum = 0;
        int max = 0;

        /*
            get the sum of all values in the array and the index of the largest value in the array. The sum is used to
            get the value that will be used to update the index of the max value in the array
            Ex: given array [9, 3, 5]
            sum = 17
            max = target[0]
            diff = 17 - 9 = 8
            target[0] = 9 % 8 = 1
            ...repeat for the new array [1, 3, 5]
         */
        for (int i = 0; i < target.length; i++) {
            sum += target[i];
            if (target[i] > target[max]) {
                max = i;
            }
        }

        /*
            take the difference of the total sum of the array and the largest value in the array this is so we can later
            update the max index' value to the diff if we haven't yet turned all the array to 1's
        */
        long diff = sum - target[max];

        /*
            if the largest value is 1 then the array must be all 1's since 0's are not allowed. Also if the difference
            is 1, then the current max value would be updated to 1 hence the entire array is now all 1's
        */
        if (target[max] == 1 || diff == 1) {
            return true;
        }

        /*
            - if the diff > target[max] then target[max] will be updated to a negative hence breaking the condition
            - of all 1's so we return false.
            - if the diff is 0 then target[max] can no longer be 1 hence return false.
            - if the max value % diff == 0 then target[max] would be 0 hence we also return false

        */
        if (diff > target[max] || diff == 0 || target[max] % diff == 0) {
            return false;
        }

        //update target[max] to skip extra work, we take the mod of the max value rather than subtract
        target[max] %= diff;

        return isPossible(target);
    }

    //TC: O(n log n) since we are building a PQ and O(n) space
    public boolean isPossibleIter(int[] target) {
        long sum = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

        /*
            find the sum of all values in the array and add all the values to the maxHeap PQ. We use the PQ to process
            all the highest values and reduce them depending on what the sum is at every step. Once the top of the queue
            is 1, we know all values were able to be turned to 1. Negatives and 0's are not allowed into the queue hence
            if we ever make a 0 or negative after an update, we return false.
         */
        for (int num : target) {
            sum += num;
            maxHeap.offer(num);
        }

        while(maxHeap.peek() != 1) {
            //extract the top value in the PQ
            int max_value = maxHeap.remove();

            /*
              take the difference of the total sum of the array and the largest value in the array this is so we can later
              update the max index' value to the diff if we haven't yet turned all the array to 1's
            */
            long diff = sum - max_value;

            /*
                if the difference is 1, then the current max value would be updated to 1 hence the entire array is now
                all 1's
            */
            if(diff == 1) {
                return true;
            }

            /*
                - if the diff > max_value then max_value will be updated to a negative hence breaking the condition
                  of all 1's so we return false.
                - if the diff is 0 then max_value can no longer be 1 hence return false.
                - if the max value % diff == 0 then max_value would be 0 hence we also return false

            */
            if(diff > max_value || diff == 0 || max_value % diff == 0) {
                return false;
            }

            //update max_value to skip extra work, we take the mod of the max value rather than subtract
            max_value %= diff;

            //update the sum to the diff + the new max_value
            sum = diff + max_value;

            /*
                add max_value back to the queue, if its a 1 it'll be at the bottom of the queue, otherwise it'll be closer
                to the top for further processing
             */
            maxHeap.offer(max_value);
        }
        //all values in the queue are 1's i.e. target array can be turned to all 1's
        return true;
    }
}
