public class longestRepeatingCharacterReplacement {
    /*
    Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
    In one operation, you can choose any character of the string and change it to any other uppercase English character.
    Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.

    Note:
        Both the string's length and k will not exceed 104.

    Example 1:
    Input:
    s = "ABAB", k = 2
    Output: 4
    Explanation:
    Replace the two 'A's with two 'B's or vice versa.

    Example 2:
    Input:
    s = "AABABBA", k = 1
    Output: 4
    Explanation:
    Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    The substring "BBBB" has the longest repeating letters, which is 4.
     */
    private static int characterReplacement(String s, int k) {
        int longest = 0;
        int[] s_freq = new int[26]; //array to hold the frequency of each character in s
        int largest_count = 0;

        int i = 0, j = 0; //window in s, i = start j = end

        while (j < s.length()) {
            char c = s.charAt(j);
            s_freq[c - 'A']++;  //increase the frequency count of the character c

            largest_count = Math.max(largest_count, s_freq[c - 'A']);   //take the largest frequency seen of a character in s

            /*
                the size of the window - the count of the most seen character gives us the number of k changes that has
                been made so far so when this number equals or exceeds the given k, we need to reduce the window from
                the start and reduce any character frequencies until the window and frequency is less than k
             */
            while (j - i + 1 - largest_count > k) {
                s_freq[s.charAt(i) - 'A']--;
                i++;
            }
            //update the longest substring and expand window
            longest = Math.max(longest, j - i + 1);
            j++;
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}
