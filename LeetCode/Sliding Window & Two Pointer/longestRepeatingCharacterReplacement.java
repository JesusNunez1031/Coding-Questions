public class longestRepeatingCharacterReplacement {
    /*
    You are given a string s and an integer k. You can choose any character of the string and change it to any other
    uppercase English character. You can perform this operation at most k times.

    Return the length of the longest substring containing the same letter you can get after performing the above operations.

    Example 1:
    Input: s = "ABAB", k = 2
    Output: 4
    Explanation: Replace the two 'A's with two 'B's or vice versa.

    Example 2:
    Input: s = "AABABBA", k = 1
    Output: 4
    Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.

    Constraints:
        1 <= s.length <= 10^5
        s consists of only uppercase English letters.
        0 <= k <= s.length
     */

    //TC: O(n)
    public int characterReplacement(String s, int k) {
        int longest = 0; //length of the longest substring containing the same letter
        int i = 0, j = 0; // end, i, and start, j, of the window
        char[] freq = new char[26]; //frequency of characters used in the window, used to update longest

        while (i < s.length()) {
            char c = s.charAt(i);

            /*
                if the count of the longest sequence needs to be updated, then we know the current ith character in the
                window does not need to use k, otherwise, we need to use a different alphabet letter, i.e. k
            */
            if (++freq[c - 'A'] > longest) {
                longest = freq[c - 'A'];
            } else {
                k--;
            }

            //if we have used more k's than available, reduce the window by one from the front, j, and increase k
            if (k < 0) {
                --freq[s.charAt(j) - 'A'];
                k++;
                j++;
            }
            i++;
        }
        //return the length of the window left after using or not using k
        return i - j;
    }
}
