public class countingBits {
    /*
    Given an integer num, return an array of the number of 1's in the binary representation of every number in the range
    [0, num].

    Example 1:
    Input: num = 2
    Output: [0,1,1]
    Explanation:
    0 --> 0
    1 --> 1
    2 --> 10

    Example 2:
    Input: num = 5
    Output: [0,1,1,2,1,2]
    Explanation:
    0 --> 0
    1 --> 1
    2 --> 10
    3 --> 11
    4 --> 100
    5 --> 101

    Constraints:
        0 <= num <= 10^5
     */
    //TC: O(n) and O(1) space since the return array does not count as space used
    public int[] countBits(int num) {
        //the result array will also be used as a dp array to look up previous values for larger values
        int[] bit_count = new int[num + 1];
        bit_count[0] = 0; //0 has no 1 bits

        /*
            if we have a value y and x / 2 = y, then the number of set bits in x - number of set bits in y <= 1
            Ex:
                7 / 2 = 3
                x: 7 -> 111
                y: 3 -> 011
            using DP, number of bits in 7 will be 1 + dp[3], +1 because the LSB for odd number is always 1 and if we shift
            by 1 to the right, this bit is lost, so we add 1 to account for this lost bit.

            Ex:
                12 / 2 = 6
                x: 12 -> 1100
                y: 6  -> 0110
             for positive numbers, the LSB is never 1, so shifting by 1 does not loose a bit hence we can just look up
             dp[6] for bits in 12

            To get the number of 1 bits for a value we can check all 32 bits or simply recall the number of 1 bits from
            previous smaller values.
            Ex:
                0 - 0   5 - 2
                1 - 1   6 - 2
                2 - 1   7 - 3
                3 - 2   8 - 1
                4 - 1   9 - 2
           number of 1 bits in 1, an odd value, is 1 + (1/2), dp[0] = 0, so 1 + 0 = 1
           number of 1 bits in 2, an even value is 2/2, dp[1] = 1, so 1
           number of 1 bits in 3, odd, is 1 + 3 / 2, dp[1] = 1, so 1 + 1 = 2

           when we look at the binary representation of these values, its more clear,
           0 -> 0 [shifting bits in 0 is pointless]
           1 -> 01 [shifting by 1 to the right we get dp[0], then we +1 for the lost bit (LSB)]
           2 -> 10 [after shift by 1, we get dp[1] or 01, no 1 bits are lost here so no +1]
           3 -> 011 [after shift we get dp[1], again we loose a bit so we add 1]
           4 -> 100 [after shift, we get dp[2] or 10, no bits are lost]
         */

        for (int i = 1; i <= num; i++) {
            //if ith number is odd, the number of 1 bits in i is 1 + (i / 2)
            if (i % 2 != 0) {
                bit_count[i] = 1 + bit_count[i >> 1];
                //if ith number is even, the number of 1 bits is just i / 2
            } else {
                bit_count[i] = bit_count[i >> 1];
            }
        }
        return bit_count;
    }

    //TC: O(32n) since we check 32 bits n times
    public int[] countBitsEz(int num) {
        int[] bit_count = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            bit_count[i] = getBitCount(i);
        }
        return bit_count;
    }

    //checks all 32 bits of num and returns the count of 1 bits
    private int getBitCount(int num) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            //count will increase when a bit in num is 1
            count += num & 1;

            //shift bits of num by 1 to the right
            num >>= 1;
        }
        return count;
    }
}
