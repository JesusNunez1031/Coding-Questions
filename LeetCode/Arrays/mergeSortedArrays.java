public class mergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //3 pointers, m is the last value in nums1 and n is the last value in nums2. Index is the last index in nums1
        m--;
        n--;
        int index = nums1.length - 1;

        while (index >= 0) {
            if (m < 0) {
                nums1[index] = nums2[n];
                n--;
            } else if (n < 0) {
                nums1[index] = nums1[m];
                m--;
            } else {
                //if the value in nums1 is greater than the value in nums2, we copy it over to the right so next time we come arround the lesser value will be placed in the left position, overriding the previous value
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
}
