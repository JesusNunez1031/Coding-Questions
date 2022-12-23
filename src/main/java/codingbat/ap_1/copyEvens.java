package codingbat.ap_1;

public class copyEvens {
    /*
    Given an array of positive ints, return a new array of length "count" containing the first even numbers from the
    original array. The original array will contain at least "count" even numbers.

    codingbat.ap_1.copyEvens([3, 2, 4, 5, 8], 2) → [2, 4]
    codingbat.ap_1.copyEvens([3, 2, 4, 5, 8], 3) → [2, 4, 8]
    codingbat.ap_1.copyEvens([6, 1, 2, 4, 5, 8], 3) → [6, 2, 4]
     */
    public int[] copyEvens(int[] nums, int count) {
        int counter = 0, j = 0;
        int[] newArr = new int[count];
        for (int num : nums) {
            if (num % 2 == 0) {
                newArr[j] = num;
                counter++;
                j++;
            }
            if (counter == count) {
                break;
            }
        }
        return newArr;
    }
}
