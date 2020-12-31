public class BinaryAddition {
    /*
    Given two binary strings a and b, return their sum as a binary string.

    Example 1:
    Input: a = "11", b = "1"
    Output: "100"

    Example 2:
    Input: a = "1010", b = "1011"
    Output: "10101"

    Constraints:
        1 <= a.length, b.length <= 104
        a and b consist only of '0' or '1' characters.
        Each string does not contain leading zeros except for the zero itself.
     */

    //TC: O(n)
    private static String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            //Check to make sure we dont go out of bounds
            if (i >= 0)
                sum += a.charAt(i) - '0';
            if (j >= 0)
                sum += b.charAt(j) - '0';

            //If the the sum is 2, we need it to be odd since 2 does not exist in binary
            result.append(sum % 2);

            //if sum is 2, we get a carry of 1, in the case sum is 1, carry will be 0
            carry = sum / 2;

            //Decrement pointers
            i--;
            j--;
        }

        //If our program finished with a carry, we need to add it to the sum
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "10";
        String b = "1";

        System.out.println(addBinary(a, b));
    }
}
