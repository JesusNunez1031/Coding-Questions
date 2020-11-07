import java.util.Arrays;

public class PlusOne {
    /*
    Given a non-empty array of digits representing a non-negative integer, increment one to the integer.

    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

    You may assume the integer does not contain any leading zero, except the number 0 itself.
     */

    public static int[] plusOne(int[] digits) {
        //Length of digits
        int n = digits.length;
        //Start from the end of given array
        for (int i = n - 1; i >= 0; i--) {
            //if the last digit is not a 9, just add 1 and return new array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            //otherwise, make the current value a 0 since 9 is the upper bound
            digits[i] = 0;
        }
        int[] newNum = new int[n + 1];
        newNum[0] = 1;
        return newNum;
    }

    public static int[] plusOneEz(int[] digits) {
        int i = digits.length - 1;
        int carry = 1;

        while (i >= 0) {
            digits[i] = digits[i] + carry;

            if (digits[i] <= 9) {
                return digits;
            } else {
                digits[i] = 0;
            }
            i--;
        }

        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 9, 9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }
}
