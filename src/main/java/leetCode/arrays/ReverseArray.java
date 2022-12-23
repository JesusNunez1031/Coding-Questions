package leetCode.arrays;

import java.util.Arrays;

public class ReverseArray {

    /*
        Given an array, reverse the values k steps

        Note: the array can be smaller than the value of k
     */

    public static int[] ReverseArrayNums(int[] nums, int k) {
        //Determine the number of times we move elements
        k = k % nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

        return nums;
    }

    private static int[] reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        ReverseArrayNums(arr, 3);

        System.out.println(Arrays.toString(arr));
    }
}
