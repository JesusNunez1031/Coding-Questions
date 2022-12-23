package codingbat.array_2;

public class withoutTen {
    /*
    Return a version of the given array where all the 10's have been removed. The remaining elements should shift left
    towards the start of the array as needed, and the empty spaces a the end of the array should be 0. So {1, 10, 10, 2} yields {1, 2, 0, 0}.
    You may modify and return the given array or make a new array.

    codingbat.array_2.withoutTen([1, 10, 10, 2]) → [1, 2, 0, 0]
    codingbat.array_2.withoutTen([10, 2, 10]) → [2, 0, 0]
    codingbat.array_2.withoutTen([1, 99, 10]) → [1, 99, 0]
     */
    public int[] withoutTen(int[] nums) {
        int[] newArr = new int[nums.length];
        int j = 0;
        for (int num : nums) {
            if (num != 10) {
                newArr[j] = num;
                j++;
            }
        }
        return newArr;
    }
}
