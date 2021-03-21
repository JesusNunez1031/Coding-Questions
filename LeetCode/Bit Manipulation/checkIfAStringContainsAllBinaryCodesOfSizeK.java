import java.util.HashSet;
import java.util.Set;

public class checkIfAStringContainsAllBinaryCodesOfSizeK {
    /*
    Given a binary string s and an integer k.
    Return True if every binary code of length k is a substring of s. Otherwise, return False.

    Example 1:
    Input: s = "00110110", k = 2
    Output: true
    Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at
    indices 0, 1, 3 and 2 respectively.

    Example 2:
    Input: s = "00110", k = 2
    Output: true

    Example 3:
    Input: s = "0110", k = 1
    Output: true
    Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.

    Example 4:
    Input: s = "0110", k = 2
    Output: false
    Explanation: The binary code "00" is of length 2 and doesn't exist in the array.

    Example 5:
    Input: s = "0000000001011100", k = 4
    Output: false

    Constraints:
        1 <= s.length <= 5 * 10^5
        s consists of 0's and 1's only.
        1 <= k <= 20
     */
    //TC: O(n * k) where n is the length of the string s and O(2^k) space used since we store 2^k binary codes
    public boolean hasAllCodes(String s, int k) {
        //shift the bit 1 to the left k times, this will give us the number of values we need to find in s range is from 0 - k
        int need = 1 << k; //2^k strings need to be counted

        //set to store all unique substring codes from 1 to k
        Set<String> codes = new HashSet<>();

        for (int i = k; i <= s.length(); i++) {
            //substring of k length in s, "binary code"
            String a = s.substring(i - k, i);
            System.out.println(a);

            //if the set does not contain the substring, add it and reduce the needed values
            if (!codes.contains(a)) {
                codes.add(a);
                need--;

                //return true when we've found all the codes of length k
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    //TC: O(n) using a rolling hash function and O(2^k) space used, since there are 2^k codes
    public boolean hasAllCodesRH(String s, int k) {
        //shift the bit 1 to the left k times, this will give us the number of values we need to find in s range is from 0 - k
        int need = 1 << k;

        //boolean array to mark all codes obtained, its size is 2^k since this is the number of codes we need to find
        boolean[] codes = new boolean[need];

        //binary value of all ones, e.g. 111, of length k
        int allOne = need - 1;

        //stores the hash value for a code, this allows us to use the rolling hash function
        int hashVal = 0;

        for (int i = 0; i < s.length(); i++) {
            /*
                calculate the hash for s.substring(i - k + 1, i + 1)
                new_hash = ((old_hash << 1) & all_one) | last_digit_of_new_hash

                i.e. we shift our old_hash left by one, get rid of the first digit in the shifted value so we &, and, old_hash with
                111, all_one, then we add the value of the last digit of the new hash by |, or, it with the current hash resulting
                in a rolling hash. We don't need to find a new substring at every step

                Ex: s = "00110110", k = 2
                    00 is the first has, we then need the hash for 01
                    1. so we start with 00, shift left, resulting in 000.
                    2. 000 & 11 results in 00
                    3. Finally, 00 | 1 = 01, since s.charAt(2) - '0' = 1

            */
            hashVal = ((hashVal << 1) & allOne) | (s.charAt(i) - '0');
            //System.out.println(hashVal);

            //hashVal only has a value when i - k + 1 > 0, check if we've never seen the current hash, if not set it to true and reduce need
            if (i >= k - 1 && !codes[hashVal]) {
                codes[hashVal] = true;
                need--;

                //return true when we've found all the codes of length k
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
