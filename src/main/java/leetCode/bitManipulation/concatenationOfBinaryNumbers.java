package leetCode.bitManipulation;

public class concatenationOfBinaryNumbers {
    /*
    Given an integer n, return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order, modulo 109 + 7.

    Example 1:
    Input: n = 1
    Output: 1
    Explanation: "1" in binary corresponds to the decimal value 1.

    Example 2:
    Input: n = 3
    Output: 27
    Explanation: In binary, 1, 2, and 3 corresponds to "1", "10", and "11".
    After concatenating them, we have "11011", which corresponds to the decimal value 27.

    Example 3:
    Input: n = 12
    Output: 505379714
    Explanation: The concatenation results in "1101110010111011110001001101010111100".
    The decimal value of that is 118505380540.
    After modulo 10^9 + 7, the result is 505379714.

    Constraints:
    1 <= n <= 10^5
     */
    //TC: O(n)
    public static int concatenatedBinary(int n) {
        long res = 0;
        int mod = (int) 1e9 + 7;

        for (int i = 1; i <= n; i++) {
            //get the binary value of ith number
            String binary_ith = Integer.toBinaryString(i);
            //shift bits in the result by the length of ith number % 10^9 + 7
            res = (res << binary_ith.length() % mod);
            //add the ith number to the result
            res = (res + i) % mod;
        }
        //downcast from long
        return (int) res;
    }

    //Method without the conversation of the ith number to its binary form
    public static int concatenatedBinaryEz(int n) {
        long res = 0;
        int mod = (int)1e9 + 7;
        int size = 0;

        for(int i = 1; i <= n;i++) {
            //when i & i -1 == 0, we know we need to increase the size of the binary number by 1, e.g. going from 3 to 4
            if((i & (i - 1)) == 0) { //also checks if ith value is a power of 2, if it is, we increase the size, else we dont need to
                size++;
            }
            //shift result bits left by "size" and add ith value to it, take the mod, 10^9 + 7, we have a result in the range of int
            res = (res << size | i) % mod;
        }
        return (int)res;
    }

   // method to convert binary number to a decimal
     private static int binToDec(long binary) {
         int decimal = 0;
         int n = 0;

         while(binary != 0) {
             long rem = binary % 10;
             //add the rem, 1 or 0, * 2^nth power to the decimal
             decimal += rem * ((long) 1 << n);
             binary /= 10;
             n++; //increase power of n
         }
         return decimal;
     }

    public static void main(String[] args) {
//        int bin = 11110;
//        System.out.println(binToDec(bin));
        //0110
        System.out.println((6 << 2 | 3) % ((int)1e9 + 7));
        //System.out.println(concatenatedBinaryEz(3));
    }
}
