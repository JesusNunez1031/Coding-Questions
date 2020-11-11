public class centeredAverage {
    /*
    Return the "centered" average of an array of ints, which we'll say is the mean average of the values, except ignoring
    the largest and smallest values in the array. If there are multiple copies of the smallest value, ignore just one copy,
    and likewise for the largest value. Use int division to produce the final average. You may assume that the array is length 3 or more.

    centeredAverage([1, 2, 3, 4, 100]) → 3
    centeredAverage([1, 1, 5, 5, 10, 8, 7]) → 5
    centeredAverage([-10, -4, -2, -4, -2, 0]) → -3
     */
    public int centeredAverage(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        int sum = 0;
        for (int num : nums) {
            if (num > largest) {
                largest = num;
            }
            if (num < smallest) {
                smallest = num;
            }
            sum += num;
        }
        return (sum - smallest - largest) / (nums.length - 2);
    }
}
