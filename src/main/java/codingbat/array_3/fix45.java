package codingbat.array_3;

public class fix45 {

    /*

    (This is a slightly harder version of the codingbat.array_3.fix34 problem.) Return an array that contains exactly the same numbers as the given array, but rearranged so that every 4 is immediately
    followed by a 5. Do not move the 4's, but every other number may move. The array contains the same number of 4's and 5's, and every 4 has a number after it that is not a 4. In this version,
    5's may appear anywhere in the original array.

    codingbat.array_3.fix45([5, 4, 9, 4, 9, 5]) → [9, 4, 5, 4, 5, 9]
    codingbat.array_3.fix45([1, 4, 1, 5]) → [1, 4, 5, 1]
    codingbat.array_3.fix45([1, 4, 1, 5, 5, 4, 1]) → [1, 4, 5, 1, 1, 4, 5]
     */

    public int[] fix45(int[] nums) {
        int[] otherValues = new int[nums.length];

        for (int i = 0, c = 0; i < nums.length; i++)
            if (nums[i] != 4 && nums[i] != 5)
                otherValues[c++] = nums[i];

        for (int i = 0, c = 0; i < nums.length; i++)
            if (nums[i] == 4)
                nums[++i] = 5;
            else
                nums[i] = otherValues[c++];

        return nums;
    }

}
