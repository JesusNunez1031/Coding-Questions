import java.util.PriorityQueue;

public class JumpGameVI {
    /*
    You are given a 0-indexed integer array nums and an integer k.

    You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the
    boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)]
    inclusive.

    You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j
    you visited in the array.

    Return the maximum score you can get.

    Example 1:
    Input: nums = [1,-1,-2,4,-7,3], k = 2
    Output: 7
    Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.

    Example 2:
    Input: nums = [10,-5,-2,4,0,3], k = 3
    Output: 17
    Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.

    Example 3:
    Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
    Output: 0

    Constraints:
         1 <= nums.length, k <= 10^5
        -10^4 <= nums[i] <= 10^4
     */
    //TC: O(n log k) where n is the number of values in nums and k is the jump distance
    public int maxResult(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        //Queue holds a running sum of all jumps and the index at which the sum is reached
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        //add the start to the heap
        heap.add(new int[]{nums[0], 0});

        //max holds the largest sums from jumps
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            /*
                get rid of any jumps that cant be continued from the current ith position, they are those whose index
                subtracted from i is greater than k, i.e. entries that are farther than k distance away
             */
            while (!(i - heap.peek()[1] <= k)) {
                heap.remove();
            }

            int[] top = heap.peek();
            //add the highest jump value to the max and add this jump to the heap
            max = top[0] + nums[i];
            heap.add(new int[]{max, i});

        }
        return max;
    }

    public static int maxResultEz(int[] nums, int k) {
        int n = nums.length;

        //front of deque f, end of deque e
        int f = 0, e = 0;

        //for better efficiency, deque behavior is replicated using an array
        int[] deque = new int[n];

        /*
            start from the second index in nums, f is the index in nums from where we would land after a jump from
            ith index, e.g.
            if nums = [1,-1,-2,4,-7,3] | f starts as index 0
            - nums[1] and nums[2] can both be reached from nums[f] so we add nums[deque[f]] to these index making the
              array [1, 0, -1, 4, -7, 3]
            - we add the index we are at to the end of the deque at every step, deque = [0, 1, 2, 0, 0]
            - once nums[3] is reached, we no longer can reach this index from deque[f], hence we move f by 1 to be in
              jump range once again

              we repeat these steps and at the end, nums[n - 1] should hold the largest sum from all jumps we made starting
              from the end.

            - in the case where entries from the end are less than the sum of jumps at the current index nums[i], we
              remove the reference from the end by reducing the end index in the deque
         */
        for (int i = 1; i < n; i++) {
            //move to the next front entry if they are outside the jump window
            if (!(i - deque[f] <= k)) {
                f++;
            }

            //if the index deque[f] is not out of the jump window, we can jump to this index hence we add its value to nums[i]
            nums[i] += nums[deque[f]];

            //remove entries from the end that are less than the current max jump sum nums[i] since this is the largest sum thus far
            while (e >= f && nums[deque[e]] <= nums[i]) {
                e--;
            }
            //add the new index to the end
            deque[++e] = i;
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, -2, 4, -7, 3};
        int k = 2;

        maxResultEz(nums, k);
    }
}
