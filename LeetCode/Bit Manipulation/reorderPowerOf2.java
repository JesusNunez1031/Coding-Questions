import java.util.Arrays;

public class reorderPowerOf2 {
    /*
    Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

    Return true if and only if we can do this in a way such that the resulting number is a power of 2.

    Example 1:
    Input: 1
    Output: true

    Example 2:
    Input: 10
    Output: false

    Example 3:
    Input: 16
    Output: true

    Example 4:
    Input: 24
    Output: false

    Example 5:
    Input: 46
    Output: true

    Note:
        1 <= N <= 10^9
     */
    //TC: O(log^2 n) and O(log n), There are log n different candidate powers of 2, and each comparison has O(log n) time complexity
    public boolean reorderedPowerOf2(int N) {
        int[] N_digits = getCount(N); //get the count of all digits in N

        /*
            since we want to check if N or its digits make up a power of 2's number, we calculate all the numbers of
            powers of 2 and compare the array made from each number to the array of N, if N digits can be rearranged into
            a power of 2's number, both arrays will match
         */
        int powTwo = 1; //power of two start value

        //32 bits in an int powers of 2 value
        for (int i = 0; i < 31; i++) {
            //check of the digits in N match a powers of 2 value array
            if (Arrays.equals(N_digits, getCount(powTwo))) {
                return true;
            }
            //shift 1 bit to the left to increase powTwo by power of 2
            powTwo <<= 1;
        }
        //N digits cant be rearranged into a powers of 2 digit
        return false;
    }

    //Method returns the count of all the digits found in number N as an array
    private int[] getCount(int N) {
        int[] nums = new int[10];

        while (N > 0) {
            nums[N % 10]++;
            N /= 10;
        }
        return nums;
    }
}
