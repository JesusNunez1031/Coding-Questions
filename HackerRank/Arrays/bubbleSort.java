public class bubbleSort {
    /*
        Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm above. Once sorted,
        print the following three lines:

        1. Array is sorted in numSwaps swaps., where numSwaps is the number of swaps that took place.
        2. First Element: firstElement, where firstElement is the first element in the sorted array.
        3. Last Element: lastElement, where lastElement is the last element in the sorted array.
     */
    static void countSwaps(int[] a) {
        int swaps = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    swaps++;
                }
            }
        }

        System.out.printf("Array is sorted in %d swaps.\n", swaps);
        System.out.printf("First Element: %d\n", a[0]);
        System.out.printf("Last Element: %d\n", a[a.length - 1]);

    }
}
