public class findTheSmallestDivisorGivenThreshold {
    /*
    Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all
    the array by it and sum the result of the division. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
    Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

    It is guaranteed that there will be an answer.

    Example 1:
    Input: nums = [1,2,5,9], threshold = 6
    Output: 5
    Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
    If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).

    Example 2:
    Input: nums = [2,3,5,7,11], threshold = 11
    Output: 3

    Example 3:
    Input: nums = [19], threshold = 5
    Output: 4


    Constraints:
        1 <= nums.length <= 5 * 10^4
        1 <= nums[i] <= 10^6
        nums.length <= threshold <= 10^6
     */

    //TC: O(log(n^6) * n^4 we preform a binary search from 1 to 10^6 since that is the range of the each num in nums[i] and n^4 is the length of the array to calculate the sum
    public static int smallestDivisor(int[] nums, int threshold) {
        //1 <= nums[i] <= 10^6 so our upper bound is 1000000
        return binarySearchDivisor(nums, threshold, 1, (int)1e6);
    }

    public static int binarySearchDivisor(int[] nums, int threshold, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            /*if the sum of all values of the array with applied divisor is greater than the threshold, we need a larger
            divisor so we move left, otherwise we move down to find a smaller divisor
             */
            if (getSum(nums, mid) > threshold) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //left will end at the smallest divisor
        return left;
    }

    //helper method to get sum while applying a divisor to it
    public static long getSum(int[] nums, int divisor) {
        int sum = 0;
        for (int i : nums) {
            sum += (i - 1) / divisor + 1; //Math.ceil((double) i / divisor) does the same but takes more time
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        System.out.println(smallestDivisor(nums, threshold));
    }
}
