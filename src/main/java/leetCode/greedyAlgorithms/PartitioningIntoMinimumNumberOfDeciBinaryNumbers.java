package leetCode.greedyAlgorithms;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    /*
    A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example,
    101 and 1100 are deci-binary, while 112 and 3001 are not.

    Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary
    numbers needed so that they sum up to n.

    Example 1:
    Input: n = "32"
    Output: 3
    Explanation: 10 + 11 + 11 = 32

    Example 2:
    Input: n = "82734"
    Output: 8

    Example 3:
    Input: n = "27346209830709182346"
    Output: 9

    Constraints:
        1 <= n.length <= 105
        n consists of only digits.
        n does not contain any leading zeros and represents a positive integer.
     */
    //TC: O(n)
    public int minPartitions(String n) {
        int max = 0;

        /*
            iterate through all the digits in n, the minimum number to sum up to n using deci-binary numbers will be 9 if
            it is included in the string n, this is due to the fact that it would take 9 steps to reduce 9 to all 0's. In
            the end the largest digit in n is returned since by the time the largest value is reduced to 0, all other
            values less than the largest would have already been eliminated, i.e. reduced to 0, hence we return the largest
            digit in n
         */
        for (int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i) - '0';
            if (digit > max) {
                max = digit;
            }
        }
        return max;
    }

    public int minPartitionsEz(String n) {

        /*
            start from the highest single digit possible, and search backwards, when a value is found return it since
            this is the minimum number of steps required to reduce all other values to 0
         */
        for (int i = 9; i >= 0; i--) {
            if (n.contains(String.valueOf(i))) {
                return i;
            }
        }
        return 0;
    }
}
