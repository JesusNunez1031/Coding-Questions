package codingbat.array_1;

public class front11 {
    /*
    Given 2 int arrays, a and b, of any length, return a new array with the first element of each array. If either array is length 0, ignore that array.

    codingbat.array_1.front11([1, 2, 3], [7, 9, 8]) → [1, 7]
    codingbat.array_1.front11([1], [2]) → [1, 2]
    codingbat.array_1.front11([1, 7], []) → [1]
     */
    public int[] front11(int[] a, int[] b) {
        int[] arr = new int[2];
        int[] one = new int[1];
        int alen = a.length;
        int blen = b.length;

        if (alen == 0 && blen == 0) {
            return a;
        }

        if (alen == 0) {
            one[0] = b[0];
            return one;
        }
        if (blen == 0) {
            one[0] = a[0];
            return one;
        }
        arr[0] = a[0];
        arr[1] = b[0];
        return arr;
    }
}
