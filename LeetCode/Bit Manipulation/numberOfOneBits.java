public class numberOfOneBits {
    /*
    Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

    Note:
    Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given
    as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
    In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above,
    the input represents the signed integer. -3.

    Follow up: If this function is called many times, how would you optimize it?

    Example 1:
    Input: n = 00000000000000000000000000001011
    Output: 3
    Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

    Example 2:
    Input: n = 00000000000000000000000010000000
    Output: 1
    Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.

    Example 3:
    Input: n = 11111111111111111111111111111101
    Output: 31
    Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.

    Constraints:
        The input must be a binary string of length 32

        Notes: ‘&’ : - is a Bitwise AND Operator. It produces a one (1) in the output if both the input bits are one.
        Otherwise it produces zero (0). This applies to any value 2 & 2 == 2, 3 & 3 == 3, 2 & 3 == 0..etc

        >> is arithmetic shift right, >>> is logical shift right, both shift bits right, however, >>> is unsigned.
        The unsigned right shift operator ">>>" shifts a zero into the leftmost position, while the leftmost position
        after ">>" depends on sign extension.
        Ex:
        >>> will always put a 0 in the left most bit, while >> will put a 1 or a 0 depending on what the sign of it is.
            01111111 >>> 2 = 00011111
            10000000 >>> 2 = 00100000

            01111111 >> 2 = 00011111
            10000000 >> 2 = 11100000

       using the >> shift, we can divide a number by a power of 2 keeping the sign of the original value
       Ex:
            100 >> 1 = 50   -> 100 / 2
            100 >> 2 = 25   -> 100 / 4
            100 >> 3 = 12   -> 100 / 8
            100 >> 4 = 6    -> 100 / 16
     */

    // you need to treat n as an unsigned value
    private static int hammingWeight(int n) {
        int bits = 0;

        while (n != 0) {
            /*
                check the LSB of n, if its is 1, then we add one to bits, otherwise bits remains unchanged
                    101010
                    ^    ^
                   MSB  LSB
             */
            System.out.println(Integer.toBinaryString(n));
            bits = (n & 1) == 1 ? bits + 1 : bits;

            //shift n by 1 bit to the right
            n >>>= 1;
        }
        return bits;
    }

    //Method using for-loop to go through all 32 bits
    private int hammingWeightEz(int n) {
        int bits = 0;

        for(int i = 0; i < 32; i++) {
            //if the LSB of n is 1, we increment bits
            if((n & 1) == 1) {
                bits++;
            }
            //shift n by 1 to the right
            n >>>= 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        //int n = 11111111111111111111111111111101;
        System.out.println(hammingWeight(n));
    }
}
