package codingbat.array_2;

public class zeroFront {
    /*
    Return an array that contains the exact same numbers as the given array, but rearranged so that all the zeros are
    grouped at the start of the array. The order of the non-zero numbers does not matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}.
    You may modify and return the given array or make a new array.

    codingbat.array_2.zeroFront([1, 0, 0, 1]) → [0, 0, 1, 1]
    codingbat.array_2.zeroFront([0, 1, 1, 0, 1]) → [0, 0, 1, 1, 1]
    codingbat.array_2.zeroFront([1, 0]) → [0, 1]
     */
    public int[] zeroFront(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[count];
                nums[count] = 0;
                count++;
            }
        }
        return nums;
    }
}
