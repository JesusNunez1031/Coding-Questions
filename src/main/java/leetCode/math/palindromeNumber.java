package leetCode.math;

public class palindromeNumber {
    /*
    Given an integer x, return true if x is palindrome integer.
    An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

    Example 1:
    Input: x = 121
    Output: true

    Example 2:
    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

    Example 3:
    Input: x = 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

    Example 4:
    Input: x = -101
    Output: false

    Constraints:
        -2^31 <= x <= 2^31 - 1

    Follow up: Could you solve it without converting the integer to a string?
     */
    //TC: O(n) where n is the length of x
    public boolean isPalindrome(int x) {
        //all negative numbers are not considered as palindromes since the negative sign counts as a symbol, e.g. -121 != 121-
        if (x < 0) {
            return false;
        }

        //get the reversed number of x
        int reversed_x = reverse(x);

        //if the reversed number is -1, the reverse of x overflowed
        if (reversed_x == -1) {
            return false;
        }

        return reversed_x == x;
    }

    //method to reverse given value x
    private int reverse(int x) {
        long reversed = 0;  //use a long since x reversed can be out of the bounds of an int

        while (x != 0) {
            reversed = reversed * 10 + (x % 10);
            x /= 10;

            //if at any point the reversed value exceeds the range of an int, return -1
            if (reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) {
                return -1;
            }
        }
        //downcast so return value is int
        return (int) reversed;
    }

    //TC/S: O(n) since we store x into a string
    public static boolean isPalindromeEz(int x) {
        String numStr = String.valueOf(x);
        return getReverse(numStr).equals(numStr);
    }

    private static String getReverse(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
