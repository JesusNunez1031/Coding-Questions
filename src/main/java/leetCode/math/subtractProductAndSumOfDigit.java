package leetCode.math;

public class subtractProductAndSumOfDigit {

    /*
        Given an integer number n, return the difference between the product of its digits and the sum of its digits.

        Example 1:
        Input: n = 234
        Output: 15
        Explanation:
        Product of digits = 2 * 3 * 4 = 24
        Sum of digits = 2 + 3 + 4 = 9
        Result = 24 - 9 = 15

        Example 2:
        Input: n = 4421
        Output: 21
        Explanation:
        Product of digits = 4 * 4 * 2 * 1 = 32
        Sum of digits = 4 + 4 + 2 + 1 = 11
        Result = 32 - 11 = 21
     */

    //Using recursion, O(n) time and space
    public int subtractProductAndSum(int n) {
        return prodSum(n) - calcSum(n);
    }

    public int prodSum(int n) {
        int prod = 1;

        while (n != 0) {
            prod *= n % 10;
            n /= 10;
        }
        return prod;
    }

    public int calcSum(int n) {
        if (n == 0) {
            return n;
        }
        return n % 10 + calcSum(n / 10);
    }

    //Using just one method O(n) time and O(1) space
    public int subtractProdAndSum(int n) {
        int sum = 0;
        int product = 1;

        while (n != 0) {
            int val = n % 10;
            product *= val;
            sum += val;
            n /= 10;
        }
        return product - sum;
    }
}
