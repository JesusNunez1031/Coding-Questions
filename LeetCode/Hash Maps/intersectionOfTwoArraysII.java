import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intersectionOfTwoArraysII {
    /*
        Given two arrays, write a function to compute their intersection.

        Example 1:
        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2,2]

        Example 2:
        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [4,9]

        Note:
        Each element in the result should appear as many times as it shows in both arrays.
        The result can be in any order.

        Follow up:
        What if the given array is already sorted? How would you optimize your algorithm?
        What if nums1's size is small compared to nums2's size? Which algorithm is better?
        What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        //Two pointer approach, if value at i is < value at j, increase nums1 pointer, and vise versa
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return res.stream().mapToInt(k -> k).toArray();
    }

    //Another method using a primitive array
    public int[] intersect2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        int[] res = new int[Math.min(len1, len2)];

        while (i < len1 && j < len2) {
            //if the number at nums1 is less than the number at nums2, move nums1 pointer forward
            if (nums1[i] < nums2[j]) {
                i++;
            //if the value at nums1 is greater than the one in nums2, move nums2 pointer forward
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                //otherwise they are equal so add the value to the intersection array
                res[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(res, 0, k);
    }
}
