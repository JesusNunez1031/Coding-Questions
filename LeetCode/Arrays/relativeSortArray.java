public class relativeSortArray {
    /*
    Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
    Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that
    don't appear in arr2 should be placed at the end of arr1 in ascending order.

    Example 1:
    Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
    Output: [2,2,2,1,4,3,3,9,6,7,19]

    Constraints:
        1 <= arr1.length, arr2.length <= 1000
        0 <= arr1[i], arr2[i] <= 1000
        All the elements of arr2 are distinct.
        Each arr2[i] is in arr1.
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];

        for (int i : arr1) {
            freq[i]++;
        }

        int i = 0;
        int[] res = new int[arr1.length];

        for (int val : arr2) {
            while (freq[val]-- > 0) {
                res[i] = val;
                i++;
            }
        }

        for (int j = 0; j < freq.length; j++) {
            if (freq[j] > 1) {
                while (freq[j]-- > 0) {
                    res[i] = j;
                    i++;
                }
            } else if (freq[j] == 1) {
                res[i] = j;
                i++;
            }
        }
        return res;
    }
}
