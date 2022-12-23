package leetCode.slidingWindow_twoPointer;

public class longestSubstringWithAtLeastKRepeatingCharacters {
    /*
    Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each
    character in this substring is greater than or equal to k.

    Example 1:
    Input: s = "aaabb", k = 3
    Output: 3
    Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.

    Example 2:
    Input: s = "ababbc", k = 2
    Output: 5
    Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

    Constraints:
        1 <= s.length <= 10^4
        s consists of only lowercase English letters.
        1 <= k <= 10^5
     */
    private static int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }

        //call helper method to calculate the longest substring of k repeating characters
        return getLongest(s.toCharArray(), 0, s.length(), k);
    }

    private static int getLongest(char[] s, int start, int end, int k) {
        if (end - start < k) {
            return 0;
        }

        //array to hold the frequency of each letter in string s
        int[] freq = new int[26];

        //iterate the string from index start to end index to get frequency of the substring
        for (int i = start; i < end; i++) {
            freq[s[i] - 'a']++;
        }

        /*
            from the start of the string, we iterate until we find a character whose frequency is less than
            k and break the string into two substrings
        */
        for (int i = start; i < end; i++) {
            /*
                the first time a character who's frequency is less than k is encountered, the string s is divided from
                the start of s to where the found character's index and the second substring starts at the first character
                who's frequency is greater than or equal to k
             */
            if (freq[s[i] - 'a'] < k) {
                int j = i + 1;

                /*
                    while the character's frequency is less than k, move j forward so the new substring starts from
                    a character who's frequency is >= k
                 */
                while (j < end && freq[s[j] - 'a'] < k) {
                    j++;
                }
                /*
                    We call the method on itself to perform the same operations on each substring and compare the final
                    two result and return the longest length
                 */
                return Math.max(getLongest(s, start, i, k), getLongest(s, j, end, k));
            }
        }
        //return the length of the string or substring
        return end - start;
    }

    public static void main(String[] args) {
        String s = "ababbcaatbb";
        int k = 2;
        System.out.println(longestSubstring(s, k));
    }
}
