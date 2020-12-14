public class findPeakElement {
    /*
    A peak element is an element that is greater than its neighbors.
    Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
    The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

    You may imagine that nums[-1] = nums[n] = -∞.

    Example 1:
    Input: nums = [1,2,3,1]
    Output: 2
    Explanation: 3 is a peak element and your function should return the index number 2.

    Example 2:
    Input: nums = [1,2,1,3,5,6,4]
    Output: 1 or 5
    Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
    Follow up: Your solution should be in logarithmic complexity.
     */

    //TC: O(log n) since we always split the array in half every time looking for the peak
    private static int findPeakElement(int[] nums) {
        //there is not peak in an array of length 1
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;

        //break when we find a peak value
        while (left < right) {
            int mid = left + (right - left) / 2;

            /*
                if the current value is less than its successor, we move left to mid + 1, otherwise we move right to mid
                since the value at mid is greater than its successor. We only move left if the value is less than the next
                so when left and right meet, we will have found a peak
             */

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid; //if the next value is less than nums[mid], we want to move right to mid since it meets a condition of a peak
            }
        }
        return left;    //left will have met with right and thus we return left since this it is at a peak
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(arr));
    }
}
