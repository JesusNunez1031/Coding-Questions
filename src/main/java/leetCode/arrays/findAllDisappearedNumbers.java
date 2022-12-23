package leetCode.arrays;

import java.util.ArrayList;
import java.util.List;

public class findAllDisappearedNumbers {
    /*
    Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
    Find all the elements of [1, n] inclusive that do not appear in this array.
    Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

    Example:
    Input:
    [4,3,2,7,8,2,3,1]

    Output:
    [5,6]
     */

    //Using another array to find missing values
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] range = new int[nums.length + 1];

        for (int num : nums) {
            range[num]++;
        }

        for (int i = 1; i < range.length; i++) {
            if (range[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    //Method using O(1) space
    public List<Integer> findDisappearedNumbersS(int[] nums) {
        List<Integer> missing = new ArrayList<>();
        /*
           negate the value at the index of the value, so if nums[i] = 4, we negate nums[4-1] (-1 to avoid bound issues)
           we also avoid double negation by first taking the abs of a value in case its already been modified. The only values
           not negative are in the index of the missing value, so if 5 is missing, index 4 will be positive
        */
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = Math.abs(nums[index]) * -1;
        }

        //if a value is positive, we add its index + 1 since that is the missing value
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing.add(i + 1);
            }
        }
        return missing;
    }
}
