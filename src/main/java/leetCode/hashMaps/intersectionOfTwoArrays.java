package leetCode.hashMaps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class intersectionOfTwoArrays {
    /*
        Given two arrays, write a function to compute their intersection.
        Example 1:

        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2]
        Example 2:

        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [9,4]
        Note:

        Each element in the result must be unique.
        The result can be in any order.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        //Add all the values in nums1 into the set
        for (int i : nums1) {
            set.add(i);
        }

        //list to hold all the unique values found in both lists
        List<Integer> result = new ArrayList<>();

        //For every value in nums2 found in set, we add it to the result array
        for (int i : nums2) {
            if (set.remove(i)) {
                result.add(i);
            }
        }

        //Extract the unique values from array list into primitive array
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }
}
