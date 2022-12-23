package leetCode.bitManipulation;

public class hammingDistance {
    /*
    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
    Given two integers x and y, calculate the Hamming distance.

    Note:
    0 ≤ x, y < 231.

    Example:
    Input: x = 1, y = 4

    Output: 2
    Explanation:
    1   (0 0 0 1)
    4   (0 1 0 0)
           ↑   ↑

    The above arrows point to positions where the corresponding bits are different.
     */
    public int hammingDistance(int x, int y) {
        int count = 0;

        //loop through all the 32 bits in x and y and compare their LSB
        for (int i = 0; i < 32; i++) {
            //if the LSB of x and y are not equal, we increment count
            if ((x & 1) != (y & 1)) {
                count++;
            }

            //shift the bits in x and y to the right by 1; use >> and not >>> to preserve sign
            x >>= 1;
            y >>= 1;
        }
        return count;
    }
}
