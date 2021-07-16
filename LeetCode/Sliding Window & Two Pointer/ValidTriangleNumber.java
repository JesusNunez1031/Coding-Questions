import java.util.Arrays;

public class ValidTriangleNumber {
    /*
    Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take
    them as side lengths of a triangle.

    Example 1:
    Input: nums = [2,2,3,4]
    Output: 3
    Explanation: Valid combinations are:
    2,3,4 (using the first 2)
    2,3,4 (using the second 2)
    2,2,3

    Example 2:
    Input: nums = [4,2,3,4]
    Output: 4

    Constraints:
        1 <= nums.length <= 1000
        0 <= nums[i] <= 1000
     */
    //TC:O(n^2)
    public int triangleNumber(int[] nums) {
        //a valid triangle needs at least 3 sides
        if (nums.length < 3) {
            return 0;
        }

        int valid_triangles = 0;

        //sort the array so all numbers are in ascending order
        Arrays.sort(nums);

        //start from the third value, the ith value will be value of one side of the triangle.
        for (int i = 2; i < nums.length; i++) {
            //check the sub-arrays of length 2 before ith value to see which values can be used to make a valid triangle
            int left = 0;
            int right = i - 1;
            while (left < right) {
                /*
                    A valid triangle is when two sides summed are greater than once side, so here when left + right > ith
                    value, a valid triangle was found
                 */
                if (nums[left] + nums[right] > nums[i]) {
                    /*
                        the entire window size is added to the total since if one combination of left and right satisfies
                        the condition, all values in between would also work since the values are sorted and all values
                        to the right of "left" would be greater meaning if left + right was > nums[i], then so will
                        (left + 1) + right, etc.
                     */
                    valid_triangles += (right - left);
                    right--; //reduce the window from the right since right was just used
                } else {
                    /*
                        if the sum of left and right was not greater than nums[i], a larger value is needed hence left
                        is increased
                     */
                    left++;
                }
            }
        }
        return valid_triangles;
    }
}
