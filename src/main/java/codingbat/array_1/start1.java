package codingbat.array_1;

public class start1 {
    /*
        Start with 2 int arrays, a and b, of any length. Return how many of the arrays have 1 as their first element.

        codingbat.array_1.start1([1, 2, 3], [1, 3]) → 2
        codingbat.array_1.start1([7, 2, 3], [1]) → 1
        codingbat.array_1.start1([1, 2], []) → 1
     */
    public int checkOne(int[] a) {
        if (a[0] == 1) {
            return 1;
        }
        return 0;
    }

    public int start1(int[] a, int[] b) {
        if (a.length < 1 && b.length < 1) {
            return 0;
        }
        if (a.length < 1 && !(b.length < 1)) {
            return checkOne(b);
        }
        if (!(a.length < 1) && b.length < 1) {
            return checkOne(a);
        }
        return checkOne(a) + checkOne(b);
    }
}
