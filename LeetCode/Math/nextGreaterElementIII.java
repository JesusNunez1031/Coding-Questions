public class nextGreaterElementIII {
    /*
    Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n
    and is greater in value than n. If no such positive integer exists, return -1.

    Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

    Example 1:
    Input: n = 12
    Output: 21

    Example 2:
    Input: n = 21
    Output: -1

    Constraints:
        1 <= n <= 2^31 - 1
     */
    private static int nextGreaterElement(int m) {
        long n = m; //cast the given value to a long in case the new value exceeds 2^31 (int)
        int[] digits = new int[10]; //array to hold the count of each digit in n

        //we save the remainders to check when we find a decreasing digit, this is the value that needs to be changed to make the next greatest value
        int current_remainder = -1;
        int prev_remainder = -1;

        while (n > 0) {
            current_remainder = (int) n % 10;
            n /= 10;
            digits[current_remainder]++;
            /*
                check if we found the decreasing integer, if found, we need to make a new number and we start by making
                the new number just greater than the current remainder, we find the actual number by checking the digits
                array for the value, if num exists in the array, then we reduce its count by 1 and make the new number
                all values in n + the num, otherwise we loop through digits until we find a digit in n previously seen
                that is greater than the current_remainder
             */
            if (prev_remainder > current_remainder) {
                int num = current_remainder + 1;
                while (digits[num] == 0) {
                    num++;
                }
                digits[num]--;
                n = n * 10 + num;

                /*
                    once we have the start of the new number, we loop through the digits array which holds the count of
                    all the numbers previously seen and add them to n in sorted order
                 */
                for (int i = 0; i < 10; i++) {
                    while (digits[i]-- > 0) {
                        n = n * 10 + i;
                    }
                }
                //check if the the new n does not exceed the range of int
                return n > Integer.MAX_VALUE ? -1 : (int) n;
            }
            //save the current remainder
            prev_remainder = current_remainder;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 1243322;

        System.out.println(nextGreaterElement(n));
    }
}
