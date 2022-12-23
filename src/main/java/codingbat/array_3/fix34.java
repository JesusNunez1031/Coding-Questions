package codingbat.array_3;

import java.util.Arrays;

public class fix34 {

    /*
        Return an array that contains exactly the same numbers as the given array, but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, but every other number may move.
        The array contains the same number of 3's and 4's, every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.

        codingbat.array_3.fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
        codingbat.array_3.fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
        codingbat.array_3.fix34([3, 2, 2, 4]) → [3, 4, 2, 2]
         */

    public static int[] fix34(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (j < nums.length && nums[j] != 3) {
                j++;
            }
            if (j < nums.length && nums[i] == 4 && nums[j] == 3) {
                int temp = nums[j + 1];
                nums[j + 1] = 4;
                nums[i] = temp;
                j += i / 2;
            } else if (j < nums.length && nums[j] == 4 && nums[i] == 3) {
                int temp = nums[i + 1];
                nums[i + 1] = 4;
                nums[j] = temp;
                j = i;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 5, 4, 5, 4, 5, 4, 3, 5, 3, 5};

        System.out.println(Arrays.toString(fix34(arr)));
    }

}
