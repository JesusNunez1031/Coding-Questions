import java.util.Arrays;

public class MaximumGap {
    /*
    Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If
    the array contains less than two elements, return 0.

    You must write an algorithm that runs in linear time and uses linear extra space.

    Example 1:
    Input: nums = [3,6,9,1]
    Output: 3
    Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.

    Example 2:
    Input: nums = [10]
    Output: 0
    Explanation: The array contains less than 2 elements, therefore return 0.

    Constraints:
        1 <= nums.length <= 10^4
        0 <= nums[i] <= 10^9
     */
    //TC: O(n)
    public int maximumGap(int[] nums) {
        //if there is only one or no values in nums, return 0 since there are no other numbers to find gap
        if (nums.length < 2) {
            return 0;
        }
        int maxGap = 0;
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //search for the largest and smallest value in the nums array
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        /*
            number of values in a bucket will be the difference between the largest and smallest value in nums
            divided by the number of values in nums
        */
        int bucketSize = (int) Math.ceil((double) (max - min) / (n - 1));

        //arrays for each bucket made, one array holds the min of the bucket, another holds the max
        int[] bucketMin = new int[n - 1];
        int[] bucketMax = new int[n - 1];

        //fill in max values in min array, and vice versa for the max array
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        //set the min and max of each bucket
        for (int num : nums) {
            //skip the min and max values
            if (num == min || num == max) {
                continue;
            }
            //using the current element, get the bucketIndex for the bucket to use
            int bucketIndex = (num - min) / bucketSize;

            //update the min and max of the bucket using the new value
            bucketMin[bucketIndex] = Math.min(num, bucketMin[bucketIndex]);
            bucketMax[bucketIndex] = Math.max(num, bucketMax[bucketIndex]);
        }

        //find the largest gap using the min
        for (int i = 0; i < n - 1; i++) {
            //skip any empty buckets
            if (bucketMax[i] != Integer.MIN_VALUE) {
                /*
                    the current max gap is the min value in bucket i subtracted from the min of the previous bucket, i.e. the max of the previous bucket
                */
                maxGap = Math.max(bucketMin[i] - min, maxGap);
                min = bucketMax[i]; // save the max of the current bucket to compare on next bucket
            }
        }

        //final check in case the array is of length 2
        maxGap = Math.max(maxGap, max - min);
        return maxGap;
    }
}
