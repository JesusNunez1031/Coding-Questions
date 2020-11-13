public class medianOfTwoSortedArrays {
    /*
    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    Follow up: The overall run time complexity should be O(log (m+n)).

    Example 1:
    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.

    Example 2:
    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

    Example 3:
    Input: nums1 = [0,0], nums2 = [0,0]
    Output: 0.00000

    Example 4:
    Input: nums1 = [], nums2 = [1]
    Output: 1.00000

    Example 5:
    Input: nums1 = [2], nums2 = []
    Output: 2.00000

    Constraints:
        nums1.length == m
        nums2.length == n
        0 <= m <= 1000
        0 <= n <= 1000
        1 <= m + n <= 2000
        -106 <= nums1[i], nums2[i] <= 106
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        mergeArrays(nums1, nums2, merged);

        int mid = merged.length / 2;

        if (merged.length % 2 == 0) {
            return (merged[mid] + merged[mid - 1]) / 2.0;
        }

        return merged[mid];
    }

    public static void mergeArrays(int[] n1, int[] n2, int[] merge) {
        int i = 0, j = 0, k = 0;

        //traverse through both arrays
        while (i < n1.length && j < n2.length) {
            if (n1[i] < n2[j]) {
                merge[k++] = n1[i++];
            } else {
                merge[k++] = n2[j++];
            }
        }

        //if n1 is longer than n2, store remaining values
        while (i < n1.length) {
            merge[k++] = n1[i++];
        }
        //if n2 is longer than n1, store remaining values
        while (j < n2.length) {
            merge[k++] = n2[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {1};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
