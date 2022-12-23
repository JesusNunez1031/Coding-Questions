package codingbat.array_3;

public class seriesUp {

    /*
    Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n} (spaces added to show the grouping). Note that the length of the array will be 1 + 2 + 3 ... + n,
    which is known to sum to exactly n*(n + 1)/2.

    codingbat.array_3.seriesUp(3) → [1, 1, 2, 1, 2, 3]
    codingbat.array_3.seriesUp(4) → [1, 1, 2, 1, 2, 3, 1, 2, 3, 4]
    codingbat.array_3.seriesUp(2) → [1, 1, 2]
     */

    public int[] seriesUp(int n) {
        int size = n * (n + 1) / 2;
        int[] array = new int[size];
        int counter = 0;
        int limit = 1;

        for (int i = 0; i < size; i++) {
            array[i] = ++counter;
            if (counter == limit) {
                counter = 0;
                limit++;
            }
        }
        return array;
    }
}
