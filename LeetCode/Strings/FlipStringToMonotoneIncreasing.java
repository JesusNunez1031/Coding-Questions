public class FlipStringToMonotoneIncreasing {
    /*
    A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number
    of 1's (also possibly none).

    You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

    Return the minimum number of flips to make s monotone increasing.

    Example 1:
    Input: s = "00110"
    Output: 1
    Explanation: We flip the last digit to get 00111.

    Example 2:
    Input: s = "010110"
    Output: 2
    Explanation: We flip to get 011111, or alternatively 000111.

    Example 3:
    Input: s = "00011000"
    Output: 2
    Explanation: We flip to get 00000000.

    Constraints:
        1 <= s.length <= 10^5
        s[i] is either '0' or '1'.
     */
    //TC: O(n)
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int i = 0;

        //skip all leading zeros
        while (i < n && s.charAt(i) == '0') {
            i++;
        }

        //return 0 if s is already monotone increasing
        if (i == n) {
            return 0;
        }

        int flips = 0; // 0 -> 1
        int ones = 0; // number of one's in s

        while (i < n) {
            char c = s.charAt(i);

            // Add to the number of flips needed when c == 0, otherwise increase the count of 1's seen
            if (c == '0') {
                flips++;
            } else {
                ones++;
            }

            /*
                if the number of flips needed is larger than the number of ones, then we are better off flipping 1's to
                0's hence we set the number of flips to the number of ones
             */
            if (flips > ones) {
                flips = ones;
            }
            i++;
        }
        return flips;
    }
}
