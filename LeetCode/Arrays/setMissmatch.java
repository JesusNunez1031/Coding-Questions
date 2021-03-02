import java.util.HashSet;
import java.util.Set;

public class setMissmatch {
    /*
    You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error,
    one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and
    loss of another number.

    You are given an integer array nums representing the data status of this set after the error.

    Find the number that occurs twice and the number that is missing and return them in the form of an array.

    Example 1:
    Input: nums = [1,2,2,4]
    Output: [2,3]

    Example 2:
    Input: nums = [1,1]
    Output: [1,2]

    Constraints:
        2 <= nums.length <= 10^4
        1 <= nums[i] <= 10^4
     */
    //TC/S: O(n) and O(n) space used since a set is used
    public int[] findErrorNums(int[] nums) {
        int duplicate = 0;
        int missing = 1;
        Set<Integer> set = new HashSet<>();

        //look for the duplicate number
        for (int num : nums) {
            if (!set.add(num)) {
                duplicate = num;
            }
        }

        //range of values in the set are from 1 - n, so if the set does not contain ith value, the missing num is found
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return new int[]{duplicate, missing};
    }

    //TC/S: O(n) using a normal array with the frequency of 1 - n values in nums
    public int[] findErrorNumsEz(int[] nums) {
        int missing = 0;
        int duplicate = 0;
        int[] freq = new int[nums.length];

        //add the frequency of each value in nums into the freq array
        for (int num : nums) {
            freq[num - 1]++;    //-1 since array is 0 indexed
        }

        //look for the duplicate values and missing value
        for (int i = 1; i <= nums.length; i++) {
            //when the frequency of ith value is > 1, its the duplicate value
            if (freq[i - 1] > 1) {
                duplicate = i;
            }

            //a value with a frequency of 0 is the missing value
            if (freq[i - 1] == 0) {
                missing = i;
            }
        }
        return new int[]{duplicate, missing};
    }

    //TC: O(n) and O(1) space
    public int[] findErrorNumsEzz(int[] nums) {
        int missing = 0;
        int duplicate = 0;

        //negate the values in nums and when we encounter an already negative value, that's the duplicate
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                duplicate = Math.abs(num);
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }

        //look for the missing value by looking for the index that is not negative
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }
        return new int[]{duplicate, missing};
    }
}
