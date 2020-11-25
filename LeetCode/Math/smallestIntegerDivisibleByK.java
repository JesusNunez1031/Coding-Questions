public class smallestIntegerDivisibleByK {
    /*
    Given a positive integer K, you need to find the length of the smallest positive integer N such that N is divisible by K, and N only contains the digit 1.
    Return the length of N. If there is no such N, return -1.

    Note: N may not fit in a 64-bit signed integer.

    Example 1:
    Input: K = 1
    Output: 1
    Explanation: The smallest answer is N = 1, which has length 1.

    Example 2:
    Input: K = 2
    Output: -1
    Explanation: There is no such positive integer N divisible by 2.

    Example 3:
    Input: K = 3
    Output: 3
    Explanation: The smallest answer is N = 111, which has length 3.

    Constraints:
        1 <= K <= 10^5


     if K = 3
     Remainder can only be:
                                0   |   1   |   2

                                Number   |  1  |  11  |  111  |  1111  |  11111
                              Number % k |  1  |  2   |   0   |    1   |    2
                                          |___________________|
                                                     |
                                          remainders repeat K times

     if K = 6
     Remainder can only be:
                                0  |  1  |  2  |  3  |  4  |  5

                                Number   |  1  |  11  |  111  |  1111  |  11111  |  111111  |  1111111
                              Number % k |  1  |  5   |   3   |    1   |    5    |     3    |     1
                                          |_________________________________________________|
                                                                 |
                                                      remainders repeat K times

      So from this we can infer that if we don't see any remainder of 0 after K remainders, the value K will not have
      any value N that will yield remainder 0

      At every step, we calculate the next remainder by multiplying the previous remainder by 10 and adding 1 and taking the mod of K
                Ex:
                    if K = 6

                    the first remainder is (0 * 10 + 1) % K == 1
                    second remainder is (1 * 10 + 1) % K == 5
                    third remainder is (5 * 10) % K == 3
                                    .
                                    .
                                    .
  after calculating the remainder K times, if we saw no 0, we know there wont be any value N to give remainder 0

     */
    //TC: O(K) and constant space
    private static int smallestRepunitDivByK(int K) {
        //Any even value or multiple of 5 wont have any N
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        if (K == 1) {
            return 1;
        }
        int prev_remainder = 0;

        for (int N = 1; N <= K; N++) {
            prev_remainder = (prev_remainder * 10 + 1) % K;

            if (prev_remainder == 0) {
                return N;
            }
        }
        return -1;
    }
/**  The code below will not work since N has to be an int and even if it is a long, its value will overflow and give
 * the wrong solution
    public int smallestRepunitDivByK(int K) {
        if(K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        long N = 1;
        int count = 1;

        while(N % K != 0) {
            N = N * 10 + 1;
            count++;
        }
        return count;
    }
 **/

    public static void main(String[] args) {
        int K = 23;
        System.out.println(smallestRepunitDivByK(K));
    }
}
