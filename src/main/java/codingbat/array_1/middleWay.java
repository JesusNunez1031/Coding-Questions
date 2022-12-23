package codingbat.array_1;

public class middleWay {
    /*
        Given 2 int arrays, a and b, each length 3, return a new array length 2 containing their middle elements.

        codingbat.array_1.middleWay([1, 2, 3], [4, 5, 6]) → [2, 5]
        codingbat.array_1.middleWay([7, 7, 7], [3, 8, 0]) → [7, 8]
        codingbat.array_1.middleWay([5, 2, 9], [1, 4, 5]) → [2, 4]
     */
    public int[] middleWay(int[] a, int[] b) {
        int aF = a[1];
        int bF = b[1];

        return new int[]{aF, bF};
    }

}
