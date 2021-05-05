public class nonDecreasingArray {
    /*
    Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

    We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

    Example 1:
    Input: nums = [4,2,3]
    Output: true
    Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

    Example 2:
    Input: nums = [4,2,1]
    Output: false
    Explanation: You can't get a non-decreasing array by modify at most one element.

    Constraints:
        n == nums.length
        1 <= n <= 10^4
        -105 <= nums[i] <= 10^5
     */
    //TC: O(n)
    public boolean checkPossibility(int[] nums) {
        //pos holds the position of the only allowed decreasing sequence
        int pos = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            //if we detect a decreasing sequence, change the position to i
            if (nums[i] > nums[i + 1]) {
                //if this is the second sequence, return false since we are only allowed one modification
                if (pos != -1) {
                    return false;
                }
                pos = i;
            }
        }
        /*
            4 conditions to satisfy if nums only has one decreasing sequence
            1. nums[pos - 1] <= nums[pos + 1]
                if we can confirm that value before pos and after pos are increasing, we can modify pos to maintain a
                non-decreasing sequence

            2. nums[pos] <= nums[pos + 2]
                if the above condition does not satisfy, then we know the value at pos + 1 is the problem since till
                "pos" all values are increasing, hence we can modify the value at pos + 1 to a value in between pos and
                pos + 2 and maintain a non-decreasing sequence

            3. pos == 0
                the first decreasing sequence is found at the start, means we could modify it with some other value in
                the array without having to worry if its change affects previous values

            4. pos == nums.length - 2
                at this position we know condition 2 will overflow and all values previous to pos are in increasing
                order hence we can change this value to something greater than pos - 1 and the last value

            5. the final case is if no decreasing sequence were found, i.e. pos == -1
        */
        return pos == -1 || pos == 0 || pos == nums.length - 2 || nums[pos - 1] <= nums[pos + 1] || nums[pos] <= nums[pos + 2];
    }
}
