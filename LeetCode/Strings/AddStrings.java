public class AddStrings {
    /*
    Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

    You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You
    must also not convert the inputs to integers directly.

    Example 1:
    Input: num1 = "11", num2 = "123"
    Output: "134"

    Example 2:
    Input: num1 = "456", num2 = "77"
    Output: "533"

    Example 3:
    Input: num1 = "0", num2 = "0"
    Output: "0"

    Constraints:
        1 <= num1.length, num2.length <= 10^4
        num1 and num2 consist of only digits.
        num1 and num2 don't have any leading zeros except for the zero itself.
     */
    //TC: O(n)
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = 0;
            int n2 = 0;

            //only find what the value of the digit at i and j if the string still has digits
            if (i >= 0) {
                n1 = num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                n2 = num2.charAt(j) - '0';
                j--;
            }

            // sum up all digits including the carry if any
            int sum = (n1 + n2 + carry);
            // if the sum is any value above 10, the carry will be set
            carry = sum / 10;

            // only add the remainder digit from sum to the front of the result string
            sb.insert(0, sum % 10);
        }

        // return the sum result string
        return sb.toString();
    }
}
