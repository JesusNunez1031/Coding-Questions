public class decodeStringAtIndex {
    /*
    An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:
    If the character read is a letter, that letter is written onto the tape.
    If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
    Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.


    Example 1:
    Input: S = "leet2code3", K = 10
    Output: "o"
    Explanation:
    The decoded string is "leetleetcodeleetleetcodeleetleetcode".
    The 10th letter in the string is "o".

    Example 2:
    Input: S = "ha22", K = 5
    Output: "h"
    Explanation:
    The decoded string is "hahahaha".  The 5th letter is "h".

    Example 3:
    Input: S = "a2345678999999999999999", K = 1
    Output: "a"
    Explanation:
    The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".

    Constraints:
        2 <= S.length <= 100
        S will only contain lowercase letters and digits 2 through 9.
        S starts with a letter.
        1 <= K <= 10^9
        It's guaranteed that K is less than or equal to the length of the decoded string.
        The decoded string is guaranteed to have less than 2^63 letters.
     */
    //TC: O(n) time and constant space used
    private static String decodeAtIndex(String s, int k) {
        if (k == 1 && Character.isLetter(s.charAt(0))) {
            return s.substring(0, 1);
        }
        //the size of the decoded string can be large so we make size "long" and not "int"
        long size = 0;

        //get the new size of s after decode
        for (char c : s.toCharArray()) {
           /*
            the given string to decode can be huge so it wont be possible to decode it entirely, so what we do instead is
            just find the size that the string would be if it were decoded. The size of the decoded string increases by
            one for every character and when a digit is encountered, the simulate a the string bing duplicated, we multiply
            the current size by the digit
            */
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }
        /*
            now that we have the size of the decoded string, we need to find the kth letter in the string, so what we do
            is work backwards reducing k by the size at every step, therefore, if k == 0 or k == size, and we are at a
            letter, we know we are at the kth required letter. The reason we mod k with the size is to keep k proportional
            to the current size of the string
            Ex:
                if the string to decode is ha22, k = 1, and the decoded size is 8
                step 1: c = 2, k = 1, size becomes = 4
                step 2: c = 2, k = 1, size becomes = 2
                step 3: c = 'a', k = 1, size = 1
                step 3: c = 'h', k % 1 = 0, so we return 'h'

            We decrease the size by 1 for every letter and divide the size by any digit encountered
         */
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= size;

            if ((k == 0 || k == size) && Character.isLetter(c)) {
                return Character.toString(c);
            }

            //when a digit is encountered, reduce the size by the value of the digit
            if (Character.isDigit(c)) {
                size /= c - '0';
            } else {
                size--;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "leet2code3";
        int k = 10;
        System.out.println(decodeAtIndex(s, k));
    }
}
