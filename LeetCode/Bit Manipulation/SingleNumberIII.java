public class SingleNumberIII {
    /*
    Given an integer array nums, in which exactly two elements appear only once and all the other elements appear
    exactly twice. Find the two elements that appear only once. You can return the answer in any order.

    You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

    Example 1:
    Input: nums = [1,2,1,3,2,5]
    Output: [3,5]
    Explanation:  [5, 3] is also a valid answer.

    Example 2:
    Input: nums = [-1,0]
    Output: [-1,0]

    Example 3:
    Input: nums = [0,1]
    Output: [1,0]

    Constraints:
        2 <= nums.length <= 3 * 10^4
        -2^31 <= nums[i] <= 2^31 - 1
        Each integer in nums will appear twice, only two integers will appear once.
     */
    public int[] singleNumber(int[] nums) {
        if (nums.length == 2) {
            return nums;
        }
        int[] result = new int[2];

        /*
            xor all values in nums, so we get the value of the two single values, e.g. if 3 and 5 are the
            single digits, we would get 6 = 3^5
        */
        int xor = nums[0];

        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        /*
            get the lowest, i.e. rightmost, bit from the xor value as this will serve as the bit used to find the exact
            values that appear once, one of the values will include this bit, and the other won't. To do this we & xor
            value with the reverse of its bits
            Ex: 6 = 0110 | -6 = 1010
                0110 & 1010 = 0010
        */
        int bit = xor & -xor;

        /*
            iterate through all the values again and xor num with the first value if num had "bit", otherwise xor it
            with the other value if it did not. All other values in nums will cancel each other out and in the end,
            result[0] will have the number that had the "bit" and result[1] will have the number that did not
        */
        for (int num : nums) {
            if ((num & bit) > 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
