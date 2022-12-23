package codingbat.array_1;

public class plusTwo {
    /*
    Given 2 int arrays, each length 2, return a new array length 4 containing all their elements.

    codingbat.array_1.plusTwo([1, 2], [3, 4]) → [1, 2, 3, 4]
    codingbat.array_1.plusTwo([4, 4], [2, 2]) → [4, 4, 2, 2]
    codingbat.array_1.plusTwo([9, 2], [3, 4]) → [9, 2, 3, 4]
     */
    public int[] plusTwo(int[] a, int[] b) {
        return new int[]{a[0], a[1], b[0], b[1]};
    }
}
