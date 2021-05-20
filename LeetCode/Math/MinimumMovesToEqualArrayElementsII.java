import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    /*
    Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
    In one move, you can increment or decrement an element of the array by 1.

    Example 1:
    Input: nums = [1,2,3]
    Output: 2
    Explanation:
    Only two moves are needed (remember each move increments or decrements one element):
    [1,2,3]  =>  [2,2,3]  =>  [2,2,2]

    Example 2:
    Input: nums = [1,10,2,9]
    Output: 16

    Constraints:
        n == nums.length
        1 <= nums.length <= 10^5
        -109 <= nums[i] <= 10^9
     */
    //TC: O(n log n)
    public int minMoves2(int[] nums) {
        int n = nums.length;
        /*
            sort the array so we can find the median, this is the value that we want to convert all other numbers to
            since it is the value that is the closest to all other values
         */
        Arrays.sort(nums);

        /*
            if the array is of even length, the median will be the average between the two middle values, otherwise its
            directly the middle value
         */
        int median = n % 2 == 0 ? (nums[n / 2] + nums[n / 2 - 1]) / 2 : nums[nums.length / 2];
        int steps = 0;

        for (int num : nums) {
            /*
                the number of changes to make is the difference between the median value and the current value, we take
                the absolute in case median is less than num, i.e. num has to be reduced
             */
            steps += Math.abs(median - num);
        }
        return steps;
    }

    //method 2, rather than find the median, build up to the median
    public int minMoves2M2(int[] nums) {
        int n = nums.length;
        //sort the array so we can find the median, this is the value that we want to convert all other numbers to since it is the value that is the closest to all other values
        Arrays.sort(nums);

        int i = 0, j = n - 1;
        int steps = 0;

        /*
            At every pair value of i and j, we try and make nums[i] and nums[j] equal by taking their absolute difference
            when i == j, the median value would have been reached and there is no more need to add steps since
            nums[i] == nums[j]
         */
        while (i < j) {
            steps += Math.abs(nums[i] - nums[j]);
            i++;
            j--;
        }
        return steps;
    }
}
