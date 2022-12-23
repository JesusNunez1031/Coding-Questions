package leetCode.strings;

public class ShiftingLetters {
    /*
    You are given a string s of lowercase English letters and an integer array shifts of the same length.

    Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
        - For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.

    Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.
    Return the final string after all such shifts to s are applied.

    Example 1:
    Input: s = "abc", shifts = [3,5,9]
    Output: "rpl"
    Explanation: We start with "abc".
    After shifting the first 1 letters of s by 3, we have "dbc".
    After shifting the first 2 letters of s by 5, we have "igc".
    After shifting the first 3 letters of s by 9, we have "rpl", the answer.

    Example 2:
    Input: s = "aaa", shifts = [1,2,3]
    Output: "gfd"


    Constraints:
        1 <= s.length <= 10^5
        s consists of lowercase English letters.
        shifts.length == s.length
        0 <= shifts[i] <= 10^9
     */
    //TC: O(n) where n is the length of s
    public String shiftingLetters(String s, int[] shifts) {
        int shift = 0;
        char[] str = s.toCharArray();

        /*
            as we progress through string s, we increase the number of shifts of every previous ith characters, so rather than
            going back to shift the previous i characters for every new shift value, we start from the end and increase
            the number of shifts for every new character so each character gets shifted the number of times it needs to
            shift just once
         */
        for (int i = shifts.length - 1; i >= 0; i--) {
            shift = (shift + shifts[i]) % 26; // %26 so any shift above 26 wraps back around

            /*
                take the character value of str[i] and shift it by "shift" steps, %26 to ensure values over 26 wrap back
                around and then + 'a' to get the actual char value
             */
            str[i] = (char) ((str[i] - 'a' + shift) % 26 + 'a');
        }
        return new String(str);
    }
}
