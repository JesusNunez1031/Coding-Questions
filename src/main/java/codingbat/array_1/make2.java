package codingbat.array_1;

public class make2 {
    /*
    Given 2 int arrays, a and b, return a new array length 2 containing, as much as will fit, the elements from a followed by the elements from b. The arrays may be any length, including 0, but there will be 2 or more elements available between the 2 arrays.

    codingbat.array_1.make2([4, 5], [1, 2, 3]) → [4, 5]
    codingbat.array_1.make2([4], [1, 2, 3]) → [4, 1]
    codingbat.array_1.make2([], [1, 2]) → [1, 2]
     */
    public int[] make2(int[] a, int[] b) {
        int[] myArray = new int[2];
        int aLen = a.length;
        int bLen = b.length;

        if (aLen == 0) {
            myArray[0] = b[0];
            myArray[1] = b[1];
            return myArray;
        } else if (aLen == 1 && bLen == 1) {
            myArray[0] = a[0];
            myArray[1] = b[0];
            return myArray;
        } else if (aLen == 1) {
            myArray[0] = a[0];
            myArray[1] = b[0];
            return myArray;
        } else {
            myArray[0] = a[0];
            myArray[1] = a[1];
            return myArray;
        }
    }
}
