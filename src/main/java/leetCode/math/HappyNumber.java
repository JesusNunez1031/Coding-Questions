package leetCode.math;

public class HappyNumber {
    /*
    Write an algorithm to determine if a number n is happy.
    A happy number is a number defined by the following process:
        - Starting with any positive integer, replace the number by the sum of the squares of its digits.
        - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
        - Those numbers for which this process ends in 1 are happy.
        - Return true if n is a happy number, and false if not.

    Example 1:
    Input: n = 19
    Output: true
    Explanation:
    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1

    Example 2:
    Input: n = 2
    Output: false

    Constraints:
        1 <= n <= 2^31 - 1
     */
    //TC:O(n) and constant space used
    private boolean isHappy(int n) {
        while (true) {
            int sum = squareSum(n);

            //if the square sum of n is a single digit
            if (sum / 10 == 0) {
                /*
                    we check if the sum == 1 or 7 since taking the squares of 7 eventually converges to 1
                    Ex:
                                    7 -> 49
                            4^2 + 9^2 -> 97
                            9^2 + 7^2 -> 130
                        1^2 + 3^2 + 0 -> 10
                              1^2 + 0 -> 1
                    any other single digit value does not converge so we return false
                */
                return sum == 1 || sum == 7;
            }
            n = sum;    //reset n to the sum
        }
    }
    /*
        Using Floyd's cycle detection algorithm, we compute the square sum of n for a slow pointer and the square sum of the
        square sum of n for the fast pointer. If slow eventually is 1 or 7, we return true, otherwise, when a cycle is detected
        e.g. when slow catches up to fast, we break out of the loop since a cycle indicates all the solutions of slow
        don't generate a 1 or 7 hence an infinite loop, so we return false
        TC: O(n) and space
     */
    private boolean isHappyRec(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
            if(slow == 1 || slow == 7) {
                return true;
            }
        } while(slow != fast);

        return false;
    }

    private int squareSum(int n) {
        int sum = 0;
        while(n != 0) {
            int last_digit = n % 10;
            sum += last_digit * last_digit;
            n /= 10;
        }
        return sum;
    }
}
