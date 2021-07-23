public class PartitionArrayIntoDisjointIntervals {
    /*
    Given an array nums, partition it into two (contiguous) subarrays left and right so that:
        - Every element in left is less than or equal to every element in right.
        - left and right are non-empty.
        - left has the smallest possible size.
    Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.

    Example 1:
    Input: nums = [5,0,3,8,6]
    Output: 3
    Explanation: left = [5,0,3], right = [8,6]

    Example 2:
    Input: nums = [1,1,1,0,6,12]
    Output: 4
    Explanation: left = [1,1,1,0], right = [6,12]

    Note:
        2 <= nums.length <= 30000
        0 <= nums[i] <= 106
        It is guaranteed there is at least one way to partition nums as described.
     */
    //TC: O(n)
    public int partitionDisjoint(int[] nums) {
        int partitionPoint = 0;
        int maxInLeft = nums[0]; //largest element in the left partition
        int maxSoFar = nums[0]; // largest element seen so far

        for (int i = 1; i < nums.length; i++) {
            //update the max value if needed
            if (nums[i] > maxSoFar) {
                maxSoFar = nums[i];
            }
            /*
                if the current value is less than the largest value in the left partition, then the we need to add this
                value to the leftPartition since all values in the left must be less than right. We update the largest
                value in the left to the largest value seen so far so we ensure we keep track of the largest value in
                the left partition. Since nums[i] is now in the left, that means we had to have made a partition at i,
                hence partitionPoint = i
            */
            if (nums[i] < maxInLeft) {
                maxInLeft = maxSoFar;
                partitionPoint = i;
            }
        }
        //we cant make a partition before index 0 hence if a partition is done at 0, its after the index so +1
        return partitionPoint + 1;
    }

    //TC/SC: O(n)
    public int partitionDisjointSpc(int[] nums) {
        int n = nums.length;
        int[] maxLeft = new int[n]; // array of values to keep track of largest value seen up to ith index starting from the left
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            maxLeft[i] = max;
        }

        int[] minRight = new int[n]; // array of values to keep track of smallest value seen up to ith index starting from the right
        int min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(nums[i], min);
            minRight[i] = min;
        }

        /*
            start from 1 since there must be at least one partition, and search for the first instance where the largest
            value from the left is less than the smallest value from the right. At this index, the smallest value of the
            right partition is larger than the largest value from the left hence this is where all values from the left
            are smaller than right
        */
        for (int i = 1; i < n; i++) {
            if (maxLeft[i - 1] <= minRight[i]) {
                return i;
            }
        }
        //no partitions found
        return -1;
    }
}
