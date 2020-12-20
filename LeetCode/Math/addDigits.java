public class addDigits {
    /*
    Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

    Example:
    Input: 38
    Output: 2
    Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
                 Since 2 has only one digit, return it.
    Follow up:
        Could you do it without any loop/recursion in O(1) runtime?
     */

    //Naive approach, add nums digits until its a single digit O(n) time and space due to recursive stack
    public int addDigits(int num) {
        int digital_root = 0;
        while(num != 0) {
            digital_root += num % 10;
            num /= 10;
        }
        //if the digital_root is <= 9, its a single digit so return it, otherwise, call the method with the digital_root
        return digital_root <= 9 ? digital_root : addDigits(digital_root);
    }

    /*
        The digital root of a number n base b comes down to the formula below

         digitalRoot(n) =  0 if n = 0
                           1 + (n - 1) mod b - 1 if n ≠ 0
         here since we want a single digit value, the base here is 10 since all digits are base 10
         More info: https://en.wikipedia.org/wiki/Digital_root
     */
    public int addDigitsM(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}
