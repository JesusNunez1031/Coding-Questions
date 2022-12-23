package leetCode.hashMaps;

import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
    /*
        Given an array of integers, find if the array contains any duplicates.
        Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
        Example 1:

        Input: [1,2,3,1]
        Output: true
     */
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();

        for(int i : nums) {
            if(!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}
