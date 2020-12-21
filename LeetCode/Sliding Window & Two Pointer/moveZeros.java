public class moveZeros {
    /*
        Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

        Example:
        Input: [0,1,0,3,12]
        Output: [1,3,12,0,0]

        Note:
            You must do this in-place without making a copy of the array.
            Minimize the total number of operations.
     */
    private void moveZeroes(int[] nums) {
        int zero = 0;   //index where there is a zero

        /*
            using two pointers, i and zero, for every value that is not a zero, we swap it with the index
            where there is a zero,
        */
        for (int i = 0; i < nums.length; i++) {
            //swap the index of the non-zero value with the index of a zero value
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                zero++;
            }
        }
    }
}
