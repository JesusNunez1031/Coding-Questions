public class missingNumber {
    /*
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
    Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

    Example 1:
    Input: nums = [3,0,1]
    Output: 2
    Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

    Example 2:
    Input: nums = [0,1]
    Output: 2
    Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

    Example 3:
    Input: nums = [9,6,4,2,3,5,7,0,1]
    Output: 8
    Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

    Example 4:
    Input: nums = [0]
    Output: 1
    Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.

    Constraints:
        n == nums.length
        1 <= n <= 104
        0 <= nums[i] <= n
        All the numbers of nums are unique.
     */
    //O(n) TC and space
    public int missingNumber(int[] nums) {
        int[] freq = new int[nums.length + 1];

        for (int i : nums) {
            freq[i]++;
        }

        //if the frequency of an index is 0, we found the missing value
        for (int i = 0; i < nums.length; i++) {
            if (freq[i] == 0) {
                return i;
            }
        }
        //if we didn't find a 0, the missing value must n
        return nums.length;
    }

    //O(n) TC and O(1) space
    public static int missingNumberBit(int[] nums) {
        int missing = nums.length;

        for (int i = 0; i < nums.length; i++) {
            //since there is exactly one missing value and there are no duplicates, we use i and the value in nums[i] to ensure we get the missing number
            missing ^= i ^ nums[i];
        }

        return missing;
    }

    public int missingNumberBitEZ(int[] nums) {
        int xor = 0;

        //add every number that is supposed to be in the range
        for(int i = 0; i < nums.length + 1;i++) {
            xor ^= i;
        }

        //use xor to match every single value in nums, the all duplicates cancel each other leaving only the missing value
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    public int missingNumberFormula(int[] nums) {
        //use formula of the summation of all values to find the actual sum
        int actualSum = (nums.length *(nums.length + 1))/ 2;

        int sum = 0;
        //find the current sum if the values in nums
        for(int i : nums) {
            sum += i;
        }
        //subtracting the sum from the actual sum leaves the missing value as the remainder
        return actualSum - sum;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 4};
        System.out.println(missingNumberBit(arr));
    }
}
