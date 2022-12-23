package leetCode.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveElement {

    public static int removeElementbet(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }
        int temp, j, shifts = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == val) {
                j = i;
                shifts++;
                while (nums[j] == val && j < nums.length-1) {
                    j++;
                    if(j == nums.length-shifts) {
                        shifts--;
                    }
                }
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums.length - shifts;
    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0)
            return 0;

        int j = 0;
        for(int i = 0; i < nums.length;i++) {
            if(nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
//        int[] arr = {0,1,2,2,3,0,4,2};
//        int value = removeElement(arr, 2);
//
//        System.out.println(Arrays.toString(arr) + "\n" + value );


    }
}
