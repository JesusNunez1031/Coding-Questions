public class reverseArray {
    static int[] reverseArray(int[] a) {

        int i = 0, j = a.length - 1;

        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            i++;
            j--;
        }
        return a;

    }
}
