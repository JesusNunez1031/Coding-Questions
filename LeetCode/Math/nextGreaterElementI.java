import java.util.HashMap;
import java.util.Map;

public class nextGreaterElementI {
    /*
    You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all
    the next greater numbers for nums1's elements in the corresponding places of nums2.

    The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not
    exist, output -1 for this number.

    Example 1:
    Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
    Output: [-1,3,-1]
    Explanation:
        For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
        For number 1 in the first array, the next greater number for it in the second array is 3.
        For number 2 in the first array, there is no next greater number for it in the second array, so output -1.

    Example 2:
    Input: nums1 = [2,4], nums2 = [1,2,3,4].
    Output: [3,-1]
    Explanation:
        For number 2 in the first array, the next greater number for it in the second array is 3.
        For number 4 in the first array, there is no next greater number for it in the second array, so output -1.

    Note:
        All elements in nums1 and nums2 are unique.
        The length of both nums1 and nums2 would not exceed 1000.
     */
    private int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //array to hold the indexes of the next greatest value in nums2 for every value in nums1
        int[] next = new int[nums1.length];

        Map<Integer, Integer> map = new HashMap<>();

        //add the values from nums2 and their indexes to the hashmap
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }


        for (int i = 0; i < nums1.length; i++) {
            boolean found = false;  //boolean variable used to check if nums2 has a next greatest for nums[i]
            /*
                to find the next greatest for nums[i], start from index of next[i] in nums2 and search right until a larger
                value to nums[i] is found, if a value was found, we set found to true
             */
            for (int j = map.get(nums1[i]); j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    next[i] = nums2[j];
                    found = true;
                    break;
                }
            }
            //if next greatest was not found, set the index for the current value to -1
            if (!found) {
                next[i] = -1;
            }
        }
        return next;
    }
}
