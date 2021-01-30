import java.util.PriorityQueue;

public class minimizeDeviationInArray {
    /*
    You are given an array nums of n positive integers.

    You can perform two types of operations on any element of the array any number of times:

    If the element is even, divide it by 2.
    For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
    If the element is odd, multiply it by 2.
    For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
    The deviation of the array is the maximum difference between any two elements in the array.

    Return the minimum deviation the array can have after performing some number of operations.

    Example 1:
    Input: nums = [1,2,3,4]
    Output: 1
    Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.

    Example 2:
    Input: nums = [4,1,5,20,3]
    Output: 3
    Explanation: You can transform the array after two operations to [4,2,5,5,3], then the deviation will be 5 - 2 = 3.

    Example 3:
    Input: nums = [2,10,8]
    Output: 3

    Constraints:
        n == nums.length
        2 <= n <= 10^5
        1 <= nums[i] <= 10^9
     */
    //TC:O(n log n * log M) where m is the highest value in the array and O(n) space due to PQ
    public int minimumDeviation(int[] nums) {
        //max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            //if the number is odd, multiply it by 2 so all values in the heap are even
            if (num % 2 != 0) {
                num *= 2;
            }
            //save the min, the max will be found using the heap
            if (num < min) {
                min = num;
            }
            heap.add(num);
        }

        //variable to hold the smallest difference between the max value and min value
        int diff = Integer.MAX_VALUE;

        //when the top of the heap is odd, all reductions have been exhausted
        while (heap.peek() % 2 == 0) {
            int max = heap.remove();

            //update the difference if the max - min is less than the current difference
            if (diff > max - min) {
                diff = max - min;
            }

            //if reducing the max is lower than the current min, update min
            if (max / 2 < min) {
                min = max / 2;
            }

            //add the odd value back to the heap
            heap.add(max / 2);

        }

        //return the smallest difference value diff or the top of the heap - min
        return Math.min(diff, heap.peek() - min);
    }
}
