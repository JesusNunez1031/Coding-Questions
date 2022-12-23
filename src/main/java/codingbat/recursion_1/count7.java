package codingbat.recursion_1;

public class count7 {
    /*
    Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2.
    (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the
    rightmost digit (126 / 10 is 12).

    codingbat.recursion_1.count7(717) → 2
    codingbat.recursion_1.count7(7) → 1
    codingbat.recursion_1.count7(123) → 0
     */
    public int count7(int n) {
        if (n == 0) {
            return 0;
        }
        int counter = 0;

        if (n % 10 == 7)
            counter++;

        if (n / 10 == 0)
            return counter;

        return counter + count7(n / 10);
    }
}
