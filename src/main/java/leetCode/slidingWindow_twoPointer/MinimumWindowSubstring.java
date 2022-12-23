package leetCode.slidingWindow_twoPointer;

public class MinimumWindowSubstring {
    /*
    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
    character in t (including duplicates) is included in the window. If there is no such substring, return the empty
    string "".

    The testcases will be generated such that the answer is unique.

    A substring is a contiguous sequence of characters within the string.

    Example 1:
    Input: s = "ADOBECODEBANC", t = "ABC"
    Output: "BANC"
    Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

    Example 2:
    Input: s = "a", t = "a"
    Output: "a"
    Explanation: The entire string s is the minimum window.

    Example 3:
    Input: s = "a", t = "aa"
    Output: ""
    Explanation: Both 'a's from t must be included in the window.
    Since the largest window of s only has one 'a', return empty string.

    Constraints:
        m == s.length
        n == t.length
        1 <= m, n <= 10^5
        s and t consist of uppercase and lowercase English letters.

    Follow up: Could you find an algorithm that runs in O(m + n) time?
     */
    //TC: O(s + t) where s is the length of s and t is the length of t
    public String minWindow(String s, String t) {
        /*
            char array for the frequency of each character in t, this character array will help determine if a window in
            s needs to be expanded more or reduced
         */
        int[] tFreq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }

        int left = 0;  // start of window
        int right = 0; // end of window

        // start and end of the min window
        int minStart = -1;
        int minEnd = -1;

        int count = 0; // the number of times we get a character from s that is in t

        int[] sFreq = new int[128]; // keeps track of the characters in the window

        while (right < s.length()) {
            int rightChar = s.charAt(right);
            sFreq[rightChar]++; // add the current character to the window

            /*
                increase the count if after adding the current character, the current window still does not have all
                characters in t, or it just satisfied the condition.
             */
            if (sFreq[rightChar] <= tFreq[rightChar]) {
                count++;
            }

            // while the current window has all the characters in t
            while (count == t.length()) {
                /*
                    if this is our first window or the length of the current window is less than the current min window,
                    update the window start and end
                 */
                if (minStart == -1 || (right - left + 1) < (minEnd - minStart + 1)) {
                    minStart = left;
                    minEnd = right;
                }
                /*
                    move the left up by one to narrow the window, we do this until the window no longer has all characters
                    from t
                 */
                int leftChar = s.charAt(left++);
                sFreq[leftChar]--; // remove the left character from the current window

                // reduce count if the window no longer contains all characters in t
                if (sFreq[leftChar] < tFreq[leftChar]) {
                    count--;
                }
            }
            right++; // expand the window by moving to the next character
        }
        // return "" if no window was found, else return the substring of the min window
        return minStart == -1 ? "" : s.substring(minStart, minEnd + 1);
    }
}
