package codingbat.recursion_1;

public class factorial {
    /*
    Given n of 1 or more, return the codingbat.recursion_1.factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops).

    codingbat.recursion_1.factorial(1) → 1
    codingbat.recursion_1.factorial(2) → 2
    codingbat.recursion_1.factorial(3) → 6
     */
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
