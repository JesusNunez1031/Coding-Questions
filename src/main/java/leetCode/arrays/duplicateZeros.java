package leetCode.arrays;

public class duplicateZeros {
    /*
        Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
        Note that elements beyond the length of the original array are not written.
        Do the above modifications to the input array in place, do not return anything from your function.

        Example 1:

        Input: [1,0,2,3,0,4,5,0]
        Output: null
        Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
        Example 2:

        Input: [1,2,3]
        Output: null
        Explanation: After calling your function, the input array is modified to: [1,2,3]
     */
    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        //count the number of zeros in array
        for (int num : arr) {
            if (num == 0) {
                zeros++;
            }
        }
        //j is the length of the original array + all the additional zeros added
        int i = arr.length - 1, j = arr.length + zeros - 1;

        //We start from the end and the moment we can insert i into the index of j, we strat to shift values from left to right
        while (i != j) {
            insert(arr, i, j--);
            if (arr[i] == 0) {
                insert(arr, i, j--);
            }
            i--;
        }
    }

    public void insert(int[] arr, int i, int j) {
        if (j < arr.length) {
            arr[j] = arr[i];
        }
    }

}
