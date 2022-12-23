package codingbat.array_2;

public class sum67 {
    /*
    Return the sum of the numbers in the array, except ignore sections of numbers starting with a 6 and extending to
    the next 7 (every 6 will be followed by at least one 7). Return 0 for no numbers.

    codingbat.array_2.sum67([1, 2, 2]) → 5
    codingbat.array_2.sum67([1, 2, 2, 6, 99, 99, 7]) → 5
    codingbat.array_2.sum67([1, 1, 6, 7, 2]) → 4
     */
    public int sum67(int[] nums) {
        int sum = 0;
        boolean inRange = false;

        for (int num : nums) {
            if (num == 6) {
                inRange = true;
            }
            if (!inRange) {
                sum += num;
            }
            if (inRange && num == 7) {
                inRange = false;
            }
        }
        return sum;
    }
}
