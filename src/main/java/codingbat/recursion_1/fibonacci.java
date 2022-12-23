package codingbat.recursion_1;

public class fibonacci {
    /*
    The codingbat.recursion_1.fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition. The first two
    values in the sequence are 0 and 1 (essentially 2 base cases). Each subsequent value is the sum of the previous two
    values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. Define a recursive codingbat.recursion_1.fibonacci(n) method that
    returns the nth codingbat.recursion_1.fibonacci number, with n=0 representing the start of the sequence.

    codingbat.recursion_1.fibonacci(0) → 0
    codingbat.recursion_1.fibonacci(1) → 1
    codingbat.recursion_1.fibonacci(2) → 1
     */
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
