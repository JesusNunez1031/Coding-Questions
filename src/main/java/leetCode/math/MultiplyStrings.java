package leetCode.math;

public class MultiplyStrings {
    /*
    Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also
    represented as a string.

    Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

    Example 1:
    Input: num1 = "2", num2 = "3"
    Output: "6"

    Example 2:
    Input: num1 = "123", num2 = "456"
    Output: "56088"

    Constraints:
        1 <= num1.length, num2.length <= 200
        num1 and num2 consist of digits only.
        Both num1 and num2 do not contain any leading zero, except the number 0 itself.
     */
    //TC: O(n * m) where n is the length of num1 and m is the length of num2
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        if ("1".equals(num1)) {
            return num2;
        }

        if ("1".equals(num2)) {
            return num1;
        }

        // the length of the product will be the sum of the length of both numbers
        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                // calculate product of the two digits
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // add the previous carry to the current product
                product += result[i + j + 1];

                // place the carry from the product in the cell to the left from where the actual product belongs
                result[i + j + 1] = product % 10;

                // place the value in its place, += so any previous calculation is added on
                result[i + j] += product / 10;
            }
        }

        // extract the product from the array
        StringBuilder sb = new StringBuilder();

        for (int num : result) {
            // skip leading zeros
            if (sb.length() == 0 && num == 0) {
                continue;
            }
            sb.append(num);
        }
        return sb.toString();
    }
}
