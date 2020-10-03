import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        //Pointers to the last values in arrays
        m--;
        n--;

        //Pointer to the last value in nums1 (array where we will be adding all values)
        int ptr = nums1.length - 1;

        while (ptr >= 0) {
            //Check for out of bounds on and n1 and n2
            if (m < 0) {
                nums1[ptr] = nums2[n];
                n--;
            } else if (n < 0) {
                nums1[ptr] = nums1[m];
                m--;
            } else {
                if (nums1[m] > nums2[n]) {
                    nums1[ptr] = nums1[m];
                    m--;
                } else {
                    nums1[ptr] = nums2[n];
                    n--;
                }
            }
            ptr--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 0, 0, 0, 0, 0};
        int[] arr2 = {2, 4, 7, 10, 12};

        merge(arr1, 4, arr2, 5);

        System.out.println(Arrays.toString(arr1));

    }
}
