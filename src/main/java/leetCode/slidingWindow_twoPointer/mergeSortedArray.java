package leetCode.slidingWindow_twoPointer;

public class mergeSortedArray {
    /*
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has enough
    space (size that is equal to m + n) to hold additional elements from nums2.

    Example 1:
    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]

    Example 2:
    Input: nums1 = [1], m = 1, nums2 = [], n = 0
    Output: [1]

    Constraints:
        0 <= n, m <= 200
        1 <= n + m <= 200
        nums1.length == m + n
        nums2.length == n
        -109 <= nums1[i], nums2[i] <= 10^9
     */
    //TC: O(k) where k is sum of n + m
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        //3 pointers, m is the last value in nums1 and n is the last value in nums2. Index is the last index in nums1
        m--;
        n--;
        int index = nums1.length - 1;

        while (index >= 0) {
            //check bounds for nums1 and nums2
            if (m < 0) {
                nums1[index] = nums2[n];
                n--;
            } else if (n < 0) {
                nums1[index] = nums1[m];
                m--;
            } else {
                //if the value in nums1 is greater than the value in nums2, we copy it over to the right so next time
                // we come around the lesser value will be placed in the left position, overriding the previous value
                if (nums1[m] > nums2[n]) {
                    nums1[index] = nums1[m];
                    m--;
                    //otherwise, we copy over the value from nums2 into nums1
                } else {
                    nums1[index] = nums2[n];
                    n--;
                }
            }
            index--;
        }
    }
    private void mergeEZ(int[] nums1, int m, int[] nums2, int n) {
        /*
            3 pointers to keep track of values to add, p1 points to the last real value in nums1,
            p2 points to the last value in nums2, and i points to the last index in nums1. We compare
            values at nums1[p1] to nums2[p2] and the greater one is added to nums1[i].
        */
        int p1 = m - 1;     //ptr to nums1
        int p2 = n - 1;     //ptr to nums2
        int i = nums1.length - 1;

        //while nums2 still has values we do operations
        while(p2 >= 0) {
            //if p1 ptr has not yet reached -1, and nums1 is greater, we set nums1[i] to nums1[p1]
            if(p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--];
            } else {
                //if nums2 is greater or nums1 has traversed e.g. p1 = -1, set nums1[i] to nums2
                nums1[i--] = nums2[p2--];
            }
        }
    }
}
