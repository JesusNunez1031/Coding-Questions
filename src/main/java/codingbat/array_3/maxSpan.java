package codingbat.array_3;

public class maxSpan {

    /*

    Consider the leftmost and rightmost appearances of some value in an array. We'll say that the "span" is the number of elements between the two inclusive. A single value has a span of 1.
    Returns the largest span found in the given array. (Efficiency is not a priority.)

    codingbat.array_3.maxSpan([1, 2, 1, 1, 3]) → 4
    codingbat.array_3.maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
    codingbat.array_3.maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
     */

    public int maxSpan(int[] nums) {
        if (nums.length > 0 && nums[0] != nums[nums.length - 1]) {
            return nums.length - 1;
        }
        return nums.length;
    }

}
